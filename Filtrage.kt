fun filtrerCommandes(
    commandes: List<Commande>,
    critere: (Commande) -> Boolean
): List<Commande> {
    return commandes.filter(critere)
}

fun estPayee(c: Commande): Boolean {
    return c.statut == "PAID"
}
