package prgog2425.dam1.RepoGit.app

import prgog2425.dam1.RepoGit.service.ILineaPedidoService
import prgog2425.dam1.RepoGit.service.IPedidoService
import prgog2425.dam1.RepoGit.service.IProductoService
import prgog2425.dam1.RepoGit.service.IUsuarioService
import prgog2425.dam1.RepoGit.ui.IConsola
import prgog2425.dam1.RepoGit.utils.Ayuda.menuLineaPedido
import prgog2425.dam1.RepoGit.utils.Ayuda.menuPedido
import prgog2425.dam1.RepoGit.utils.Ayuda.menuProducto
import prgog2425.dam1.RepoGit.utils.Ayuda.menuUsuario
import prgog2425.dam1.RepoGit.utils.Ayuda.mostrarMenuPrincipal
import prgog2425.dam1.RepoGit.utils.Ayuda.pedirDoubleValido
import prgog2425.dam1.RepoGit.utils.Ayuda.pedirIntValido

class Controlador(val ui: IConsola, private val productoService: IProductoService,
                  private val usuarioService: IUsuarioService,
                  private val pedidoService: IPedidoService,
                  private val lineaPedidoService: ILineaPedidoService) {

    fun menuPrincipal(){
        var salir = true
        while (salir) {

            mostrarMenuPrincipal(ui)
            try {
                var opcion = readLine()?.toIntOrNull()

                when (opcion) {
                    1-> menuUsuario()
                    2-> menuPedido()
                    3-> menuProducto()
                    4-> menuLineaPedido()
                    null -> println("Opción no válida. Debe ser un número.")

                    else -> salir = false
                }
            }catch(e:Exception){
                println(e.message)
            }
        }
    }

    fun menuUsuario(){
        var salir = true
        while (salir) {
            menuUsuario(ui)

            var opcion = readLine()?.toIntOrNull()
            when (opcion) {
                1-> {
                    ui.mostrar("Ingrese el usuario: ")
                    val usuario = readLine().toString()
                    ui.mostrar("Ingrese el email")
                    val email = readLine().toString()
                    usuarioService.insertarUsuario(usuario, email)
                }
                2-> {
                    ui.mostrar("Nombre del usuario a eliminar: ")
                    val usuario = readLine().toString()
                    usuarioService.eliminarUsuario(usuario)
                }
                0->{
                    ui.mostrar("Regresando al menú principal")
                    salir = false
                }
                else -> ui.mostrar("Número invalido")
            }
        }
    }

    fun menuPedido(){
        var salir = true
        while (salir) {
            menuPedido(ui)
            var opcion = readLine()?.toIntOrNull()
            when (opcion) {
                1-> {
                    val precio = pedirDoubleValido("Precio del pedido: ")
                    val id = pedirIntValido("Id del usuario")
                    pedidoService.insertarPedido(precio,id)
                }
                2-> {
                    val id = pedirIntValido("Id del pedido")
                    pedidoService.eliminarPedido(id)
                }
                3-> {
                    ui.mostrar("Ingrese el usuario: ")
                    val usuario = readLine().toString()
                    pedidoService.mostrarImporteTotal(usuario)
                }
                0-> {
                    ui.mostrar("Regresando al menú principal")
                    salir = false
                }
                else -> ui.mostrar("Número invalido")
            }
        }
    }

    fun menuProducto(){
        var salir = true
        while (salir) {
            menuProducto(ui)
            var opcion = readLine()?.toIntOrNull()
            when (opcion) {
                1->{
                    ui.mostrar("Ingrese el producto: ")
                    val nombre = readLine().toString()
                    val precio = pedirDoubleValido("Precio del producto: ")
                    val stock = pedirIntValido("Stock del producto: ")
                    productoService.insertarProducto(nombre, precio, stock)
                }
                2-> {
                    ui.mostrar("Ingrese el producto a buscar: ")
                    val nombreProducto = readLine().toString()
                    productoService.mostrarProductoUsuario(nombreProducto)
                }
                3-> {
                    val precio = pedirDoubleValido("Precio del producto a eliminar: ")
                    productoService.eliminarProducto(precio)

                }
                4-> {
                    ui.mostrar("Ingrese el producto: ")
                    val nombre = readLine().toString()
                    val precio = pedirDoubleValido("Precio del producto a modificar: ")
                    productoService.modificarPrecioProducto(nombre, precio)
                }
                5->{
                    val idProducto = pedirIntValido("Id del producto: ")
                    ui.mostrar("Ingrese el nombre del producto: ")
                    val nombre = readLine().toString()
                    productoService.modificarProductoNombre(idProducto, nombre)
                }
                6->{
                    ui.mostrar("Ingrese el nombre del producto: ")
                    val nombre = readLine().toString()
                    productoService.modificarPrecioDoble(nombre)
                }
                0-> {
                    ui.mostrar("Regresando al menú principal")
                    salir = false
                }
                else -> ui.mostrar("Número invalido")
            }
        }
    }

    fun menuLineaPedido(){
        var salir = true
        while (salir) {
            menuLineaPedido(ui)
            var opcion = readLine()?.toIntOrNull()
            when (opcion) {
                1->{
                    val idPedido = pedirIntValido("Id del pedido: ")
                    val idProducto = pedirIntValido("Id del producto: ")
                    val cantidad = pedirIntValido("Cantidad del pedido: ")
                    val precio = pedirDoubleValido("Precio del pedido: ")
                    lineaPedidoService.insertarLineaPedido(idPedido,idProducto,cantidad,precio)
                }
                2->{
                    val id = pedirIntValido("Introduce el id de la linea de pedido: ")
                    lineaPedidoService.mostrarLineaPedido(id)
                }
                3->{
                    val id = pedirIntValido("Introduce el id de la linea de pedido a modificar: ")
                    lineaPedidoService.modificarLineaPedido(id)
                }
                0-> {
                    ui.mostrar("Regresando al menú principal")
                    salir = false
                }
                else -> ui.mostrar("Número invalido")
            }
        }
    }

}