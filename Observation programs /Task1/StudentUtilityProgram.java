import java.util.Scanner;

public class StudentUtilityProgram {

    // Method to find factorial
    public static int factorial(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    // Method to check prime
    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // Method to find maximum
    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Method to calculate area of circle
    public static double areaCircle(double radius) {
        return 3.14 * radius * radius;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== STUDENT UTILITY PROGRAM =====");
            System.out.println("1. Student Information");
            System.out.println("2. Even or Odd");
            System.out.println("3. Largest of Three Numbers");
            System.out.println("4. Grade");
            System.out.println("5. Day of Week");
            System.out.println("6. Multiplication Table");
            System.out.println("7. Numbers from 1 to N");
            System.out.println("8. Sum of First N Numbers");
            System.out.println("9. Fibonacci Series");
            System.out.println("10. Methods");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Roll Number: ");
                    int roll = sc.nextInt();

                    System.out.print("Enter Marks in 3 Subjects: ");
                    int m1 = sc.nextInt();
                    int m2 = sc.nextInt();
                    int m3 = sc.nextInt();

                    int total = m1 + m2 + m3;
                    double percentage = total / 3.0;

                    System.out.println("\nStudent Name: " + name);
                    System.out.println("Roll Number: " + roll);
                    System.out.println("Total Marks: " + total);
                    System.out.println("Percentage: " + percentage);
                    break;

                case 2:
                    System.out.print("Enter Number: ");
                    int num = sc.nextInt();

                    if (num % 2 == 0)
                        System.out.println("Even Number");
                    else
                        System.out.println("Odd Number");
                    break;

                case 3:
                    System.out.print("Enter Three Numbers: ");
                    int a = sc.nextInt();
                    int b = sc.nextInt();
                    int c = sc.nextInt();

                    int largest = Math.max(a, Math.max(b, c));
                    System.out.println("Largest = " + largest);
                    break;

                case 4:
                    System.out.print("Enter Percentage: ");
                    double per = sc.nextDouble();

                    if (per >= 90)
                        System.out.println("Grade A");
                    else if (per >= 75)
                        System.out.println("Grade B");
                    else if (per >= 60)
                        System.out.println("Grade C");
                    else if (per >= 40)
                        System.out.println("Grade D");
                    else
                        System.out.println("Fail");
                    break;

                case 5:
                    System.out.print("Enter Day Number (1-7): ");
                    int day = sc.nextInt();

                    switch (day) {
                        case 1:
                            System.out.println("Monday");
                            break;
                        case 2:
                            System.out.println("Tuesday");
                            break;
                        case 3:
                            System.out.println("Wednesday");
                            break;
                        case 4:
                            System.out.println("Thursday");
                            break;
                        case 5:
                            System.out.println("Friday");
                            break;
                        case 6:
                            System.out.println("Saturday");
                            break;
                        case 7:
                            System.out.println("Sunday");
                            break;
                        default:
                            System.out.println("Invalid Day");
                    }
                    break;

                case 6:
                    System.out.print("Enter Number: ");
                    int table = sc.nextInt();

                    for (int i = 1; i <= 10; i++) {
                        System.out.println(table + " x " + i + " = " + (table * i));
                    }
                    break;

                case 7:
                    System.out.print("Enter N: ");
                    int n = sc.nextInt();

                    for (int i = 1; i <= n; i++) {
                        System.out.print(i + " ");
                    }
                    break;

                case 8:
                    System.out.print("Enter N: ");
                    int n1 = sc.nextInt();

                    int sum = 0;
                    for (int i = 1; i <= n1; i++) {
                        sum += i;
                    }

                    System.out.println("Sum = " + sum);
                    break;

                case 9:
                    System.out.print("Enter Number of Terms: ");
                    int terms = sc.nextInt();

                    int f1 = 0, f2 = 1;

                    for (int i = 1; i <= terms; i++) {
                        System.out.print(f1 + " ");
                        int temp = f1 + f2;
                        f1 = f2;
                        f2 = temp;
                    }
                    break;

                case 10:

                    System.out.print("Enter Number for Factorial: ");
                    int factNum = sc.nextInt();
                    System.out.println("Factorial = " + factorial(factNum));

                    System.out.print("Enter Number to Check Prime: ");
                    int prime = sc.nextInt();

                    if (isPrime(prime))
                        System.out.println("Prime Number");
                    else
                        System.out.println("Not Prime");

                    System.out.print("Enter Two Numbers: ");
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    System.out.println("Maximum = " + max(x, y));

                    System.out.print("Enter Radius: ");
                    double r = sc.nextDouble();

                    System.out.println("Area = " + areaCircle(r));
                    break;

                case 11:
                    System.out.println("Thank You");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 11);

        sc.close();
    }
}
