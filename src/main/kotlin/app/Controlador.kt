package prgog2425.dam1.RepoGit.app

import prgog2425.dam1.RepoGit.ui.IConsola
import prgog2425.dam1.RepoGit.utils.ayuda
import prgog2425.dam1.RepoGit.utils.ayuda.menuLineaPedido
import prgog2425.dam1.RepoGit.utils.ayuda.menuPedido
import prgog2425.dam1.RepoGit.utils.ayuda.menuProducto
import prgog2425.dam1.RepoGit.utils.ayuda.menuUsuario
import prgog2425.dam1.RepoGit.utils.ayuda.mostrarMenuPrincipal

class Controlador(val ui: IConsola) {

    fun menuPrincipal(){
        var salir = true
        while (salir) {

            mostrarMenuPrincipal(ui)
            try {
                var opcion = readLine()?.toIntOrNull() ?: null

                when (opcion) {
                    1-> menuUsuario()
                    2-> menuPedido()
                    3-> menuProducto()
                    4-> menuLineaPedido()
                    else -> salir = false
                }
            }catch(e:Exception){}
        }
    }


}