package prgog2425.dam1.RepoGit

import prgog2425.dam1.RepoGit.app.Controlador
import prgog2425.dam1.RepoGit.data.dao.LineaPedidoDao
import prgog2425.dam1.RepoGit.data.dao.PedidoDao
import prgog2425.dam1.RepoGit.data.dao.ProductoDao
import prgog2425.dam1.RepoGit.data.dao.UsuarioDao
import prgog2425.dam1.RepoGit.service.LineaPedidoService
import prgog2425.dam1.RepoGit.service.PedidoService
import prgog2425.dam1.RepoGit.service.ProductoService
import prgog2425.dam1.RepoGit.service.UsuarioService
import prgog2425.dam1.RepoGit.ui.Consola


fun main() {


    Controlador(Consola(),ProductoService(ProductoDao()),
        UsuarioService(UsuarioDao()),
        PedidoService(PedidoDao()),
        LineaPedidoService(LineaPedidoDao())
        ).menuPrincipal()

}