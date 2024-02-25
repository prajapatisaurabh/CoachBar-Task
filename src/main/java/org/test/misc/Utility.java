package org.test.misc;

import org.test.enums.Actions;
import org.test.exception.InvalidUserInput;

public class Utility {
    public static Actions getActionType(String commandStr) {
        try {
            return Actions.valueOf(commandStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            return Actions.INVALID;
        }
    }

    public static void printResult(String response) {
        System.out.println(response);
    }

    public static String[] validate(String action) throws InvalidUserInput {
        if (action.isBlank()) {
            throw new InvalidUserInput("User input is blank or empty");
        }

        String[] actions = action.trim().split(" ");

        // Note: here is your interview question (assert not null) (:
        if (actions.length == 1 && ("status".equalsIgnoreCase(actions[0]) || "exit".equalsIgnoreCase(actions[0]) || "help".equalsIgnoreCase(actions[0]))) {
            return actions;
        }

        if (actions.length >= 2) {
            return actions;
        } else {
            throw new InvalidUserInput("Invalid input. Please enter a valid action.");
        }
    }
}
