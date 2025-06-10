package prgog2425.dam1.RepoGit.service

interface IUsuarioService {

    fun insertarUsuario(nombre: String, email:String):Boolean
    fun eliminarUsuario(nombre: String):Boolean
}