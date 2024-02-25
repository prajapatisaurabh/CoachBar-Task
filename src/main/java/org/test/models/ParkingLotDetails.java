package org.test.models;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotDetails {
    private int capacity;
    private Map<Integer, Car> slots;
    private Map<String, Integer> registrationToSlot;
    private Map<String, String> colorToRegistration;

    public ParkingLotDetails(int capacity) {
        this.capacity = capacity;
        this.slots = new HashMap<>();
        this.registrationToSlot = new HashMap<>();
        this.colorToRegistration = new HashMap<>();
    }

    public String createParkingLot(int capacity) {
        this.capacity = capacity;
        this.slots.clear();
        this.registrationToSlot.clear();
        this.colorToRegistration.clear();
        return "Created a parking lot with " + capacity + " slots";
    }

    public String park(String registration, String color) {
        if (slots.size() < capacity) {
            int slot = slots.size() + 1;
            slots.put(slot, new Car(registration, color));
            registrationToSlot.put(registration, slot);

            if (!colorToRegistration.containsKey(color)){
                colorToRegistration.put(color, registration);
            }else{
                colorToRegistration.put(color, colorToRegistration.get(color) + ", " + registration);
            }
            return "Allocated slot number: " + slot;
        } else {
            return "Sorry, parking lot is full";
        }
    }

    public String leave(int slot) {
        if (slots.containsKey(slot)) {
            Car car = slots.remove(slot);
            registrationToSlot.remove(car.getRegistration());
            colorToRegistration.computeIfPresent(car.getColor(), (k, v) -> v.replace(car.getRegistration() + ',', ""));
            return "Slot number " + slot + " is free";
        } else {
            return "Invalid slot number: " + slot;
        }
    }

    public String status() {
        StringBuilder result = new StringBuilder("Slot No. Registration No. Colour\n");
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            int slot = entry.getKey();
            Car car = entry.getValue();
            result.append(slot).append(" ").append(car.getRegistration()).append(" ").append(car.getColor()).append("\n");
        }
        return result.toString().trim();
    }
    public String registrationNumbersForCarsWithColour(String color) {
        if (colorToRegistration.containsKey(color)) {
            return colorToRegistration.get(color).replaceAll(", $", "");
        } else {
            return "Not found";
        }
    }

    public String slotNumbersForCarsWithColour(String color) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, Car> entry : slots.entrySet()) {
            int slot = entry.getKey();
            Car car = entry.getValue();
            if (car.getColor().equals(color)) {
                result.append(slot).append(", ");
            }
        }
        return result.length() > 0 ? result.substring(0, result.length() - 2) : "Not found";
    }

    public Integer slotNumberForRegistrationNumber(String registration) {
        return registrationToSlot.getOrDefault(registration, -1);
    }

}
