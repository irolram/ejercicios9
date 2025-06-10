package prgog2425.dam1.RepoGit.service

interface IPedidoService {

    fun insertarPedido(precioTotal: Double, idUsuario:Int): Boolean
    fun mostrarImporteTotal(nombre:String):Boolean
    fun eliminarPedido(id: Int):Boolean
}