package prgog2425.dam1.RepoGit.data.bd

import org.h2.jdbcx.JdbcDataSource
import java.sql.Connection
import java.sql.SQLException

object Database {

    const val url = "jdbc:h2:./data/Latienda"
    const val user = "sa"
    const val password = ""

    val dataSource = JdbcDataSource()

    init {
        dataSource.setURL(url)
        dataSource.user = user
        dataSource.password = password

    }

    fun getConexion():Connection? {
        var connection: Connection? = null
        try {
            connection = dataSource.connection
            return connection
        }catch (e:SQLException){
            println("Error: ${e.message}")
        }
        return null
    }

    fun closeConnection(connection: Connection?) {
        try {
            connection?.close()
        }catch (e:SQLException){
            println("Error: ${e.message}")
        }
    }


}