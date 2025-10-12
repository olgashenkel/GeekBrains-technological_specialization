package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    private static final int NUM_SIMULATIONS = 1000;

    public static void main(String[] args) {
        Map<Integer, Boolean> resultsWithoutSwitching = runSimulation(false);
        Map<Integer, Boolean> resultsWithSwitching = runSimulation(true);

        System.out.println("=== Results Without Switching ===");
        displayResults(resultsWithoutSwitching);

        System.out.println("\n=== Results With Switching ===");
        displayResults(resultsWithSwitching);
    }

    private static Map<Integer, Boolean> runSimulation(boolean shouldSwitch) {
        Map<Integer, Boolean> results = new HashMap<>();
        Random random = new Random();

        for (int i = 1; i <= NUM_SIMULATIONS; i++) {
            int prizeDoor = random.nextInt(3);   // Дверь с призом (0, 1, или 2)
            int chosenDoor = random.nextInt(3);  // Выбор участника

            // Ищем дверь, которую можно открыть, чтобы показать, что там нет приза
            int openDoor;
            do {
                openDoor = random.nextInt(3);
            } while (openDoor == prizeDoor || openDoor == chosenDoor);

            // Участник меняет выбор, если это требуется
            if (shouldSwitch) {
                chosenDoor = 3 - chosenDoor - openDoor;
            }

            // Проверяем, выиграл ли участник
            boolean won = (chosenDoor == prizeDoor);
            results.put(i, won);
        }

        return results;
    }

    private static void displayResults(Map<Integer, Boolean> results) {
        int wins = 0;
        int losses = 0;

        for (boolean result : results.values()) {
            if (result) {
                wins++;
            } else {
                losses++;
            }
        }

        System.out.printf("Wins: %d, Losses: %d, Win Rate: %.2f%%%n",
                wins, losses, (wins / (double) NUM_SIMULATIONS) * 100);
    }
}