import java.util.Scanner;
import java.util.List;

public class UI {

    public static void start() {
        Scanner sc = new Scanner(System.in);
        try {
            AdminService auth = new AdminService();
            StudentDAO dao = new StudentDAO();

            System.out.print("Enter username: ");
            String user = sc.nextLine();
            System.out.print("Enter password: ");
            String pass = sc.nextLine();

            if (!auth.login(user, pass)) {
                System.out.println("Invalid login.");
                return;
            }

            int choice;
            do {
                System.out.println("\nMENU");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Update Marks");
                System.out.println("4. Delete Student");
                System.out.println("5. Search by Department");
                System.out.println("0. Exit");
                System.out.print("Choice: ");
                while (!sc.hasNextInt()) {
                    System.out.print("Please enter a valid number: ");
                    sc.next();
                }
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Roll No: ");
                        String roll = sc.nextLine();
                        System.out.print("Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Phone: ");
                        String phone = sc.nextLine();
                        System.out.print("Marks: ");
                        int marks = sc.nextInt();
                        sc.nextLine();

                        Student s = new Student(name, roll, dept, email, phone, marks);
                        dao.addStudent(s);
                        break;
                    case 2:
                        List<Student> all = dao.getAllStudents();
                        System.out.println("\nID | Name | Roll No | Department | Email | Phone | Marks");
                        System.out.println("---------------------------------------------------------");
                        for (Student st : all) {
                            System.out.println(st.getId() + " | " + st.getName() + " | " +
                                st.getRollNo() + " | " + st.getDepartment() + " | " +
                                st.getEmail() + " | " + st.getPhone() + " | " + st.getMarks());
                        }
                        break;
                    case 3:
                        System.out.print("Enter Roll No: ");
                        String r = sc.nextLine();
                        System.out.print("New Marks: ");
                        int m = sc.nextInt();
                        sc.nextLine();
                        dao.updateStudentMarks(r, m);
                        break;
                    case 4:
                        System.out.print("Enter Roll No to Delete: ");
                        String del = sc.nextLine();
                        dao.deleteStudent(del);
                        break;
                    case 5:
                        System.out.print("Enter Department: ");
                        String d = sc.nextLine();
                        dao.searchByDepartment(d);
                        break;
                    case 0:
                        System.out.println("Exiting system.");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } while (choice != 0);
        } finally {
            sc.close();  // Safely close the Scanner in all cases
        }
    }

    // Main method to run the UI
    public static void main(String[] args) {
        start();
    }
}

