package org.test;

import org.test.enums.Actions;
import org.test.misc.Utility;
import org.test.models.ParkingLotDetails;

import java.util.Scanner;

public class ParkMyCar {
    public static void main(String[] args) {
        ParkingLotDetails parkingLot = null;
        Scanner scanner = new Scanner(System.in);
        while (true) {
           try {
               System.out.println("Please enter a command or type 'help' for instructions:");
               String action = scanner.nextLine();
               String[] parts = Utility.validate(action);
               Actions actionType = Utility.getActionType(parts[0]);
               String actionResponse = "";
               switch (actionType) {
                   case HELP:
                       System.out.println("Available commands:");
                       System.out.println("- create_parking_lot <capacity>");
                       System.out.println("- park <registration_number> <color>");
                       System.out.println("- leave <slot_number>");
                       System.out.println("- status");
                       System.out.println("- exit");
                       break;
                   case CREATE_PARKING_LOT:
                       int capacity = Integer.parseInt(parts[1]);
                       parkingLot = new ParkingLotDetails(capacity);
                       actionResponse = parkingLot.createParkingLot(capacity);
                       break;
                   case PARK:
                       // Test
                       actionResponse = parkingLot.park(parts[1], parts[2]);
                       break;
                   case LEAVE:
                       actionResponse = parkingLot.leave(Integer.parseInt(parts[1]));
                       break;
                   case STATUS:
                       actionResponse = parkingLot.status();
                       break;
                   case REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR:
                       actionResponse = parkingLot.registrationNumbersForCarsWithColour(parts[1]);
                       break;
                   case SLOT_NUMBERS_FOR_CARS_WITH_COLOUR:
                       actionResponse = parkingLot.slotNumbersForCarsWithColour(parts[1]);
                       break;
                   case SLOT_NUMBER_FOR_REGISTRATION_NUMBER:
                       actionResponse = String.valueOf(parkingLot.slotNumberForRegistrationNumber(parts[1]));
                       break;
                   case EXIT:
                       scanner.close();
                       System.exit(0);
                       break;
                   case INVALID:
                       System.out.println("Invalid command");
                       break;
               }
               Utility.printResult(actionResponse);
           }catch (Exception ex){
               System.out.println(ex.getMessage());
           }
        }
    }
}
