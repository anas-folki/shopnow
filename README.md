# ShopNow — TP Kotlin simple

**Nom :** Anas Folki

## Contenu du projet

- Jalon 1 : classes et relations (diagramme ci-dessous).
- Jalon 2 : classe abstraite `Produit`, héritage, prix TTC, remise et stock.
- Jalon 3 : `Client` et `Commande`, paiement, expédition et annulation.
- Jalon 4 : scénario de test dans `Main.kt`.
- Partie Boutique : ajout, recherche et suppression des produits.
- Partie Analyse des ventes : `forEach`, `map`, `filter`, `sortedBy`, `any`, `all`, `sumOf`, `maxByOrNull`, `distinct`, `take`, `groupBy`.
- Partie Extensions et lambdas : validation du numéro, affichage en DH et filtrage.
- Bonus 2 : création du fichier d'historique.

## Diagramme simple

```text
             Produit (abstract)
               /          \\
              /            \\
ProduitElectronique    ProduitAlimentaire
        |
     Remisable

Client 1 -------- plusieurs Commandes
Commande -------- 1 Client
Commande -------- 1 Produit
Boutique -------- plusieurs Produits
```

## Comment lancer le projet

1. Créer un projet Kotlin dans IntelliJ IDEA.
2. Copier tous les fichiers `.kt` dans le même dossier `src`.
3. Ouvrir `Main.kt`.
4. Lancer la fonction `main()`.

Le fichier `Client2.txt` est créé automatiquement quand le programme arrive à la partie historique.

## Notes

- Le statut reste un `String` (`CREATED`, `PAID`, `SHIPPED`, `CANCELLED`), comme demandé dans la partie principale du TP.
- Le bonus `enum` n'est pas activé pour garder la version principale du TP simple.
- Les fonctions d'ordre supérieur demandées dans la partie Analyse sont conservées, mais écrites directement et sans fonctions compliquées supplémentaires.
- Les captures d'écran des tests doivent être prises dans la console après l'exécution du programme.
