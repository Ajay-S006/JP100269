import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String course;

    public Student(String name, int rollNumber, String course) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getCourse() {
        return course;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Roll Number: " + rollNumber + ", Name: " + name + ", Course: " + course;
    }
}

public class StudentManagementSystem {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Course: ");
        String course = scanner.nextLine();
        students.add(new Student(name, rollNumber, course));
        System.out.println("Student added successfully.");
    }

    private static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("\nList of Students:");
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Roll Number of the student to update: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); 
        boolean found = false;

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                found = true;
                System.out.print("Enter new Name: ");
                student.setName(scanner.nextLine());
                System.out.print("Enter new Course: ");
                student.setCourse(scanner.nextLine());
                System.out.println("Student details updated successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter Roll Number of the student to delete: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getRollNumber() == rollNumber) {
                students.remove(i);
                found = true;
                System.out.println("Student deleted successfully.");
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
        }
    }
}