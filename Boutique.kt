class Boutique {
    private val produits = mutableListOf<Produit>()

    fun indiceProduit(code: String): Int {
        for (i in produits.indices) {
            if (produits[i].code == code) {
                return i
            }
        }
        return -1
    }

    fun ajouter(p: Produit): Boolean {
        if (indiceProduit(p.code) != -1) {
            return false
        }

        produits.add(p)
        return true
    }

    fun supprimer(code: String): Boolean {
        val indice = indiceProduit(code)

        if (indice == -1) {
            return false
        }

        produits.removeAt(indice)
        return true
    }

    fun supprimer(p: Produit): Boolean {
        return supprimer(p.code)
    }

    fun nombreProduitsElectroniques(): Int {
        var nombre = 0

        for (produit in produits) {
            if (produit is ProduitElectronique) {
                nombre++
            }
        }

        return nombre
    }
}
