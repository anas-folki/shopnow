class Commande(
    val numero: Int,
    val date: String,
    val client: Client,
    val produit: Produit,
    val quantite: Int
) {
    var statut: String = "CREATED"
        private set

    fun montantTotal(): Double {
        return produit.prixTTC() * quantite
    }

    fun payer(): Boolean {
        if (statut == "CREATED" && produit.retirerStock(quantite)) {
            statut = "PAID"
            return true
        }
        return false
    }

    fun expedier(): Boolean {
        if (statut == "PAID") {
            statut = "SHIPPED"
            return true
        }
        return false
    }

    fun annuler(): Boolean {
        if (statut == "SHIPPED") {
            return false
        }

        if (statut == "PAID") {
            produit.ajouterStock(quantite)
        }

        statut = "CANCELLED"
        return true
    }
}
