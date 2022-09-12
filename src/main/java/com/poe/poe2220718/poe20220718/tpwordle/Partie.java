package com.poe.poe2220718.poe20220718.tpwordle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Partie {
    
    public static int nombreTentativesMax = 5;
    
    private char[] motADeviner;
    private int nombreTentativesRestantes;
    private ArrayList<HistoriqueItem> historique;
    
    // On oblige à fournir le Mot à deviner lors de la création de la Partie
    public Partie(char[] motADeviner) {
        
        // conversion en minuscule pour sécuriser
        this.motADeviner = String.valueOf(motADeviner).toLowerCase().toCharArray();
        
        nombreTentativesRestantes = nombreTentativesMax;
        historique = new ArrayList<HistoriqueItem>();
    }
    
    /*  
    public StatutLettre[] jouer(char[] proposition){
        
        char[] cloneMotADeviner = new char[motADeviner.length];
        for(int i = 0; i< motADeviner.length; i++){
            cloneMotADeviner[i] = motADeviner[i];
        }
        
         
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
                cloneMotADeviner[i] = '?';
            } 
        }
       
        for(int i=0; i<proposition.length; i++){
            for(int j=0; j<motADeviner.length ; j++){
                if(cloneMotADeviner[j]==proposition[i]){
                    resultat[i] = StatutLettre.MAL_PLACE;
                    cloneMotADeviner[j] = '?';
                    break;
                }
            }
        }
            
        
        return resultat;
    }
   */
    
    public StatutLettre[] jouer(char[] proposition){
          // conversion en minuscule pour sécuriser
        proposition = String.valueOf(proposition).toLowerCase().toCharArray();
        
        // initilisation tableau qui affiche resultat d'une proposition
        StatutLettre[] resultat = new StatutLettre[proposition.length];
        for(int i = 0; i<resultat.length ; i++){
            resultat[i] = StatutLettre.ABSENT;
        }
        
        // compter le nombre d'occurrences d'une même lettre 
        // puis on décrementera chaque fois qu'elle passera au 'vert'
        Map<Character, Integer> quantiteRestantes = new HashMap<Character, Integer>();
        for(int i=0 ; i<motADeviner.length ; i++){
            Integer quantite = quantiteRestantes.get(motADeviner[i]);
            if(quantite==null)
                quantite = 0;
            quantiteRestantes.put(motADeviner[i], quantite+1);
        }
        
        // on parcoure les lettres de la proposition du joueur : pour les lettres 'vertes'
        for(int i=0; i<proposition.length; i++){
           
            // on a déviné !
            if(proposition[i]==motADeviner[i]){
                resultat[i] = StatutLettre.BIEN_PLACE;
                
                Integer quantite = quantiteRestantes.get(motADeviner[i]);
                quantiteRestantes.put(motADeviner[i], quantite-1);
            } 
        }
        
        
        // on parcoure les lettres de la proposition du joueur pour les lettres 'oranges'
        for(int i=0; i<proposition.length; i++){
           if(resultat[i] != StatutLettre.BIEN_PLACE) {
                for(int j=0; j<motADeviner.length ; j++){
                    if(motADeviner[j]==proposition[i]){
                        //ATTENTION il ne faut pas compter la lettre si elle est deja trouvée
                        if(quantiteRestantes.get(motADeviner[j])>0){

                            resultat[i] = StatutLettre.MAL_PLACE;

                            Integer quantite = quantiteRestantes.get(motADeviner[j]);
                            quantiteRestantes.put(motADeviner[j], quantite-1);
                        }
                        break;
                    }
                }
           }
        }
        
        nombreTentativesRestantes--;
        historique.add(new HistoriqueItem(proposition, resultat));
        return resultat;
    }
    
    public StatutLettre[] getDernierStatut() {
        return historique.get(historique.size()-1).getResultatProposition();
    }
    
    public boolean motDevine(){
        
        StatutLettre[] statut = getDernierStatut();
        for(int i=0; i<statut.length; i++){
            if(statut[i] != StatutLettre.BIEN_PLACE){
                return false;
            }
        }
        return true;
    }
    
    public boolean nombreTentativesMaxAtteint() {
        return nombreTentativesRestantes == 0;
    }

    public char[] getMotADeviner() {
        return motADeviner;
    }

    public ArrayList<HistoriqueItem> getHistorique() {
        return historique;
    }

    public int getNombreTentativesRestantes() {
        return nombreTentativesRestantes;
    }
    
    
}
