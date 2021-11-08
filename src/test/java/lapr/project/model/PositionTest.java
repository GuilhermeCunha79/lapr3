package lapr.project.model;

import lapr.project.utils.DTO.PositionDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;


class PositionTest {


    @Test
    public void checkPosition() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 1, 1, 2.4f, 2.4f, 0, "A");
        new Position(dto);
    }

    @Test
    public void PositionEmpty() {
        Position position = new Position();
    }

    @Test
    public void garanteeMmsi9Chars() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PositionDTO dto = new PositionDTO(1111111181, "VARAMO", 2, 2, 70, 1, 1, "A");
            new Position(dto);
        });
        Assertions.assertEquals("The MMSI code must have 9 number digits", thrown.getMessage());
    }

    @Test
    public void garanteeNullShipIsntCreatedWithoutTransciverClass() throws NullPointerException {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            PositionDTO dto = new PositionDTO(222222222, "31/12/2020 17:19", 1, 1, 2.4, 2.4, 0, null);
            new Position(dto);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void garanteeNullShipIsntCreatedWithoutDate() throws NullPointerException {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, null, 1, 1, 2.4, 2.4, 0, "A");
            new Position(dto);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void garanteeLatitudeBetween90And_90() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 120, 1, 2.4, 2.4, 0, "A");
            new Position(dto);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void garanteeLongitudeBetween180And_180() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 181, 2.4, 2.4, 0, "A");
            new Position(dto);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void garanteeSogEqualOrBiggerThan0() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 181, -4, 2.4, 0, "A");
            new Position(dto);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void garanteeCogBetween0and359() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 2, 360, 0, "A");
        new Position(dto);
    }

    @Test
    public void garanteeHeadingBetween0and359() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 369, "A");
        new Position(dto);
    }

    @Test
    public void garanteeTrancieverClassOneLetter() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "AA");
            new Position(dto);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void garanteeTrancieverClassOnlyLetter() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
    }

    @Test
    public void getDateTime() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        String expected = "31/12/2020 17:19";
        assertEquals(dto.getDateTime(), expected);
    }

    @Test
    public void getLatitude() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        double expected = 76;
        double delta = 0.1;
        assertEquals(dto.getLatitude(), expected, delta);
    }


    @Test
    public void getLongitude() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        double expected = 170;
        double delta = 0.1;
        assertEquals(dto.getLongitude(), expected, delta);
    }

    @Test
    public void getSog() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        double expected = 5;
        double delta = 0.1;
        assertEquals(dto.getSog(), expected, delta);
    }

    @Test
    public void getCog() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        double expected = 34;
        double delta = 0.1;
        assertEquals(dto.getCog(), expected, delta);
    }

    @Test
    public void getHeading() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        int expected = 300;
        assertEquals(dto.getHeading(), expected);
    }

    @Test
    public void getPosition() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        int expected = 0;
        assertEquals(dto.getPosition1(), expected);
    }

    @Test
    public void getTranscieverClass() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        new Position(dto);
        String expected = "A";
        assertEquals(dto.getTranscieverClass(), expected);
    }

    @Test
    public void setMmsi() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setMmsi(231233131);
        int expected = 231233131;
        assertEquals(expected, posi.getMmsi());
    }

    @Test
    public void setDateTime() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2010 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setDateTime("31/12/2030 17:19");
        String expected = "31/12/2030 17:19";
        assertEquals(expected, posi.getDateTime());
    }

    @Test
    public void setLatitude() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setLatitude(56);
        double expected = 56;
        double delta = 0.01;
        assertEquals(expected, posi.getLatitude(), delta);
    }

    @Test
    public void setLongitude() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setLongitude(67);
        double expected = 67;
        double delta = 0.01;
        assertEquals(expected, posi.getLongitude(), delta);
    }

    @Test
    public void setSog() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setSog(67);
        double expected = 67;
        double delta = 0.01;
        assertEquals(expected, posi.getSog(), delta);
    }

    @Test
    public void setCog() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setCog(67);
        double expected = 67;
        double delta = 0.01;
        assertEquals(expected, posi.getCog(), delta);
    }

    @Test
    public void setPosition() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setPosition1(67);
        int expected = 67;
        assertEquals(expected, posi.getPosition1());
    }

    @Test
    public void setTranscieverClass() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2010 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setTranscieverClass("B");
        String expected = "B";
        assertEquals(expected, posi.getTranscieverClass());
    }

    @Test
    public void setDateTimeNull() throws NullPointerException {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, null, 76, 170, 5, 34, 300, "A");
            Position posi = new Position(dto);
            posi.setDateTime(null);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void setLatitudeDifferentFormat() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76000, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        posi.setLatitude(76000);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void setLongitudeDifferentFormat() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 17000, 5, 34, 300, "A");
            Position posi = new Position(dto);
            posi.setLongitude(17000);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void setCogDifferentFormat() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, -26, 300, "A");
        Position posi = new Position(dto);
        posi.setCog(-26);
        double expected = -1;
        double delta = 0.01;
        assertEquals(expected, posi.getCog(), delta);
    }

    @Test
    public void setHeading() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, -26, 300, "A");
        Position posi = new Position(dto);
        posi.setHeading(300);
        double expected = 300;
        double delta = 0.01;
        assertEquals(expected, posi.getHeading(), delta);
    }

    @Test
    public void setHeadingDiff() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2020 17:19", 76, 170, 5, -26, -21, "A");
        Position posi = new Position(dto);
        posi.setHeading(-21);
        double expected = -1;
        double delta = 0.01;
        assertEquals(expected, posi.getHeading(), delta);
    }

    @Test
    public void setTranscieverClassNull() throws NullPointerException {
        NullPointerException thrown = Assertions.assertThrows(NullPointerException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, "31/12/2010 17:19", 76, 170, 5, 34, 300, null);
            Position posi = new Position(dto);
            posi.setTranscieverClass(null);
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void setTranscieverClassDiff() throws IllegalArgumentException {
        IllegalArgumentException thrown = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            PositionDTO dto = new PositionDTO(111111111, "31/12/2010 17:19", 76, 170, 5, 34, 300, "BB");
            Position posi = new Position(dto);
            posi.setTranscieverClass("BB");
        });
        Assertions.assertEquals("not available", thrown.getMessage());
    }

    @Test
    public void compareTo() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2010 17:19", 76, 170, 5, 34, 300, "B");
        Position posi = new Position(dto);
        PositionDTO dto1 = new PositionDTO(111111112, "31/12/2010 17:19", 72, 170, 5, 34, 300, "B");
        Position posi1 = new Position(dto1);
        org.junit.Assert.assertNotNull(posi1.compareTo(posi));
    }

    @Test
    public void equals() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2010 17:19", 76, 170, 5, 34, 300, "B");
        Position posi = new Position(dto);
        PositionDTO dto1 = new PositionDTO(111111112, "31/12/2010 17:19", 72, 170, 5, 34, 300, "B");
        Position posi1 = new Position(dto1);
        org.junit.Assert.assertNotNull(posi1.equals(posi));
    }

    @Test
    public void convertStringToDate() {
        PositionDTO dto = new PositionDTO(111111111, "31/12/2010 17:19", 76, 170, 5, 34, 300, "A");
        Position posi = new Position(dto);
        LocalDateTime date = posi.convertStringToDate();
        LocalDateTime newDate = LocalDateTime.of(2010, 12, 31, 17, 19);
        assertEquals(newDate, date);
    }
}

