package prgog2425.dam1.RepoGit.data.dao

import prgog2425.dam1.RepoGit.data.bd.Database
import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.SQLException

class UsuarioDao: IUsuarioDao {

    init {
        crearTabla()
    }

    override fun crearTabla():Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""CREATE TABLE IF NOT EXISTS USUARIO (
                |ID INTEGER PRIMARY KEY AUTO_INCREMENT,
                |NOMBRE VARCHAR NOT NULL,
                |EMAIL VARCHAR NOT NULL
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
        println("Tabla usuario creada")
        return true
    }

    override fun insertarUsuario(nombre: String, email:String): Boolean {

        var connection:Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null

        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""INSERT INTO USUARIO(NOMBRE, EMAIL) VALUES (?,?)""")
                stmt.setString(1, nombre)
                stmt.setString(2, email)
                stmt.executeUpdate()
            }
        }catch (e: SQLException){
            println(e.message)
            return false
        }finally {
            Database.closeConnection(connection)
            stmt?.close()
        }
        println("Usuario insertado con exito")
        return true
    }

    override fun eliminarUsuario(nombre: String): Boolean {
        var connection: Connection? = Database.getConexion()
        var stmt: PreparedStatement? = null
        try {
            if (connection != null) {
                stmt = connection.prepareStatement("""DELETE FROM USUARIO WHERE NOMBRE = ?""")
                stmt.setString(1, nombre)
                stmt.executeUpdate()
            }
        }catch (e: SQLException){
            println(e.message)
            return false
        }finally {
            Database.closeConnection(connection)
            stmt?.close()
        }
        return true
    }
}