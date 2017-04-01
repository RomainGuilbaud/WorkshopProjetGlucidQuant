package com.ynov.android.gluciddiab.calculUtils;

/**
 * Created by romain on 31/03/2017.
 */

public class Produit {
    private String name;
    private int glucideLent;
    private int glucideRapide;
    private String categorie;
    private float proportion;

    public Produit(String name, int glucideLent, int glucideRapide, String categorie, float proportion) {
        this.name = name;
        this.glucideLent = glucideLent;
        this.glucideRapide = glucideRapide;
        this.categorie = categorie;
        this.proportion = proportion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGlucideLent() {
        return glucideLent;
    }

    public void setGlucideLent(int glucideLent) {
        this.glucideLent = glucideLent;
    }

    public int getGlucideRapide() {
        return glucideRapide;
    }

    public void setGlucideRapide(int glucideRapide) {
        this.glucideRapide = glucideRapide;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getProportion() {
        return proportion;
    }

    public void setProportion(float proportion) {
        this.proportion = proportion;
    }
}
