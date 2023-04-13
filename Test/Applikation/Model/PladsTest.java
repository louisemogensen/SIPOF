package Applikation.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PladsTest {

    private Lager lager = new Lager("SWD", 50);
    private Plads plads;

    @Test
    void getReolnummer() {
        // Arrange
        plads = new Plads(1, 1, lager);

        // Act
        plads.getReolnummer();

        // Assert
        assertTrue(plads.getReolnummer() == reolnummer);
    }

    @Test
    void setReolnummer() {
    }

    @Test
    void getPladsnummer() {
    }

    @Test
    void setPladsnummer() {
    }

    @Test
    void getLager() {
    }

    @Test
    void setLager() {
    }

    @Test
    void getFad() {
    }

    @Test
    void setFad() {
    }

    @Test
    void testToString() {
    }
}