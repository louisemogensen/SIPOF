package Applikation.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {

    private Fad fad;
    private Destillering destillering;

    @Test
    void TC1_fordelVæske() {

        // Arrange
        fad = new Fad("Cherry", 2, "Morten", 1200);
        destillering = new Destillering("Destillering 2", LocalDate.of(2023, 04, 13), LocalDate.of(2023, 04, 14), "Maltbatch", "Byg", "Mette", 50, 50, "Rygematriale", "Kommentar: Første destillering efter påske");

        // Act
        destillering.fordelVæske(fad);

        // Assert
        assertEquals(0, fad.getNuværendeVolume()); //Tjekker om væskemængden på fadet er 0.
        assertTrue(destillering.getMængdevæske() < fad.getMaxVolume()); //Undersøger, om betingelsen er opfyldt

        //Vi oplever her en fejl, hvor testen siger, at den nuværende volume er det samme som maxvolumen, hvilket ikke er korrekt. Vi kan ikke finde vores fejl.

    }


    @Test
    void TC2_fordelVæske() {

        // Arrange
        fad = new Fad("Cherry", 2, "Morten", 100);
        destillering = new Destillering("Destillering 2", LocalDate.of(2023, 04, 13), LocalDate.of(2023, 04, 14), "Maltbatch", "Byg", "Mette", 0, 50, "Rygematriale", "Kommentar: Første destillering efter påske");

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            fad.setNuværendeVolume(50);
            destillering.fordelVæske(fad);
        });
        assertEquals(exception.getMessage(), "Du kan kun fylde på et tomt fad");

    }

    @Test
    void TC3_fordelVæske() {

        // Arrange
        fad = new Fad("Cherry", 2, "Morten", 100);
        destillering = new Destillering("Destillering 2", LocalDate.of(2023, 04, 13), LocalDate.of(2023, 04, 14), "Maltbatch", "Byg", "Mette", 200, 50, "Rygematriale", "Kommentar: Første destillering efter påske");

        // Act & Assert
        Exception exception = assertThrows(RuntimeException.class, () -> {
            destillering.fordelVæske(fad);
        });
        assertEquals(exception.getMessage(), "Der er ikke plads til mængden af væske på fadet");

    }
}