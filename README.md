# Parking Lot Management System

This is a simple parking lot management system implemented in Java. It allows users to create a parking lot, park cars, leave parking slots, and query information about the parking lot.

## Table of Contents
- [Features](#features)
- [Prerequisites](#prerequisites)
- [How to Run](#how-to-run)
- [Commands](#commands)
- [Examples](#examples)
- [Tests](#tests)
- [Contributing](#contributing)
- [License](#license)

## Features
- Create a parking lot with a specified capacity.
- Park cars in available slots.
- Vacate parking slots.
- Check the status of the parking lot.
- Query registration numbers for cars with a specific color.
- Query slot numbers for cars with a specific color.
- Query the slot number for a given registration number.

## Prerequisites
- Java Development Kit (JDK) installed
- Maven (for running tests)

## How to Run
1. Clone the repository: `git clone https://github.com/yourusername/parking-lot.git`
2. Navigate to the project directory: `cd parking-lot`
3. Compile the Java code: `javac -d target src/main/java/org/test/*.java src/main/java/org/test/enums/*.java src/main/java/org/test/exception/*.java src/main/java/org/test/misc/*.java src/main/java/org/test/models/*.java`
4. Run the program: `java -cp target org.test.ParkMyCar`

## Commands
- `create_parking_lot <capacity>`: Create a parking lot with the specified capacity.
- `park <registration_number> <color>`: Park a car with the given registration number and color.
- `leave <slot_number>`: Vacate the parking slot with the specified slot number.
- `status`: Display the current status of the parking lot.
- `registration_numbers_for_cars_with_colour <color>`: Retrieve registration numbers for cars with a specific color.
- `slot_numbers_for_cars_with_colour <color>`: Retrieve slot numbers for cars with a specific color.
- `slot_number_for_registration_number <registration_number>`: Retrieve the slot number for a given registration number.
- `help`: Display available commands.
- `exit`: Exit the program.

## Examples
- `create_parking_lot 5`: Create a parking lot with 5 slots.
- `park ABC123 Red`: Park a car with registration number ABC123 and color Red.
- `leave 2`: Vacate parking slot 2.
- `status`: Display the current status of the parking lot.
- `registration_numbers_for_cars_with_colour Blue`: Retrieve registration numbers for cars with the color Blue.
- `exit`: Exit the program.

## Tests
To run the tests, use the following command:
```bash
mvn test
