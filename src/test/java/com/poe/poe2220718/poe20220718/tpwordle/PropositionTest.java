package com.poe.poe2220718.poe20220718.tpwordle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PropositionTest {

    @Test
    public void testPasEncoreGagne() {

        Partie partie = new Partie("hello".toCharArray());
        StatutLettre[] resultat = partie.jouer("salut".toCharArray());
        assertEquals(StatutLettre.ABSENT, resultat[0]);
        assertEquals(StatutLettre.BIEN_PLACE, resultat[2]);
    }

    @Test
    public void testGagne() {

        Partie partie = new Partie("hello".toCharArray());
        StatutLettre[] resultat = partie.jouer("hello".toCharArray());
        for (int i = 0; i < resultat.length; i++) {
            assertEquals(StatutLettre.BIEN_PLACE, resultat[i]);
        }
    }

    // marie
    // lemma
    @Test
    public void testMarie() {
        Partie partie = new Partie("marie".toCharArray());
        StatutLettre[] resultat = partie.jouer("lemma".toCharArray());
        // Résultat attendu:
        // ABSENT   MAL_PLACE MAL_PLACE ABSENT MAL_PLACE
        assertEquals(StatutLettre.ABSENT, resultat[0]);
        assertEquals(StatutLettre.MAL_PLACE, resultat[1]);
        assertEquals(StatutLettre.MAL_PLACE, resultat[2]);
        assertEquals(StatutLettre.ABSENT, resultat[3]);   //<------
        assertEquals(StatutLettre.MAL_PLACE, resultat[4]);
    }
    
    
    // theme
    // lemma
    @Test
    public void testTheme() {
        Partie partie = new Partie("theme".toCharArray());
        StatutLettre[] resultat = partie.jouer("lemma".toCharArray());
        // Résultat attendu:
        // ABSENT   MAL_PLACE MAL_PLACE ABSENT MAL_PLACE
        assertEquals(StatutLettre.ABSENT, resultat[0]);
        assertEquals(StatutLettre.MAL_PLACE, resultat[1]);
        assertEquals(StatutLettre.ABSENT, resultat[2]);   // <-------
        assertEquals(StatutLettre.BIEN_PLACE, resultat[3]);
        assertEquals(StatutLettre.ABSENT, resultat[4]);
    }
    
    @Test
    public void testPasSlaut() {

        Partie partie = new Partie("hello".toCharArray());
        StatutLettre[] resultat = partie.jouer("slaut".toCharArray());
        assertEquals(StatutLettre.ABSENT, resultat[0]);
        assertEquals(StatutLettre.MAL_PLACE, resultat[1]);
        assertEquals(StatutLettre.ABSENT, resultat[2]);
    }
    
    @Test
    public void testPasLlaut() {

        Partie partie = new Partie("hello".toCharArray());
        StatutLettre[] resultat = partie.jouer("llaut".toCharArray());
        assertEquals(StatutLettre.MAL_PLACE, resultat[0]);
        assertEquals(StatutLettre.MAL_PLACE, resultat[1]);
        assertEquals(StatutLettre.ABSENT, resultat[2]);
    }
    
    @Test
    public void testTroisLettresIdentiques() {

        Partie partie = new Partie("lello".toCharArray());
        StatutLettre[] resultat = partie.jouer("laaut".toCharArray());
        assertEquals(StatutLettre.BIEN_PLACE, resultat[0]);
        assertEquals(StatutLettre.ABSENT, resultat[1]);
        assertEquals(StatutLettre.ABSENT, resultat[2]);
    }
    @Test
    public void testTroisLettresIdentiquesBis() {

        Partie partie = new Partie("helol".toCharArray());
        StatutLettre[] resultat = partie.jouer("alaut".toCharArray());
        assertEquals(StatutLettre.ABSENT, resultat[0]);
        assertEquals(StatutLettre.MAL_PLACE, resultat[1]);
        assertEquals(StatutLettre.ABSENT, resultat[2]);
    }
}
