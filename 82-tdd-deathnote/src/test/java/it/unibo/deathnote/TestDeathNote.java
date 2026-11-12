package it.unibo.deathnote;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestDeathNote {
    private DeathNoteImpl deathNote;
    private static String DANILO_PIANINI = "Danilo Pianini";
    private static String MIRKO_VIROLI = "Mirko Viroli";

    @BeforeEach 
    void setUp(){
        deathNote = new DeathNoteImpl();
    }

    @Test 
    void testNonExistingRules(){
        assertThrows(IllegalArgumentException.class,() -> deathNote.getRule(0));
        assertThrows(IllegalArgumentException.class,() -> deathNote.getRule(-1));
        assertThrows(IllegalArgumentException.class,() -> deathNote.getRule(deathNote.RULES.size() + 1));
    }

    @Test 
    void testNoRuleNullOrEmpty(){
        for (String elem : deathNote.RULES) {
            assertNotEquals(null, elem);
            assertNotEquals("", elem);
        }
    }

    @Test
    void testFunctioningWriting(){
        assertFalse(deathNote.isNameWritten(DANILO_PIANINI));
        deathNote.writeName(DANILO_PIANINI);
        assertTrue(deathNote.isNameWritten(DANILO_PIANINI));
        assertFalse(deathNote.isNameWritten(MIRKO_VIROLI));
        assertFalse(deathNote.isNameWritten(""));
    }

    @Test
    void testKillingHumans(){
        assertThrows(IllegalStateException.class,() -> deathNote.writeDeathCause(""));
        deathNote.writeName(DANILO_PIANINI);
        assertEquals("heart attack", deathNote.getDeathCause(DANILO_PIANINI));
        deathNote.writeName(MIRKO_VIROLI);
        assertTrue(deathNote.writeDeathCause("karting accident"));
        assertEquals("karting accident", deathNote.getDeathCause(MIRKO_VIROLI));
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        assertFalse(deathNote.writeDeathCause("bike accident"));
    }

    @Test
    void testDescription(){
        assertThrows(IllegalStateException.class, () -> deathNote.writeDetails("fell on knife"));
        deathNote.writeName(DANILO_PIANINI);
        assertEquals("", deathNote.getDeathDetails(DANILO_PIANINI));
        assertTrue(deathNote.writeDetails("ran for too long"));
        assertEquals("ran for too long", deathNote.getDeathDetails(DANILO_PIANINI));
        deathNote.writeName(MIRKO_VIROLI);
        try {
            Thread.sleep(6100);
        } catch (InterruptedException e) {
        }
        /* TODO: try to change the details verify that the details have not been changed*/
    }
}