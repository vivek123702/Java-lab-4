import java.util.Scanner;

// Abstract class Robber
abstract class Robber {
    // Abstract method to print "MScAI&ML"
    public abstract void RobbingClass();

    // Default method
    public void MachineLearning() {
        System.out.println("I love MachineLearning.");
    }

    // Abstract methods for robbing different house types
    public abstract int RowHouses(int[] amounts);

    public abstract int RoundHouses(int[] amounts);

    public abstract int SquareHouse(int[] amounts);

    public abstract int MultiHouseBuilding(int[] amounts);
}

// Subclass JAVAProfessionalRobber
class JAVAProfessionalRobber extends Robber {
    @Override
    public void RobbingClass() {
        System.out.println("MScAI&ML");
    }

    // Robbing Row Houses
    @Override
    public int RowHouses(int[] amounts) {
        if (amounts == null || amounts.length == 0)
            return 0;
        if (amounts.length == 1)
            return amounts[0];

        int prev2 = 0, prev1 = 0;
        for (int amount : amounts) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + amount);
            prev2 = temp;
        }
        return prev1;
    }

    // Robbing Round Houses
    @Override
    public int RoundHouses(int[] amounts) {
        if (amounts == null || amounts.length == 0)
            return 0;
        if (amounts.length == 1)
            return amounts[0];

        return Math.max(robHelper(amounts, 0, amounts.length - 2), robHelper(amounts, 1, amounts.length - 1));
    }

    private int robHelper(int[] amounts, int start, int end) {
        int prev2 = 0, prev1 = 0;
        for (int i = start; i <= end; i++) {
            int temp = prev1;
            prev1 = Math.max(prev1, prev2 + amounts[i]);
            prev2 = temp;
        }
        return prev1;
    }

    // Robbing Square Houses
    @Override
    public int SquareHouse(int[] amounts) {
        return RowHouses(amounts); // Logic is identical to RowHouses
    }

    // Robbing Multi-House Building
    @Override
    public int MultiHouseBuilding(int[] amounts) {
        return RowHouses(amounts); // Assuming similar logic to RowHouses
    }
}

// Main class to test functionality
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JAVAProfessionalRobber robber = new JAVAProfessionalRobber();

        // Call RobbingClass and MachineLearning
        robber.RobbingClass();
        robber.MachineLearning();

        // Input validation for Row Houses
        System.out.println("Enter the number of Row Houses:");
        int n = validatePositiveInt(scanner);
        int[] rowHouseAmounts = new int[n];
        System.out.println("Enter the amount of money in each Row House:");
        for (int i = 0; i < n; i++) {
            rowHouseAmounts[i] = validatePositiveInt(scanner);
        }
        System.out.println("Max money robbed from Row Houses: " + robber.RowHouses(rowHouseAmounts));

        // Input validation for Round Houses
        System.out.println("Enter the number of Round Houses:");
        int m = validatePositiveInt(scanner);
        int[] roundHouseAmounts = new int[m];
        System.out.println("Enter the amount of money in each Round House:");
        for (int i = 0; i < m; i++) {
            roundHouseAmounts[i] = validatePositiveInt(scanner);
        }
        System.out.println("Max money robbed from Round Houses: " + robber.RoundHouses(roundHouseAmounts));

        // Input validation for Square Houses
        System.out.println("Enter the number of Square Houses:");
        int o = validatePositiveInt(scanner);
        int[] squareHouseAmounts = new int[o];
        System.out.println("Enter the amount of money in each Square House:");
        for (int i = 0; i < o; i++) {
            squareHouseAmounts[i] = validatePositiveInt(scanner);
        }
        System.out.println("Max money robbed from Square Houses: " + robber.SquareHouse(squareHouseAmounts));

        // Input validation for Multi-House Building
        System.out.println("Enter the number of Multi-House Buildings:");
        int p = validatePositiveInt(scanner);
        int[] multiHouseAmounts = new int[p];
        System.out.println("Enter the amount of money in each Multi-House Building:");
        for (int i = 0; i < p; i++) {
            multiHouseAmounts[i] = validatePositiveInt(scanner);
        }
        System.out
                .println("Max money robbed from Multi-House Building: " + robber.MultiHouseBuilding(multiHouseAmounts));

        scanner.close();
    }

    // Helper method to validate positive integer input
    private static int validatePositiveInt(Scanner scanner) {
        int value;
        while (true) {
            if (scanner.hasNextInt()) {
                value = scanner.nextInt();
                if (value > 0) {
                    break;
                } else {
                    System.out.println("Please enter a positive integer:");
                }
            } else {
                System.out.println("Invalid input. Please enter a positive integer:");
                scanner.next(); // Consume invalid input
            }
        }
        return value;
    }
}
