package com.poe.poe2220718.poe20220718.tpwordle;

import java.util.Random;

public class DictionaireDeMotsSansBaseDeDonnees implements DictionaireDeMots {
    
    private String[] dictionnaire = { "salut", "bonju", "coool", "poule", "loupe", "rouge", 
            "route", "prout", "moule", "range" } ;

    public char[] obtenirUnMotAleatoirement() {
        
        Random random = new Random();
        int index = random.nextInt(dictionnaire.length);
        String mot = dictionnaire[index];
        return mot.toCharArray();
    }
}
