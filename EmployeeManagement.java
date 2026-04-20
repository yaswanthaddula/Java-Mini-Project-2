import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
        System.out.println("-------------------");
    }
}

public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> list = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Update Employee");
            System.out.println("5. Delete Employee");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    list.add(new Employee(id, name, salary));
                    System.out.println("Employee Added.");
                    break;

                case 2:
                    if (list.isEmpty()) {
                        System.out.println("No Employees Found.");
                    } else {
                        for (Employee e : list) {
                            e.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Employee ID to Search: ");
                    int sid = sc.nextInt();
                    boolean found = false;

                    for (Employee e : list) {
                        if (e.id == sid) {
                            e.display();
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Employee ID to Update: ");
                    int uid = sc.nextInt();
                    found = false;

                    for (Employee e : list) {
                        if (e.id == uid) {
                            sc.nextLine();

                            System.out.print("Enter New Name: ");
                            e.name = sc.nextLine();

                            System.out.print("Enter New Salary: ");
                            e.salary = sc.nextDouble();

                            System.out.println("Employee Updated.");
                            found = true;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee Not Found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Employee ID to Delete: ");
                    int did = sc.nextInt();
                    found = false;

                    for (Employee e : list) {
                        if (e.id == did) {
                            list.remove(e);
                            System.out.println("Employee Deleted.");
                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("Employee Not Found.");
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}