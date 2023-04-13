package Applikation.Controller;

import Applikation.Model.Destillering;
import Applikation.Model.Fad;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {

    @Test
    @Order(1)
    void createFad() {
        // Arrange
        String tidligereIndhold = "Rom";
        int fadnummer = 1;
        String fadleverandør = "Bent Brandt";
        double maxVolume = 200.0;
        Controller controller = new Controller();

        // Act
        Fad fad = controller.createFad(tidligereIndhold, fadnummer, fadleverandør, maxVolume);

        // Assert
        assertEquals(tidligereIndhold, fad.getFadtype());
        assertEquals(fadnummer, fad.getFadnummer());
        assertEquals(fadleverandør, fad.getFadleverandør());
        assertEquals(maxVolume, fad.getMaxVolume(), 0.001);
    }

    @Test
    @Order(2)
    public void testCreateFadNull() {
        // Arrange
        String tidligereIndhold = "Rom";
        Integer fadnummer = null;
        String fadleverandør = "Bent Brandt";
        Double maxVolume = null;
        Controller controller = new Controller();

        // Act
        Fad fad = controller.createFad(tidligereIndhold, fadnummer, fadleverandør, maxVolume);

        // Assert
        assertNull(fad);
    }

    @Test
    @Order(3)
    void createDestillation() {
        //Arrange
        LocalDate startdato = LocalDate.of(2023, 4, 14);
        LocalDate slutdato = LocalDate.of(2023, 4, 15);
        String maltbatch = "20";
        String kornsort = "byg";
        String medarbejder = "Anders";
        double mængdevæske = 50;
        double alkoholprocent = 52.2;
        String rygemateriale = "Tørv";
        String kommentar = null;

        //Assert
        Destillering destillering = Controller.createDestillering(startdato, slutdato, maltbatch, kornsort, medarbejder, mængdevæske, alkoholprocent, rygemateriale, kommentar);

        //Act
        assertNotNull(destillering);
        assertEquals(startdato, destillering.getStartdato());
        assertEquals(slutdato, destillering.getSlutdato());
        assertEquals(maltbatch, destillering.getMaltbatch());
        assertEquals(kornsort, destillering.getKornsort());
        assertEquals(medarbejder, destillering.getMedarbejder());
        assertEquals(mængdevæske, destillering.getMængdevæske(), 0.001);
        assertEquals(alkoholprocent, destillering.getAlkoholprocent(), 0.001);
        assertEquals(rygemateriale, destillering.getRygemateriale());
        assertNull(destillering.getKommentar());
    }

    @Test
    @Order(4)
    void createNullDestillation(){}

    @Test
    @Order(5)
    void createWrongDateDestillation(){
        //Arrange
        LocalDate startdato = LocalDate.of(2023, 4, 15);
        LocalDate slutdato = LocalDate.of(2023, 4, 14);
        String maltbatch = "20";
        String kornsort = "byg";
        String medarbejder = "Anders";
        double mængdevæske = 50;
        double alkoholprocent = 52.2;
        String rygemateriale = "Tørv";
        String kommentar = null;

        //Assert
        Destillering destillering = Controller.createDestillering(startdato, slutdato, maltbatch, kornsort, medarbejder, mængdevæske, alkoholprocent, rygemateriale, kommentar);

        //Act
        assertNotNull(destillering);
        assertEquals(startdato, destillering.getStartdato());
        assertEquals(slutdato, destillering.getSlutdato());
        assertEquals(maltbatch, destillering.getMaltbatch());
        assertEquals(kornsort, destillering.getKornsort());
        assertEquals(medarbejder, destillering.getMedarbejder());
        assertEquals(mængdevæske, destillering.getMængdevæske(), 0.001);
        assertEquals(alkoholprocent, destillering.getAlkoholprocent(), 0.001);
        assertEquals(rygemateriale, destillering.getRygemateriale());
        assertNull(destillering.getKommentar());
    }
 }