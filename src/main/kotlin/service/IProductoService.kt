package prgog2425.dam1.RepoGit.service

interface IProductoService {

    fun insertarProducto(nombre: String, precio:Double, stock:Int):Boolean
    fun mostrarProductoUsuario(nombre:String):Boolean
    fun eliminarProducto(precio:Double): Boolean
    fun modificarPrecioProducto(nombre:String,precio: Double):Boolean
    fun modificarProductoNombre(id:Int, nombre: String): Boolean
    fun modificarPrecioDoble(nombre:String): Boolean
}