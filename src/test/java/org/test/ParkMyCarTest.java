package org.test;

import org.junit.Test;
import org.test.models.ParkingLotDetails;

import static org.junit.Assert.assertEquals;


public class ParkMyCarTest
{

    @Test
    public void createParkingLotTest() {
        ParkingLotDetails parkingLot = new ParkingLotDetails();
        assertEquals("Created a parking lot with 5 slots", parkingLot.createParkingLot(5));
    }

    @Test
    public void parkTest() {
        ParkingLotDetails parkingLot = new ParkingLotDetails();
        assertEquals("Allocated slot number: 1", parkingLot.park("ABC123", "Red"));
        assertEquals("Allocated slot number: 2", parkingLot.park("XYZ789", "Blue"));
        assertEquals("Sorry, parking lot is full", parkingLot.park("DEF456", "Green"));
    }

    @Test
    public void leaveTest() {
        ParkingLotDetails parkingLot = new ParkingLotDetails();
        parkingLot.park("ABC123", "Red");
        parkingLot.park("XYZ789", "Blue");
        assertEquals("Slot number 1 is free", parkingLot.leave(1));
        assertEquals("Invalid slot number: 4", parkingLot.leave(4));
    }

    @Test
    public void statusTest() {
        ParkingLotDetails parkingLot = new ParkingLotDetails();
        parkingLot.park("ABC123", "Red");
        parkingLot.park("XYZ789", "Blue");
        assertEquals("Slot No. Registration No. Colour\n1 ABC123 Red\n2 XYZ789 Blue", parkingLot.status());
    }

    @Test
    public void registrationNumbersForCarsWithColourTest() {
        ParkingLotDetails parkingLot = new ParkingLotDetails();
        parkingLot.park("ABC123", "Red");
        parkingLot.park("XYZ789", "Red");
        assertEquals("ABC123, XYZ789", parkingLot.registrationNumbersForCarsWithColour("Red"));
        assertEquals("Not found", parkingLot.registrationNumbersForCarsWithColour("Blue"));
    }

    @Test
    public void slotNumbersForCarsWithColourTest() {
        ParkingLotDetails parkingLot = new ParkingLotDetails();
        parkingLot.park("ABC123", "Red");
        parkingLot.park("XYZ789", "Red");
        assertEquals("1, 2", parkingLot.slotNumbersForCarsWithColour("Red"));
        assertEquals("Not found", parkingLot.slotNumbersForCarsWithColour("Blue"));
    }

    @Test
    public void slotNumberForRegistrationNumberTest() {
        ParkingLotDetails parkingLot = new ParkingLotDetails();
        parkingLot.park("ABC123", "Red");
        parkingLot.park("XYZ789", "Blue");
        assertEquals(1, parkingLot.slotNumberForRegistrationNumber("ABC123"));
        assertEquals(-1, parkingLot.slotNumberForRegistrationNumber("DEF456"));
    }

}
