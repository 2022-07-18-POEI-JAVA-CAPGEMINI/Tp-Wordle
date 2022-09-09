package com.poe.poe2220718.poe20220718.tpwordle;

public class Partie {
    
    private char[] motADeviner;
    
    // On oblige à fournir le Mot à deviner lors de la création de la Partie
    public Partie(char[] motADeviner) {
        this.motADeviner = motADeviner;
    }
    
    public StatutLettre[] jouer(char[] proposition){
        
        // que faire si taille proposition est différente de taille motADeviner
        
        // initilisation tableau qui affiche resultat d'une proposition
        StatutLettre[] resultat = new StatutLettre[proposition.length];
        for(int i = 0; i<resultat.length ; i++){
            resultat[i] = StatutLettre.ABSENT;
        }
        
        // on parcoure les lettres de la proposition du joueur
        for(int i=0; i<proposition.length; i++){
           
            // on a déviné !
            if(proposition[i]==motADeviner[i]){
                resultat[i] = StatutLettre.BIEN_PLACE;
            } 
            else { // Est ce que cette lettre existe ailleurs dans le mot à deviner
                for(int j=0; j<motADeviner.length ; j++){
                    if(motADeviner[j]==proposition[i]){
                        resultat[i] = StatutLettre.MAL_PLACE;
                    }
                }
            }
        }
        
        return resultat;
    }

}
