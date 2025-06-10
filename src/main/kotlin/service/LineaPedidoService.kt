package prgog2425.dam1.RepoGit.service

import prgog2425.dam1.RepoGit.data.dao.ILineaPedidoDao

class LineaPedidoService(private val lineapedido: ILineaPedidoDao): ILineaPedidoService {


    override fun insertarLineaPedido(idPedido: Int, idProducto: Int, cantidad: Int, precio: Double): Boolean {

        try {
            require(idPedido > 0) { "ID debe ser mayor de 0" }
            require(idProducto > 0) { "ID debe ser mayor de 0" }
            require(cantidad > 0) { "Cantidad de ser mayor de 0" }
            require(precio > 0) { "Precio debe ser mayor de 0" }
            lineapedido.insertarLineaPedido(idPedido,idProducto,cantidad,precio)
        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun mostrarLineaPedido(id: Int): Boolean {

        try {
            require(id > 0) { "ID debe ser mayor de 0" }
            lineapedido.mostrarLineaPedido(id)
        }catch (e:Exception){
            println(e.message)
            return false
        }
            return true
    }

    override fun modificarLineaPedido(id: Int): Boolean {
        try {
            require(id > 0) { "ID debe ser mayor de 0" }
            lineapedido.modificarLineaPedido(id)
        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }
}