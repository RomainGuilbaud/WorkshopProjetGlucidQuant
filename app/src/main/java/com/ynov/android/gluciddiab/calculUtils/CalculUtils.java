package com.ynov.android.gluciddiab.calculUtils;

public class CalculUtils {

    protected int[] proportionCalcul(Produit p){
        double totalGL=(p.getGlucideLent()/p.getProportion())-(p.getGlucideRapide()/p.getProportion());
        double totalGR=p.getGlucideRapide()/p.getProportion();
        return new int[]{(int)totalGL,(int)totalGR};
    }

    public int[] gluTotal(Panier panier){
        int totalGL=0;
        int totalGR=0;
        for (Produit p: panier.getProduits()) {
            int[] totaux=this.proportionCalcul(p);
            totalGL+=totaux[0];
            totalGR+=totaux[1];
        }
        return new int[]{(int)totalGL,(int)totalGR};
    }

}