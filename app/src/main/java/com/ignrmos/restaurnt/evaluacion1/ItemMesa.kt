package com.ignrmos.restaurnt.evaluacion1

open class ItemMesa(val itemMenu: ItemMenu, val cantidad : Int) : ItemMenu(itemMenu.nombre, itemMenu.precio) {
    fun calcularSubtotal(): Int {
        return cantidad * precio
    }
}