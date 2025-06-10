package prgog2425.dam1.RepoGit.utils

import prgog2425.dam1.RepoGit.ui.IConsola

object Ayuda {

    fun mostrarMenuPrincipal(consola:IConsola){
        consola.mostrar("MENÚ PRINCIPAL")
        consola.mostrar("1- Usuario")
        consola.mostrar("2- Pedido")
        consola.mostrar("3- Producto")
        consola.mostrar("4- LineaPedido")
        consola.mostrar("0 - Salir")

        consola.mostrar("Seleccione una opción: ")
    }
    fun menuUsuario(consola:IConsola){

        consola.mostrar("MENÚ USUARIO")
        consola.mostrar("1- Insertar Usuario")
        consola.mostrar("2- Eliminar Usuario")
        consola.mostrar("0. Volver al menú principal")

        consola.mostrar("Seleccione una opción: ")


    }
    fun menuPedido(consola:IConsola){

        consola.mostrar("MENU PEDIDO")
        consola.mostrar("1- Insertar Pedido")
        consola.mostrar("2- Eliminar Pedido")
        consola.mostrar("3- Mostrar Importe Total")
        consola.mostrar("0. Volver al menú principal")

        consola.mostrar("Seleccione una opción: ")

    }
    fun menuProducto(consola:IConsola){

            consola.mostrar("MENÚ PRODUCTO ")
            consola.mostrar("1. Insertar producto")
            consola.mostrar("2. Mostrar productos de un usuario")
            consola.mostrar("3. Eliminar producto por precio")
            consola.mostrar("4. Modificar precio del producto")
            consola.mostrar("5. Modificar nombre del producto")
            consola.mostrar("6. Duplicar precio del producto")
        consola.mostrar("0. Volver al menú principal")

        consola.mostrar("Seleccione una opción: ")


    }
    fun menuLineaPedido(consola:IConsola){

        consola.mostrar("MENÚ LÍNEA DE PEDIDO ")
        consola.mostrar("1. Insertar línea de pedido")
        consola.mostrar("2. Mostrar línea de pedido")
        consola.mostrar("3. Modificar línea de pedido")
        consola.mostrar("0. Volver al menú principal")

        consola.mostrar("Seleccione una opción:")

    }
    fun esEmailValido(email: String): Boolean {
        val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$".toRegex()
        return regex.matches(email)
    }
    fun pedirDoubleValido(double: String): Double {
        while (true) {
            print(double)
            val input = readLine()
            val valor = input?.toDoubleOrNull()
            if (valor != null) {
                return valor
            }
            println("Entrada inválida, por favor ingresa un número decimal válido.")
        }
    }

    fun pedirIntValido(int: String): Int {
        while (true) {
            print(int)
            val input = readLine()
            val valor = input?.toIntOrNull()
            if (valor != null) {
                return valor
            }
            println("Entrada inválida, por favor ingresa un número entero válido.")
        }
    }


}