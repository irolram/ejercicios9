package prgog2425.dam1.RepoGit.data.dao

import prgog2425.dam1.RepoGit.data.bd.Database
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class PedidoDao: IPedidoDao {

    init {
        crearTabla()
    }

    override fun crearTabla():Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""CREATE TABLE IF NOT EXISTS PEDIDO (
                |ID INTEGER PRIMARY KEY AUTO_INCREMENT,
                |PRECIOTOTAL DECIMAL NOT NULL,
                |IDUSUARIO INTEGER NOT NULL,
                |FOREIGN KEY (IDUSUARIO) REFERENCES USUARIO(ID) ON DELETE CASCADE        
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
        println("Tabla pedido creada")

        return true
    }

    override fun insertarPedido(precioTotal: Double, idUsuario:Int): Boolean {

        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null
        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""INSERT INTO PEDIDO (PRECIOTOTAL, IDUSUARIO) VALUES (?,?)""")

                stmt.setDouble(1, precioTotal)
                stmt.setInt(2, idUsuario)
                stmt.executeUpdate()
            }
        }catch (e: SQLException){
            println(e.message)
            return false
        }finally {
            Database.closeConnection(connection)
            stmt?.close()
        }
        println("Pedido insertado con exito")
        return true
    }

     override fun mostrarImporteTotal(nombre:String):Boolean {

        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null
        var rs:ResultSet? = null

        if (connection != null) {
            try {
                stmt = connection.prepareStatement("""SELECT U.NOMBRE AS NOMBRE_USUARIO, SUM(P.PRECIOTOTAL) FROM PEDIDO P 
                                                            |JOIN USUARIO U 
                                                            |ON P.IDUSUARIO = U.ID
                                                            |WHERE U.NOMBRE = ?
                                                            |GROUP BY U.NOMBRE
                """.trimMargin())

                stmt.setString(1, nombre)
                rs = stmt.executeQuery()

                while (rs.next()){
                    val usuario = rs.getString(1)
                    val precioTotal = rs.getDouble(2)
                    println("usuario: $usuario, precio total: $precioTotal")
                }

            }catch (e: SQLException){
                println(e.message)
                return false
            }finally {
                rs?.close()
                stmt?.close()
                Database.closeConnection(connection)

            }
        }

        return true

    }

    override fun eliminarPedido(id: Int): Boolean {

        var connection: Connection? = Database.getConexion()

        var stmt: PreparedStatement? = null

        if (connection != null){
            try {

                connection.autoCommit = false
                stmt = connection.prepareStatement("""DELETE FROM LINEAPEDIDO WHERE IDPEDIDO = ?""")
                stmt.setInt(1, id)
                stmt.executeUpdate()

                stmt = connection.prepareStatement("""DELETE FROM PEDIDO WHERE ID = ?""")
                stmt.setInt(1, id)
                stmt.executeUpdate()


                connection.commit()

            }catch (e: SQLException){
                println(e.message)
                connection.rollback()
                return false
            }finally {
                stmt?.close()
                Database.closeConnection(connection)
            }

        }
        return true
    }
}