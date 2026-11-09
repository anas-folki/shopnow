fun main() {
    println("===== 1. PRODUITS =====")
    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 10, 24)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 100, "2027-01-01")

    println(laptop.prixTTC()) // attendu : 6000.0
    println(riz.prixTTC())    // attendu : 22.0

    laptop.appliquerRemise(10.0)
    println(laptop.prixHT)   // attendu : 4500.0
    println(laptop.prixTTC()) // attendu : 5400.0

    println(laptop.retirerStock(3)) // true
    println(laptop.stock)           // 7
    laptop.ajouterStock(3)
    println(laptop.stock)           // 10

    println("\n===== 2. CLIENT ET COMMANDES =====")
    val sara = Client(2, "Sara", "Marrakech")
    val commande1 = Commande(101, "2026-10-10", sara, laptop, 2)

    println(commande1.statut)        // CREATED
    println(commande1.montantTotal()) // 10800.0 après remise
    println(commande1.payer())       // true
    println(commande1.statut)        // PAID
    println(laptop.stock)            // 8
    println(commande1.expedier())    // true
    println(commande1.annuler())     // false

    val commande2 = Commande(102, "2026-10-11", sara, laptop, 20)
    println(commande2.payer())       // false : stock insuffisant

    val commande3 = Commande(103, "2026-10-12", sara, laptop, 3)
    println(commande3.payer())       // true
    println(laptop.stock)            // 5
    println(commande3.annuler())     // true
    println(laptop.stock)            // 8

    println("\n===== 3. BOUTIQUE =====")
    val boutique = Boutique()
    val phone = ProduitElectronique("E2", "Phone", 2000.0, 20, 12)

    println(boutique.ajouter(laptop)) // true
    println(boutique.ajouter(laptop)) // false : même code
    println(boutique.ajouter(riz))    // true
    println(boutique.ajouter(phone))  // true
    println(boutique.indiceProduit("A1")) // 1
    println(boutique.nombreProduitsElectroniques()) // 2
    println(boutique.supprimer("A1")) // true
    println(boutique.supprimer(laptop)) // true
    println(boutique.nombreProduitsElectroniques()) // 1

    println("\n===== 4. ANALYSE DES VENTES =====")
    val commandes = jeuDeDonnees()

    commandes.forEach {
        println("${it.client.nom} : ${it.montantTotal()}")
    }

    val montants = commandes.map { it.montantTotal() }
    println(montants)

    println(commandes.filter { it.montantTotal() > 1000 }.map { it.numero })
    println(commandes.sortedBy { it.montantTotal() }.map { it.numero })
    println(commandes.sortedByDescending { it.montantTotal() }.map { it.numero })

    println(commandes.any { it.statut == "CANCELLED" }) // true
    println(commandes.all { it.statut == "PAID" }) // false

    val totalSafi = commandes
        .filter { it.client.ville == "Safi" && it.statut == "PAID" }
        .sumOf { it.montantTotal() }
    println(totalSafi) // 6220.0

    val plusGrosse = commandes
        .filter { it.statut == "PAID" }
        .maxByOrNull { it.montantTotal() }
    println(plusGrosse?.client?.nom) // Rania

    val clientsAnnulation = commandes
        .filter { it.statut == "CANCELLED" }
        .map { it.client.nom }
        .distinct()
    println(clientsAnnulation) // [Hicham, Amine]

    val troisPlusGrosses = commandes
        .filter { it.statut == "PAID" }
        .sortedByDescending { it.montantTotal() }
        .take(3)
    troisPlusGrosses.forEach {
        println("${it.client.nom} : ${it.montantTotal()}")
    }

    val parVille = commandes
        .filter { it.statut == "PAID" }
        .groupBy { it.client.ville }
        .mapValues { groupe -> groupe.value.sumOf { it.montantTotal() } }
    println(parVille)

    println(commandesDuClient(commandes, "Amine").size) // 3
    println(totalPayees(commandes)) // 18020.0
    println(totalAnnulees(commandes)) // 12110.0

    println("\n===== 5. EXTENSIONS =====")
    println("+212600000000".isValidPhoneNumber()) // true
    println("0600000000".isValidPhoneNumber()) // false
    println(1200.0.toDh()) // 1200.0 dhs

    println("\n===== 6. FILTRAGE AVEC FONCTION =====")
    val grosses = filtrerCommandes(commandes) { c -> c.montantTotal() > 1000 }
    println(grosses.size) // 5

    val safi = filtrerCommandes(commandes) { it.client.ville == "Safi" }
    println(safi.size) // 3

    val payees = filtrerCommandes(commandes, ::estPayee)
    println(payees.size) // 5

    println("\n===== 7. HISTORIQUE =====")
    ecrireHistorique(sara, commandes)
    println("Historique écrit dans Client2.txt")
}
