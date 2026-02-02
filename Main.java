import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    int marks1, marks2, marks3;

    Student(int id, String name, int marks1, int marks2, int marks3) {
        this.id = id;
        this.name = name;
        this.marks1 = marks1;
        this.marks2 = marks2;
        this.marks3 = marks3;
    }

    int getTotal() {
        return marks1 + marks2 + marks3;
    }

    double getAverage() {
        return getTotal() / 3.0;
    }

    String getResult() {
        return (marks1 >= 35 && marks2 >= 35 && marks3 >= 35) ? "Pass" : "Fail";
    }

    void displayStudent() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Total: " + getTotal() +
                ", Average: " + getAverage() +
                ", Result: " + getResult());
    }
}

public class Main {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n🎓 Student Result Management System developed by Monty");
            System.out.println("1. Add Student Result");
            System.out.println("2. View Results");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 3);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Marks in Subject 1: ");
        int m1 = scanner.nextInt();

        System.out.print("Enter Marks in Subject 2: ");
        int m2 = scanner.nextInt();

        System.out.print("Enter Marks in Subject 3: ");
        int m3 = scanner.nextInt();

        students.add(new Student(id, name, m1, m2, m3));
        System.out.println("✅ Student result added successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
        } else {
            for (Student s : students) {
                s.displayStudent();
            }
        }
    }
}
