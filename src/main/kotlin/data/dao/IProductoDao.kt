package prgog2425.dam1.RepoGit.data.dao

interface IProductoDao {

    fun crearTabla():Boolean
    fun insertarProducto(nombre: String, precio:Double, stock:Int):Boolean
    fun mostrarProductoUsuario(nombre:String):Boolean
    fun eliminarProducto(precio:Double): Boolean
    fun modificarPrecioProducto(nombre:String,precio: Double):Boolean
}