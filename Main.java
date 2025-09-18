import java.util.*;

class Student {
    String id;
    String name;
    List<Course> courses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Course {
    String code;
    String title;

    Course(String code, String title) {
        this.code = code;
        this.title = title;
    }
}

class SystemManager {
    Map<String, Student> students = new HashMap<>();
    Map<String, Course> courses = new HashMap<>();

    void addStudent(String id, String name) {
        if (!students.containsKey(id)) {
            students.put(id, new Student(id, name));
            System.out.println("Student added.");
        } else {
            System.out.println("Student already exists.");
        }
    }

    void addCourse(String code, String title) {
        if (!courses.containsKey(code)) {
            courses.put(code, new Course(code, title));
            System.out.println("Course added.");
        } else {
            System.out.println("Course already exists.");
        }
    }

    void enroll(String studentId, String courseCode) {
        Student s = students.get(studentId);
        Course c = courses.get(courseCode);
        if (s != null && c != null) {
            if (!s.courses.contains(c)) {
                s.courses.add(c);
                System.out.println("Enrolled successfully.");
            } else {
                System.out.println("Student already enrolled in this course.");
            }
        } else {
            System.out.println("Student or course not found.");
        }
    }

    void showEnrollments(String studentId) {
        Student s = students.get(studentId);
        if (s != null) {
            System.out.println("Courses for " + s.name + ":");
            for (Course c : s.courses) {
                System.out.println("- " + c.title);
            }
        } else {
            System.out.println("Student not found.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        SystemManager sm = new SystemManager();
        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student");
            System.out.println("4. Show Student Enrollments");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = in.nextInt();
            in.nextLine();
            if (choice == 1) {
                System.out.print("Student ID: ");
                String id = in.nextLine();
                System.out.print("Name: ");
                String name = in.nextLine();
                sm.addStudent(id, name);
            } else if (choice == 2) {
                System.out.print("Course Code: ");
                String code = in.nextLine();
                System.out.print("Title: ");
                String title = in.nextLine();
                sm.addCourse(code, title);
            } else if (choice == 3) {
                System.out.print("Student ID: ");
                String sid = in.nextLine();
                System.out.print("Course Code: ");
                String cid = in.nextLine();
                sm.enroll(sid, cid);
            } else if (choice == 4) {
                System.out.print("Student ID: ");
                String sid = in.nextLine();
                sm.showEnrollments(sid);
            } else if (choice == 5) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        in.close();
    }
}
