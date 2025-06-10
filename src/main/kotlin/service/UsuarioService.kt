package prgog2425.dam1.RepoGit.service

import prgog2425.dam1.RepoGit.data.dao.IUsuarioDao
import prgog2425.dam1.RepoGit.utils.Ayuda.esEmailValido

class UsuarioService(private val usuario: IUsuarioDao):IUsuarioService {
    override fun insertarUsuario(nombre: String, email: String): Boolean {
        try {
            require(nombre.isNotEmpty()) { "Nombre no puede estar vacio" }
            require(esEmailValido(email)) { "Email inválido" }
            usuario.insertarUsuario(nombre, email)

        }catch (e:IllegalArgumentException) {
            println(e.message)
            return false
        }
        return true
    }

    override fun eliminarUsuario(nombre: String): Boolean {

        try {
            require(nombre.isNotEmpty()) { "Nombre no puede estar vacio" }
            usuario.eliminarUsuario(nombre)
        }catch (e:IllegalArgumentException) {
            println(e.message)
            return false
        }
        return true
    }
}