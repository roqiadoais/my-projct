package teachermanagementsystem;

import java.util.Scanner;
import models.Teacher;
import services.TeacherService;

public class TeacherManagementSystem {

    public static void main(String[] args) {

        TeacherService service = new TeacherService();
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Teacher Management System ---");
            System.out.println("1. Add Teacher");
            System.out.println("2. Search Teacher");
            System.out.println("3. Update Teacher");
            System.out.println("4. Delete Teacher");
            System.out.println("5. Show All Teachers");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = input.nextInt();

            if (choice == 0) break;

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Subject: ");
                    String subject = input.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = input.nextLine();

                    service.addTeacher(new Teacher(name, id, subject, phone));
                    break;

                case 2:
                    System.out.print("Enter ID to search: ");
                    Teacher t = service.searchById(input.nextInt());
                    if (t != null) t.displayInfo();
                    else System.out.println("Teacher not found.");
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = input.nextInt();
                    input.nextLine();

                    System.out.print("New Name (Enter to skip): ");
                    String newName = input.nextLine();
                    if (newName.isEmpty()) newName = null;

                    System.out.print("New Subject (Enter to skip): ");
                    String newSubject = input.nextLine();
                    if (newSubject.isEmpty()) newSubject = null;

                    System.out.print("New Phone (Enter to skip): ");
                    String newPhone = input.nextLine();
                    if (newPhone.isEmpty()) newPhone = null;

                    if (service.updateTeacher(uid, newName, newSubject, newPhone))
                        System.out.println("Teacher updated.");
                    else
                        System.out.println("Teacher not found.");
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    if (service.deleteTeacher(input.nextInt()))
                        System.out.println("Teacher deleted.");
                    else
                        System.out.println("Teacher not found.");
                    break;

                case 5:
                    service.showAll();
                    break;
            }
        }
    }
}

