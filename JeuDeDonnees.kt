fun jeuDeDonnees(): List<Commande> {
    val amine = Client(1, "Amine", "Safi")
    val sara = Client(2, "Sara", "Marrakech")
    val hicham = Client(3, "Hicham", "Rabat")
    val rania = Client(4, "Rania", "Agadir")

    val laptop = ProduitElectronique("E1", "Laptop", 5000.0, 100, 24)
    val phone = ProduitElectronique("E2", "Phone", 2000.0, 100, 12)
    val riz = ProduitAlimentaire("A1", "Riz", 20.0, 1000, "2027-01-01")
    val lait = ProduitAlimentaire("A2", "Lait", 10.0, 500, "2026-12-01")

    val c1 = Commande(1, "2026-10-01", amine, laptop, 1)
    c1.payer()

    val c2 = Commande(2, "2026-10-02", sara, phone, 1)
    c2.payer()

    val c3 = Commande(3, "2026-10-03", amine, riz, 10)
    c3.payer()

    val c4 = Commande(4, "2026-10-04", hicham, laptop, 2)
    c4.payer()
    c4.annuler()

    val c5 = Commande(5, "2026-10-05", sara, lait, 20)

    val c6 = Commande(6, "2026-10-06", rania, phone, 3)
    c6.payer()

    val c7 = Commande(7, "2026-10-07", amine, lait, 10)
    c7.annuler()

    val c8 = Commande(8, "2026-10-08", hicham, riz, 100)
    c8.payer()

    return listOf(c1, c2, c3, c4, c5, c6, c7, c8)
}
