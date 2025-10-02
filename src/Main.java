import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Program header
        System.out.println("COMP2130 Assignment 1 - University Student Management System");
        System.out.println("Submitted by: Jezrel Dela Cruz, Date: September 23, 2025");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getValidChoice();
            switch (choice) {
                case 1:
                    addUndergraduateStudent();
                    break;
                case 2:
                    addGraduateStudent();
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    viewEligibleStudents();
                    break;
                case 5:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    // Display menu options
    private static void displayMenu() {
        System.out.println("\n=== University Student Management System ===");
        System.out.println("1. Add Undergraduate Student");
        System.out.println("2. Add Graduate Student");
        System.out.println("3. View All Students");
        System.out.println("4. View Eligible Students for Graduation");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
    }

    // Validate menu choice
    private static int getValidChoice() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < 1 || choice > 5) {
                return -1;
            }
            return choice;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Add undergraduate student
    private static void addUndergraduateStudent() {
        try {
            System.out.println("\n--- Adding Undergraduate Student ---");
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter number of marks: ");
            int numMarks = Integer.parseInt(scanner.nextLine());
            if (numMarks < 0) throw new IllegalArgumentException("Number of marks cannot be negative.");

            double[] marks = new double[numMarks];
            for (int i = 0; i < numMarks; i++) {
                System.out.print("Enter mark " + (i + 1) + ": ");
                marks[i] = Double.parseDouble(scanner.nextLine());
                if (marks[i] < 0 || marks[i] > 100) {
                    throw new IllegalArgumentException("Marks must be between 0 and 100.");
                }
            }

            System.out.println("----- Enter Address Details ----");
            System.out.print("Street: ");
            String street = scanner.nextLine();
            System.out.print("City: ");
            String city = scanner.nextLine();
            System.out.print("Postal Code: ");
            String postalCode = scanner.nextLine();
            System.out.print("Province: ");
            String province = scanner.nextLine();
            System.out.print("Country: ");
            String country = scanner.nextLine();

            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();
            System.out.print("Enter Year of Entry: ");
            int yearOfEntry = Integer.parseInt(scanner.nextLine());
            if (yearOfEntry < 1900 || yearOfEntry > 2025) {
                throw new IllegalArgumentException("Invalid year of entry.");
            }

            Address address = new Address(street, city, postalCode, province, country);
            UndergraduateStudent student = new UndergraduateStudent(id, firstName, lastName, marks, address, subject, yearOfEntry);
            students.add(student);
            System.out.println("Undergraduate student added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Failed to add undergraduate student. Please try again.");
        }
    }

    // Add graduate student
    private static void addGraduateStudent() {
        try {
            System.out.println("\n--- Adding Graduate Student ---");
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();
            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();
            System.out.print("Enter number of marks: ");
            int numMarks = Integer.parseInt(scanner.nextLine());
            if (numMarks < 0) throw new IllegalArgumentException("Number of marks cannot be negative.");

            double[] marks = new double[numMarks];
            for (int i = 0; i < numMarks; i++) {
                System.out.print("Enter mark " + (i + 1) + ": ");
                marks[i] = Double.parseDouble(scanner.nextLine());
                if (marks[i] < 0 || marks[i] > 100) {
                    throw new IllegalArgumentException("Marks must be between 0 and 100.");
                }
            }

            System.out.println("---- Enter Address Details: ----");
            System.out.print("Street: ");
            String street = scanner.nextLine();
            System.out.print("City: ");
            String city = scanner.nextLine();
            System.out.print("Postal Code: ");
            String postalCode = scanner.nextLine();
            System.out.print("Province: ");
            String province = scanner.nextLine();
            System.out.print("Country: ");
            String country = scanner.nextLine();

            System.out.print("Enter Subject: ");
            String subject = scanner.nextLine();
            System.out.print("Enter Year of Entry: ");
            int yearOfEntry = Integer.parseInt(scanner.nextLine());
            if (yearOfEntry < 1900 || yearOfEntry > 2025) {
                throw new IllegalArgumentException("Invalid year of entry.");
            }
            System.out.print("Enter Thesis Topic: ");
            String thesisTopic = scanner.nextLine();

            Address address = new Address(street, city, postalCode, province, country);
            GraduateStudent student = new GraduateStudent(id, firstName, lastName, marks, address, subject, yearOfEntry, thesisTopic);
            students.add(student);
            System.out.println("Graduate student added successfully!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println("Failed to add graduate student. Please try again.");
        }
    }

    // View all students
    private static void viewAllStudents() {
        System.out.println("\n--- All Students ---");
        if (students.isEmpty()) {
            System.out.println("No students in the system.");
        } else {
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i).toString());
            }
        }
    }

    // View eligible students for graduation
    private static void viewEligibleStudents() {
        System.out.println("\n--- Eligible Students for Graduation ---");
        boolean found = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).graduate()) {
                System.out.println((i + 1) + ". " + students.get(i).toString());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No students eligible for graduation.");
        }
    }
}