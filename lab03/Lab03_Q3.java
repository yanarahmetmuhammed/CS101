package lab03;
import java.util.Scanner;

public class Lab03_Q3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String accountUsername = "instructor";
        String accountPassword = "teach2024";
        String students = "AliceJohnson, BobWilliams, CarolDavis, ";
        String courses = "COURSE101:IntroToPython COURSE102:WebDevelopment ";
        String username;
        String password;
        boolean loginOk = true;
        boolean usernameOk = false;
        boolean passwordOk = false;
        System.out.print("Enter your username: ");
        username = input.nextLine();

        if (username.equals(accountUsername)) {
            usernameOk = true;
        }

        if (!usernameOk) {
            System.out.println("Username not found! Goodbye!");
            loginOk = false;
        }

        if (loginOk) {
            System.out.print("Enter your password: ");
            password = input.nextLine();

            if (password.equals(accountPassword)) {
                passwordOk = true;
            }

            if (!passwordOk) {
                System.out.println("Incorrect password! Goodbye!");
                loginOk = false;
            }
        }

        if (loginOk) {
            int operation;
            boolean validOperation = false;

            System.out.println("1- Add student");
            System.out.println("2- Remove student");
            System.out.println("3- Add course");
            System.out.println("4- Remove course");
            System.out.println("5- Logout");
            System.out.print("Select an operation: ");
            operation = input.nextInt();
            input.nextLine();

            if (operation == 1) {
                validOperation = true;
                System.out.println("-- Add Student --");
                System.out.print("Enter student name: ");
                String newStudent = input.nextLine();
                String studentToken = newStudent + ", ";
                boolean exists = false;

                if (students.contains(studentToken)) {
                    exists = true;
                }

                if (exists) {
                    System.out.println("This student is already enrolled!");
                }

                if (!exists) {
                    students = students + studentToken;
                    System.out.println("New student " + newStudent + " is added!");
                }

                System.out.println("Your students: (" + students + ")");
            }

            if (operation == 2) {
                validOperation = true;

                System.out.println("-- Remove Student --");
                System.out.print("Enter student name which you want to delete: ");
                String deleteStudent = input.nextLine();

                String studentToken = deleteStudent + ", ";
                int index = students.indexOf(studentToken);

                if (index == -1) {
                    System.out.println("No student found with this name!");
                }

                if (index != -1) {
                    students = students.substring(0, index)
                            + students.substring(index + studentToken.length());

                    System.out.println(deleteStudent + " is deleted successfully from students!");
                }

                System.out.println("Your students: (" + students + ")");
            }

            if (operation == 3) {
                validOperation = true;

                System.out.println("-- Add Course --");
                System.out.print("Enter course name: ");
                String courseName = input.nextLine();

                int code = (int) (Math.random() * 899) + 100; 
                String codeText = String.valueOf(code);
                String courseStart = "COURSE" + codeText + ":";

                boolean codeExists = false;
                if (courses.contains(courseStart)) {
                    codeExists = true;
                }

                if (codeExists) {
                    System.out.println("A course with code " + codeText + " already exists, cannot add!");
                }

                if (!codeExists) {
                    courses = courses + "COURSE" + codeText + ":" + courseName + " ";
                    System.out.println("New course with code " + codeText + " is added!");
                }

                System.out.println("Your courses: " + courses);
            }

            if (operation == 4) {
                validOperation = true;

                System.out.println("-- Remove Course --");
                System.out.print("Enter course code which you want to delete: ");
                String removeCode = input.nextLine();

                String target = "COURSE" + removeCode + ":";
                int startIndex = courses.indexOf(target);

                if (startIndex == -1) {
                    System.out.println("No course found with this code!");
                }

                if (startIndex != -1) {
                    int nextCourseIndex = courses.indexOf("COURSE", startIndex + target.length());

                    if (nextCourseIndex == -1) {
                        courses = courses.substring(0, startIndex);
                    }

                    if (nextCourseIndex != -1) {
                        courses = courses.substring(0, startIndex) + courses.substring(nextCourseIndex);
                    }

                    courses = courses.trim();
                    if (!courses.equals("")) {
                        courses = courses + " ";
                    }

                    System.out.println("The course with code " + removeCode + " is deleted successfully!");
                }

                System.out.println("Your courses: " + courses);
            }

            if (operation == 5) {
                validOperation = true;
                System.out.println("Logged out successfully!");
            }

            if (!validOperation) {
                System.out.println("There is no such operation! Goodbye!");
            }
        }
    }
} 