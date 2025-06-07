package prgog2425.dam1.RepoGit.data.dao

interface IUsuarioDao {

    fun crearTabla():Boolean
    fun insertarUsuario(nombre: String, email:String):Boolean
    fun eliminarUsuario(nombre: String):Boolean
}