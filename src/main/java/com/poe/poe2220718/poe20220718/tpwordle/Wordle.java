package com.poe.poe2220718.poe20220718.tpwordle;

public class Wordle {
    
    DictionaireDeMots dictionnaire = new DictionaireDeMotsSansBaseDeDonnees();
    
    
    public void jouerPartie() {
        
        char[] motADeviner = dictionnaire.obtenirUnMotAleatoirement();
        Partie partie = new Partie(motADeviner);
        
        // Demander au joueur une proposition
        // ... à compléter...
        
        // Verifier : partie.jouer(proposition)
        // ... à compléter...
    }
}
