package prgog2425.dam1.RepoGit.data.dao

import prgog2425.dam1.RepoGit.data.bd.Database
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import java.sql.SQLException

class ProductoDao: IProductoDao {

    init {
        crearTabla()
    }

    override fun crearTabla():Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""CREATE TABLE IF NOT EXISTS PRODUCTO (
                |ID INTEGER PRIMARY KEY AUTO_INCREMENT,
                |NOMBRE VARCHAR NOT NULL,
                |PRECIO DECIMAL NOT NULL,
                |STOCK INTEGER NOT NULL
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
        println("Tabla producto creada")
        return true
    }

    override fun insertarProducto(nombre: String, precio:Double, stock:Int): Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""INSERT INTO PRODUCTO (NOMBRE, PRECIO, STOCK) VALUES (?,?,?)""")

                stmt.setString(1, nombre)
                stmt.setDouble(2, precio)
                stmt.setInt(3, stock)
                stmt.executeUpdate()
            }
        }catch (e: SQLException){
            println(e.message)
            return false
        }finally {
            Database.closeConnection(connection)
            stmt?.close()
        }
        println("Producto insertado con exito")
        return true
    }

    override fun mostrarProductoUsuario(nombre:String): Boolean {

        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null
        var rs: ResultSet? = null
        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""SELECT P.NOMBRE AS NOMBRE_PRODUCTO,U.NOMBRE AS NOMBRE_USUARIO FROM PRODUCTO P 
                                                        |JOIN LINEAPEDIDO L 
                                                        |ON L.IDPRODUCTO = P.ID
                                                        |JOIN PEDIDO PE 
                                                        |ON L.IDPEDIDO = PE.ID
                                                        |JOIN USUARIO U 
                                                        |ON U.ID = PE.IDUSUARIO
                                                        |WHERE P.NOMBRE = ?
            """.trimMargin())

                stmt.setString(1, nombre)
                rs = stmt.executeQuery()
                while (rs.next()) {
                    val nombreProducto = rs.getString("NOMBRE_PRODUCTO")
                    val nombreUsuario = rs.getString("NOMBRE_USUARIO")
                    println("Producto: $nombreProducto, nombre del comprador: $nombreUsuario")
                }
            }
        }catch (e: SQLException){
            println(e.message)
            return false
        }finally {
            rs?.close()
            stmt?.close()
            Database.closeConnection(connection)
        }

        return true

    }

    override fun eliminarProducto(precio: Double): Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        if (connection != null) {
            try {

                stmt = connection.prepareStatement(""" DELETE FROM PRODUCTO WHERE PRECIO = ?""")

                stmt.setDouble(1, precio)
                stmt.executeUpdate()

            }catch (e: SQLException){
                println(e.message)
                return false
            }finally {
                stmt?.close()
                Database.closeConnection(connection)
            }
        }
        return true
    }

    override fun modificarPrecioProducto(nombre: String, precio: Double): Boolean {

        var connection:Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        if (connection != null) {
            try {
                stmt = connection.prepareStatement("""UPDATE PRODUCTO SET PRECIO = ? WHERE NOMBRE = ?""")

                stmt.setDouble(1, precio)
                stmt.setString(2, nombre)
                stmt.executeUpdate()


            }catch (e: SQLException){
                println(e.message)
                return false
            }
        }
        return true
    }

    override fun modificarProductoNombre(id:Int, nombre: String): Boolean {

        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        if (connection != null) {
            try {

                stmt = connection.prepareStatement("""UPDATE PRODUCTO SET NOMBRE = ? WHERE ID = ?""")
                stmt.setString(1, nombre)
                stmt.setInt(2, id)
                stmt.executeUpdate()

            }catch (e: SQLException){
                println(e.message)
                return false
            }finally {
                stmt?.close()
                Database.closeConnection(connection)
            }
        }
        return true
    }

    override fun modificarPrecioDoble(nombre: String): Boolean {

        var connection:Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null
        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""UPDATE PRODUCTO SET PRECIO = PRECIO * 2 WHERE NOMBRE = ?""")

                stmt.setString(1, nombre)
                stmt.executeUpdate()

            }
        }catch (e:SQLException){
            println(e.message)
            return false
        }finally {

            stmt?.close()
            Database.closeConnection(connection)
        }
        return true
    }
}