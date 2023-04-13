package Applikation.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DestilleringTest {

    private Destillering destillering;




    @Test
    void TC1_fordelVæske() {

        // Arrange
        Fad fad = new Fad("Cherry,", 2, "Morten", 50);
        Destillering destillering1 = new Destillering("Destillering 4", LocalDate.of(2023, 04, 13), LocalDate.of(2023, 04, 14), "Maltbatch", "Byg", "Mette", 5, 50, "Rygemateriale", "Det er den første efter påske");

        // Act
        destillering1.fordelVæske(fad);

        // Assert
        assertEquals(5, fad.getNuværendeVolume());
        assertEquals(0, destillering1.getMængdevæske());
    }

    @Test
    void TC2_fordelVæske() {

        // Arrange
        Fad fad = new Fad("Cherry,", 2, "Morten", 15);
        Destillering destillering1 = new Destillering("Destillering 4", LocalDate.of(2023, 04, 13), LocalDate.of(2023, 04, 14), "Maltbatch", "Byg", "Mette", 10, 50, "Rygemateriale", "Det er den første efter påske");


        // Act
        destillering1.fordelVæske(fad);

        // Assert
        //fail("Der er for lidt væske til at påfylde fadet");
    }

    @Test
    void TC3_fordelVæske() {

        // Arrange
        Fad fad = new Fad("Cherry,", 2, "Morten", 100);
        Destillering destillering1 = new Destillering("Destillering 4", LocalDate.of(2023, 04, 13), LocalDate.of(2023, 04, 14), "Maltbatch", "Byg", "Mette", 10, 50, "Rygemateriale", "Det er den første efter påske");

        // Act
        destillering1.fordelVæske(fad);
        assertEquals(10, fad.getNuværendeVolume() + destillering1.getMængdevæske());

        Fad fad2 = new Fad("Cherry,", 2, "Morten", 100);
        assertThrows(RuntimeException.class, () -> {
            destillering1.fordelVæske(fad2);
        });

        // Assert
        assertEquals(10, fad.getNuværendeVolume());
    }

    @Test
    void TC4_fordelVæske() {

        // Arrange
        Fad fad = new Fad("Cherry,", 2, "Morten", 5);

        fad.setNuværendeVolume(5);

        destillering = new Destillering("Destillering 4", LocalDate.of(2023, 04, 13), LocalDate.of(2023, 04, 14), "Maltbatch", "Byg", "Mette", 10, 50, "Rygemateriale", "Det er den første efter påske");

        // Act
        destillering.fordelVæske(fad);

        // Assert
       // fail("Fadet er ikke tomt");


    }



    }
