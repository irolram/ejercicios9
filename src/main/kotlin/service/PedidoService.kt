package prgog2425.dam1.RepoGit.service

import prgog2425.dam1.RepoGit.data.dao.IPedidoDao

class PedidoService(private val pedido: IPedidoDao): IPedidoService {
    override fun insertarPedido(precioTotal: Double, idUsuario: Int): Boolean {
        try {
            require(precioTotal > 0){ "El precio total debe ser mayor de 0" }
            require(idUsuario > 0) { "El idUsuario debe ser mayor de 0" }
            pedido.insertarPedido(precioTotal, idUsuario)
        }catch (e:IllegalArgumentException){
            println(e.message)
            return false
        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun mostrarImporteTotal(nombre: String): Boolean {
        try {
            require(nombre.isNotEmpty()) { "El nombre no puede estar vacio." }
            pedido.mostrarImporteTotal(nombre)
        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun eliminarPedido(id: Int): Boolean {

        try {
            require(id > 0){ "El id no puede estar vacio." }
            pedido.eliminarPedido(id)

        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }
}