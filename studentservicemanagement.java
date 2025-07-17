import java.util.*;

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            System.out.println("\n====== Student Management System ======");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student by Roll No");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();  // clear buffer
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();
                    Student student = new Student(roll, name, course);
                    service.addStudent(student);
                    break;

                case 2:
                    service.viewStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll No to search: ");
                    int rollSearch = sc.nextInt();
                    Student found = service.searchStudent(rollSearch);
                    if (found != null) {
                        System.out.println("🎯 Student Found: " + found);
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Roll No to update: ");
                    int rollUpdate = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();
                    if (service.updateStudent(rollUpdate, newName, newCourse)) {
                        System.out.println("✅ Student updated.");
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Roll No to delete: ");
                    int rollDelete = sc.nextInt();
                    if (service.deleteStudent(rollDelete)) {
                        System.out.println("🗑️ Student deleted.");
                    } else {
                        System.out.println("❌ Student not found.");
                    }
                    break;

                case 6:
                    System.out.println("🚪 Exiting program...");
                    break;

                default:
                    System.out.println("⚠️ Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
