import java.util.ArrayList;
import java.util.Scanner;

public class TodoListApp {
    
    private ArrayList<String> tasks;

    // Constructor to initialize the list
    public TodoListApp() {
        tasks = new ArrayList<>();
    }

    // Method to add a new task
    public void addTask(String task) {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    // Method to remove a task
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            String removedTask = tasks.remove(index);
            System.out.println("Task removed: " + removedTask);
        } else {
            System.out.println("Invalid task number.");
        }
    }

    // Method to display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks to display.");
        } else {
            System.out.println("Your To-Do List:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        TodoListApp app = new TodoListApp();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nTo-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View Tasks");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the task to add: ");
                    String task = scanner.nextLine();
                    app.addTask(task);
                    break;
                case 2:
                    app.displayTasks();
                    System.out.print("Enter the task number to remove: ");
                    int taskNumber = scanner.nextInt();
                    app.removeTask(taskNumber - 1);  // Adjust for zero-based index
                    break;
                case 3:
                    app.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}