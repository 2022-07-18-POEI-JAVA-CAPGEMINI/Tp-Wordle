package com.poe.poe2220718.poe20220718.tpwordle;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PartieTest {

    @Test
    public void testFinPartiePerdante() {
        Partie partie = new Partie("hello".toCharArray());
        for(int i = 0 ; i<Partie.nombreTentativesMax ; i++) {
            partie.jouer("salut".toCharArray());    
        }
        assertFalse(partie.motDevine());
        assertTrue(partie.nombreTentativesMaxAtteint());  
    }
    
    @Test
    public void testFinPartieGagnante() {
        Partie partie = new Partie("hello".toCharArray());
        
        partie.jouer("salut".toCharArray()); 
        partie.jouer("salut".toCharArray());
        partie.jouer("hello".toCharArray());
       
        assertTrue(partie.motDevine());
        assertFalse(partie.nombreTentativesMaxAtteint());  
    }
}
