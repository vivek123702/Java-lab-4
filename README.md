This Java program implements an employee payroll system using object-oriented principles like abstraction, inheritance, and method overriding.

Key Features:

Abstract Class: Robber
Defines structure for robbing logic and includes:
Abstract methods for different house types (RowHouses, RoundHouses, etc.).
A default method, MachineLearning, to print "I love MachineLearning.".

Subclass: JAVAProfessionalRobber
Implements abstract methods for:
RowHouses: Maximize money robbed without triggering alarms (adjacent houses).
RoundHouses: Similar logic but handles circular adjacency.
SquareHouse: Reuses RowHouses logic.
MultiHouseBuilding: Handles multi-type buildings using the same strategy.
Dynamic Programming is used to maximize robbed money efficiently.

Input Validation:
Ensures valid and positive input for the number of houses and money values using helper methods.

Dynamic Programming Logic:
Optimizes robbing by maintaining two variables:
prev1 (includes current house) and prev2 (excludes current house).

Main Class:
Interacts with the user, validates input, calculates results for each house type, and displays output.

Execution Flow:
User enters house count and money values for each house type.
The program validates input and computes maximum robbed money using defined logic.
Outputs results for each house type.

Sample Output:
Enter the number of Row Houses:
3
Enter the amount of money in each Row House:
2
5
1
Max money robbed from Row Houses: 5
