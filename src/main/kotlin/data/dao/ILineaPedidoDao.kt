package prgog2425.dam1.RepoGit.data.dao

interface ILineaPedidoDao {

    fun crearTabla():Boolean
    fun insertarLineaPedido( idPedido:Int,idProducto:Int, cantidad:Int, precio:Double, ):Boolean
    fun mostrarLineaPedido(id:Int):Boolean
    fun modificarLineaPedido(id:Int): Boolean
}