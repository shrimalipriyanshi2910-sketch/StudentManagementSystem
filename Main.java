import java.util.*;

public class Main {

    public static void printMenu() {
        System.out.println("\n==============================================");
        System.out.println("          STUDENT MANAGEMENT SYSTEM           ");
        System.out.println("==============================================");
        System.out.println("             1. Add Student");
        System.out.println("             2. Display Students");
        System.out.println("             3. Search Student");
        System.out.println("             4. Update Student");
        System.out.println("             5. Delete Student");
        System.out.println("             6. Exit");
        System.out.println("==============================================");
        System.out.print("             Enter your choice: ");
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        StudentOperations op = new StudentOperations();

        while(true) {
            printMenu();
            int choice = sc.nextInt();

            try {
                switch(choice) {

                    case 1 -> {
                        System.out.print("Roll: ");
                        int r = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Name: ");
                        String n = sc.nextLine();

                        System.out.print("Age: ");
                        int a = sc.nextInt();

                        sc.nextLine();
                        System.out.print("Course: ");
                        String c = sc.nextLine();

                        System.out.print("Marks: ");
                        double m = sc.nextDouble();

                        Student s = new Student(r, n, a, c, m);
                        op.addStudent(s);
                    }

                    case 2 -> op.displayStudents();

                    case 3 -> {
                        System.out.print("Enter Roll: ");
                        op.searchStudent(sc.nextInt());
                    }

                    case 4 -> {
                        System.out.print("Enter Roll to update: ");
                        int ur = sc.nextInt();

                        sc.nextLine();
                        System.out.print("New Name: ");
                        String nn = sc.nextLine();

                        System.out.print("New Age: ");
                        int na = sc.nextInt();

                        sc.nextLine();
                        System.out.print("New Course: ");
                        String nc = sc.nextLine();

                        System.out.print("New Marks: ");
                        double nm = sc.nextDouble();

                        Student ns = new Student(ur, nn, na, nc, nm);
                        op.updateStudent(ur, ns);
                    }

                    case 5 -> {
                        System.out.print("Enter Roll to delete: ");
                        op.deleteStudent(sc.nextInt());
                    }

                    case 6 -> {
                        System.out.println("Exiting...");
                        return;
                    }

                    default -> System.out.println("Invalid choice");
                }

            } catch(InputMismatchException e) {
                System.out.println("Invalid input!");
                sc.nextLine();
            }
        }
    }
}