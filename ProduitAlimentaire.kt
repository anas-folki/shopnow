class ProduitAlimentaire(
    code: String,
    nom: String,
    prixHT: Double,
    stock: Int,
    val dateLimite: String
) : Produit(code, nom, prixHT, stock) {

    override fun prixTTC(): Double {
        return prixHT * 1.10
    }
}
