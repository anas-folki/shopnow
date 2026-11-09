fun commandesDuClient(commandes: List<Commande>, client: String): List<Commande> {
    return commandes.filter { it.client.nom == client }
}

fun totalPayees(commandes: List<Commande>): Double {
    return commandes.filter { it.statut == "PAID" }.sumOf { it.montantTotal() }
}

fun totalAnnulees(commandes: List<Commande>): Double {
    return commandes.filter { it.statut == "CANCELLED" }.sumOf { it.montantTotal() }
}
