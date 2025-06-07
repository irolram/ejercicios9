package prgog2425.dam1.RepoGit.data.dao

interface IPedidoDao {

    fun crearTabla():Boolean
    fun insertarPedido(precioTotal: Double, idUsuario:Int): Boolean
    fun mostrarImporteTotal(nombre:String):Boolean
    fun eliminarPedido(id: Int):Boolean
}