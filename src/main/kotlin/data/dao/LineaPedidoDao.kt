package prgog2425.dam1.RepoGit.data.dao

import prgog2425.dam1.RepoGit.data.bd.Database
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class LineaPedidoDao: ILineaPedidoDao {

    init {
        crearTabla()
    }

    override fun crearTabla():Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""CREATE TABLE IF NOT EXISTS LINEAPEDIDO (
                |ID INTEGER PRIMARY KEY AUTO_INCREMENT,
                |CANTIDAD INTEGER NOT NULL,
                |PRECIO DECIMAL NOT NULL,
                |IDPEDIDO INTEGER NOT NULL,
                |IDPRODUCTO INTEGER NOT NULL,
                |FOREIGN KEY (IDPEDIDO) REFERENCES PEDIDO(ID) ON DELETE CASCADE,
                |FOREIGN KEY (IDPRODUCTO) REFERENCES PRODUCTO(ID) ON DELETE CASCADE        
                |)""".trimMargin())

                stmt.execute()
            }

        }catch (e: SQLException){
            println(e.message)
            return false
        }finally {
            Database.closeConnection(connection)
            stmt?.close()
        }
        println("Tabla lineaPedido creada")

        return true
    }

    override fun insertarLineaPedido(idPedido: Int, idProducto: Int, cantidad: Int, precio: Double): Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""INSERT INTO LINEAPEDIDO (CANTIDAD, PRECIO, IDPEDIDO, IDPRODUCTO) VALUES  (?,?,?,?)""")

                stmt.setInt(1,cantidad)
                stmt.setDouble(2,precio)
                stmt.setInt(3,idPedido)
                stmt.setInt(4,idProducto)
                stmt.executeUpdate()
            }
        }catch (e: SQLException){
            println(e.message)
            return false
        }finally {
            Database.closeConnection(connection)
            stmt?.close()
        }
        println("LineaPedido insertada con exito")
        return true
    }

    override fun mostrarLineaPedido(id:Int): Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null
        var rs: ResultSet? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""SELECT * FROM LINEAPEDIDO WHERE ID = ?""")

                stmt.setInt(1,id)

                rs =stmt.executeQuery()
                while (rs.next()){
                    val id = rs.getInt("ID")
                    val cantidad = rs.getInt("CANTIDAD")
                    val precio = rs.getDouble("PRECIO")
                    val IDPEDID = rs.getInt("IDPEDIDO")
                    val IDPRODUCTO = rs.getInt("IDPRODUCTO")
                    println("Id: $id, cantidad: $cantidad, precio: $precio, idpedido: $IDPEDID, idproducto: $IDPRODUCTO")
                }
            }
        }catch (e: SQLException){
            println(e.message)
            return false
        }
        return true
    }

    override fun modificarLineaPedido(id: Int): Boolean {
        var connetion: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        if (connetion != null) {
            try {

                stmt = connetion.prepareStatement("""UPDATE LINEAPEDIDO SET IDPEDIDO = ?""")
                stmt.setInt(1,id)
                stmt.executeUpdate()

            }catch (e: SQLException){
                println(e.message)
                return false
            }
        }
        return true
    }

}