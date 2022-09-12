package com.poe.poe2220718.poe20220718.tpwordle;

public class WordleVersionConsole {

    
    public static void main(String[] args) {
        
        DictionaireDeMots dictionnaire = new DictionaireDeMotsSansBaseDeDonnees();
         
        char[] motADeviner = dictionnaire.obtenirUnMotAleatoirement();
        Partie partie = new Partie(motADeviner);
        
        // Demander au joueur une proposition
        // ... à compléter...
        
        // Verifier : partie.jouer(proposition)
        // ... à compléter...
    }
}
