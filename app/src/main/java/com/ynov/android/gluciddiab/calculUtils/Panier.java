package com.ynov.android.gluciddiab.calculUtils;

/**
 * Created by romain on 31/03/2017.
 */

public class Panier {
    private Produit[] produits;

    public Panier(Produit[] produits) {
        this.produits = produits;
    }

    public Produit[] getProduits() {
        return produits;
    }

    public void setProduits(Produit[] produits) {
        this.produits = produits;
    }
}
