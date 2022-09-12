package com.poe.poe2220718.poe20220718.tpwordle;

public class HistoriqueItem {
    
    private char[] proposition;
    private StatutLettre[] resultatProposition;
    
    public HistoriqueItem(char[] proposition, StatutLettre[] resultatProposition){
        this.proposition = proposition;
        this.resultatProposition = resultatProposition;
    }

    public char[] getProposition() {
        return proposition;
    }

    public void setProposition(char[] proposition) {
        this.proposition = proposition;
    }

    public StatutLettre[] getResultatProposition() {
        return resultatProposition;
    }

    public void setResultatProposition(StatutLettre[] resultatProposition) {
        this.resultatProposition = resultatProposition;
    }
    
    
}
