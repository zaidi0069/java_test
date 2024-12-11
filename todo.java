import java.util.ArrayList;
import java.util.Scanner;

// A simple To-Do List application in Java
public class ToDoListApp {

    // Task class to store details of each task
    static class Task {
        private String description;
        private boolean isComplete;

        public Task(String description) {
            this.description = description;
            this.isComplete = false;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isComplete() {
            return isComplete;
        }

        public void markComplete() {
            this.isComplete = true;
        }

        @Override
        public String toString() {
            return (isComplete ? "[X] " : "[ ] ") + description;
        }
    }

    // List to hold all the tasks
    private ArrayList<Task> tasks;

    public ToDoListApp() {
        tasks = new ArrayList<>();
    }

    // Method to add a task to the list
    public void addTask(String description) {
        tasks.add(new Task(description));
        System.out.println("Task added successfully!");
    }

    // Method to display all tasks
    public void displayTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("\nYour To-Do List:");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    // Method to mark a task as complete
    public void completeTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.get(taskNumber - 1).markComplete();
        System.out.println("Task marked as complete!");
    }

    // Method to delete a task from the list
    public void deleteTask(int taskNumber) {
        if (taskNumber <= 0 || taskNumber > tasks.size()) {
            System.out.println("Invalid task number.");
            return;
        }
        tasks.remove(taskNumber - 1);
        System.out.println("Task deleted successfully!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoListApp app = new ToDoListApp();

        while (true) {
            System.out.println("\nTo-Do List Menu:");
            System.out.println("1. Add a task");
            System.out.println("2. View tasks");
            System.out.println("3. Complete a task");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the task description: ");
                    String description = scanner.nextLine();
                    app.addTask(description);
                    break;
                case 2:
                    app.displayTasks();
                    break;
                case 3:
                    System.out.print("Enter the task number to mark as complete: ");
                    int taskToComplete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    app.completeTask(taskToComplete);
                    break;
                case 4:
                    System.out.print("Enter the task number to delete: ");
                    int taskToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    app.deleteTask(taskToDelete);
                    break;
                case 5:
                    System.out.println("Exiting the To-Do List application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 5.");
            }
        }
    }
} 
