import java.util.Scanner;

public class _168TODOLIST {
    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);
            System.out.println("----- Create a todo list -----");
            System.out.println("Enter the number of task: ");
            int size = sc.nextInt();
            sc.nextLine();
            String[] todo = new String[size];
            for (int i = 0; i < todo.length; i++) {
                System.out.println("Enter task number " + (i + 1));
                todo[i] = sc.nextLine();
            }

            System.out.println("Do you wan to perform operation on your todo list: Y/N");
            char choice = sc.next().charAt(0);
            System.out.println(
                    "Enter 1. Add a new task\n" +
                            "Enter 2. View all tasks\n" +
                            "Enter 3. Mark a task as completed\n" +
                            "Enter 4. Remove a task\n" +
                            "Enter 5. Check pending task\n" +
                            "Enter 6. Exit ");
            if (choice == 'y' || choice == 'Y') {
                while (choice == 'Y' || choice == 'y') {
                    System.out.println("Enter operation to perform on your todo list: ");
                    int operation = sc.nextInt();
                    switch (operation) {
                        case 1:
                            System.out.println("How much task you want to add: ");
                            int newTask = sc.nextInt();
                            sc.nextLine();
                            if (newTask == 0) {
                                System.out.println("Zero task added");
                                break;
                            }

                            String[] newtodo = new String[size + newTask];
                            for (int i = 0; i < todo.length; i++) {
                                newtodo[i] = todo[i];
                            }
                            for (int i = todo.length; i < newtodo.length; i++) {
                                System.out.println("Enter the new task: ");
                                newtodo[i] = sc.nextLine();
                            }
                            todo = newtodo;
                            System.out.println("Task added successfully");
                            break;

                        case 2:
                            int i = 1;
                            System.out.println("----- You todo list -----");
                            for (String tasks : todo) {
                                System.out.println(i + ". " + tasks);
                                i++;
                            }
                            System.out.println("----------------------------");
                            break;

                        case 3:
                            sc.nextLine();
                            System.out.println("Enter a task you have completed");
                            String mark = sc.nextLine();

                            for (int t = 0; t < todo.length; t++) {
                                if (mark.equalsIgnoreCase(todo[t])) {
                                    todo[t] = todo[t] + "✅ Completed";
                                }
                            }
                            System.out.println("Task marked as completed");
                            break;

                        case 4:
                            sc.nextLine();
                            System.out.println("Enter a task to delete");
                            String del = sc.nextLine();
                            String[] deleteTodo = new String[todo.length - 1];
                            for (int d = 0; d < todo.length; d++) {
                                if (del.equalsIgnoreCase(todo[d])) {
                                    continue;
                                }
                                deleteTodo[d] = todo[d];
                            }
                            todo = deleteTodo;
                            System.out.println("Task deleted successfully.");
                            break;

                        case 5:
                        System.out.println("---- Pending task ----");
                            for (int p = 0; p < todo.length; p++) {
                                if (todo[p].contains("✅ Completed")) {
                                    continue;
                                }
                                System.out.println((p + 1) + ". " + todo[p]);
                            }
                            System.out.println("-----------------------");
                            break;

                        case 6:
                            choice = 'N';
                            System.out.println("Thankyou for visiting😊");
                            break;

                        default:
                            System.out.println("Invalid choice");
                    }
                }
            } else {
                System.out.println("Thankyou for visiting😊");
            }
        sc.close();
        } catch (Exception e) {
            System.out.println("Something went wrong...... " );
            e.printStackTrace();
        }
    }

}
