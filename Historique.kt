import java.io.File

fun ecrireHistorique(client: Client, commandes: List<Commande>) {
    var texte = ""

    for (commande in commandes) {
        if (commande.client.id == client.id) {
            texte += "Numero: ${commande.numero}, "
            texte += "Date: ${commande.date}, "
            texte += "Produit: ${commande.produit.nom}, "
            texte += "Quantite: ${commande.quantite}, "
            texte += "Montant: ${commande.montantTotal()}, "
            texte += "Statut: ${commande.statut}\n"
        }
    }

    File("Client${client.id}.txt").writeText(texte)
}
