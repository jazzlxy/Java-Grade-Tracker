import java.util.Scanner;
import java.util.HashMap;


public class GradeTracker {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        HashMap<String, HashMap<String, Integer>> students = new HashMap<>();

        System.out.println("Student Grade Tracker");

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View all students");
            System.out.println("3. Exit");
            System.out.print("\nPlease choose an option: ");
            String option = scanner.next();
            scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    
                    HashMap<String, Integer> subjects = new HashMap<>();
                    System.out.print("How many subjects? ");
                    int numSubjects = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 1; i <= numSubjects; i++) {
                        System.out.print("Enter subject " + i + " name: ");
                        String subject = scanner.nextLine();

                        System.out.print("Enter " + subject + " grade: ");
                        int grade = scanner.nextInt();
                        scanner.nextLine();

                        subjects.put(subject, grade);
                    }
                    students.put(name, subjects);
                    System.out.println("Student " + name + " added successfully!");
                    break;
                
                case "2":
                    if (students.isEmpty()) {
                        System.out.println("No students added in the list!");
                    } else {
                        for (String studentName : students.keySet()) {
                            HashMap<String, Integer> studentSubject = students.get(studentName);

                            int total = 0;
                            for (int grade : studentSubject.values()) {
                                total += grade;
                            }
                            double average = (double) total / studentSubject.size();

                            String letterGrade = getLetterGrading(average);

                            System.out.println("\nStudent: " + studentName);
                            System.out.println("Subjects: " + studentSubject);
                            System.out.println("Average: " + average);
                            System.out.println("Grade: " + letterGrade);
                        }
                    }
                    break;
                
                case "3":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
            
                default:
                    System.out.println("Invalid option! Please input correct option.");
                    break;
            }
        }
        
     }

    public static String getLetterGrading(double average) {
    if (average >= 90) {
        return "AL1";
    } else if (average >= 85) {
        return "AL2";
    } else if (average >= 80) {
        return "AL3";
    } else if (average >= 75) {
        return "AL4";
    } else if (average >= 65) {
        return "AL5";
    } else if (average >= 45) {
        return "AL6";
    } else if (average >= 20) {
        return "AL7";
    } else {
        return "AL8";
    }
}

}

