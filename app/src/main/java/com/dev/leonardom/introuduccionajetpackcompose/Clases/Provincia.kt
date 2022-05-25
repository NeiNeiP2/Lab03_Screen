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
            "Arequipa", true, true,
            true
        ),
        Provi(
            "Camana", true, true,
            true
        ),
        Provi(
            "Caraveli", false, true,
            true
        ),
        Provi(
            "Castilla", false, true,
            true
        ),
        Provi(
            "LaUnion", false, true,
            true
        ),
        Provi(
            "Condesuyos", false, true,
            true
        ),
        Provi(
            "Islay", true, true,
            true
        ),
        Provi(
            "Caylloma", true, true,
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
