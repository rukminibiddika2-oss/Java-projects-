import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    String department;
    double salary;

    Employee(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID : " + id);
        System.out.println("Name        : " + name);
        System.out.println("Department  : " + department);
        System.out.println("Salary      : " + salary);
        System.out.println("---------------------------");
    }
}

public class EmployeeManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("\n===== EMPLOYEE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Employee Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    employees.add(
                        new Employee(id, name, department, salary)
                    );

                    System.out.println("Employee added successfully.");
                    break;

                case 2:
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        System.out.println("\nEmployee Details");
                        System.out.println("================");

                        for (Employee e : employees) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Employee e : employees) {
                        if (e.id == searchId) {
                            e.display();
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to remove: ");
                    int removeId = sc.nextInt();

                    boolean removed = false;

                    for (int i = 0; i < employees.size(); i++) {
                        if (employees.get(i).id == removeId) {
                            employees.remove(i);
                            removed = true;
                            System.out.println(
                                "Employee removed successfully."
                            );
                            break;
                        }
                    }

                    if (!removed) {
                        System.out.println("Employee not found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
