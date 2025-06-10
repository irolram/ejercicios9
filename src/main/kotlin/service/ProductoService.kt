package prgog2425.dam1.RepoGit.service

import prgog2425.dam1.RepoGit.data.dao.IProductoDao

class ProductoService(private val producto: IProductoDao): IProductoService {
    override fun insertarProducto(nombre: String, precio: Double, stock: Int): Boolean {
        try {
            require(nombre.isNotEmpty()){ "El nombre no puede estar vacio"}
            require(precio > 0 ){ "El precio no puede ser menor que 0"}
            require(stock > 0) { "El stock no puede ser menor que 0" }
            producto.insertarProducto(nombre, precio, stock)
        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun mostrarProductoUsuario(nombre: String): Boolean {
        try {
            require(nombre.isNotEmpty()){ "El nombre no puede estar vacio"}
                producto.mostrarProductoUsuario(nombre)
        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun eliminarProducto(precio: Double): Boolean {
        try {
            require(precio > 0 ){ "El precio no puede ser menor que 0"}
            producto.eliminarProducto(precio)

        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun modificarPrecioProducto(nombre: String, precio: Double): Boolean {
        try {
            require(nombre.isNotEmpty()){ "El nombre no puede estar vacio"}
            require(precio > 0 ){ "El precio no puede ser menor que 0"}
            producto.modificarPrecioProducto(nombre, precio)
        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun modificarProductoNombre(id: Int, nombre: String): Boolean {
        try {
            require(id > 0) { "ID debe ser mayor de 0" }
            require(nombre.isNotEmpty()){ "El nombre no puede estar vacio"}
            producto.modificarProductoNombre(id, nombre)

        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }

    override fun modificarPrecioDoble(nombre: String): Boolean {
        try {
            require(nombre.isNotEmpty()){ "El nombre no puede estar vacio"}
            producto.modificarPrecioDoble(nombre)

        }catch (e:Exception){
            println(e.message)
            return false
        }
        return true
    }
}