package com.dev.leonardom.introuduccionajetpackcompose.Clases

object Provincia {
    data class Provi(
        val nombre: String,
        val bomberos: Boolean,
        val comisaria: Boolean,
        val refugio: Boolean
    )

    private val provs: MutableList<Provi> = mutableListOf(
        Provi(
            "Arequipa", true, false,
            true
        ),
        Provi(
            "Provincia 2", true, false,
            true
        ),

        )

    fun getListIterator(): MutableListIterator<Provi> {
        return provs.listIterator()
    }

    fun getProvincia(nom: String): Provi {
        provs.forEach() {
            if (nom == it.nombre) {
                return it
            }
        }
        return provs[0];
    }
}
