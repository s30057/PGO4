/*import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("John", 1, 20);
        Student student2 = new Student("Alice", 2, 21);
        Student student3 = new Student("Bob", 3, 22);
        StudentGroup group1 = new StudentGroup("Group 1");
        group1.addStudent(student1);
        group1.addStudent(student2);
        StudentGroup group2 = new StudentGroup("Group 2");
        group2.addStudent(student3);
        Teacher teacher1 = new Teacher("Mr. Smith", 101, "Math");
        displayGroupInfo(group1);
        displayGroupInfo(group2);
        System.out.println("Teacher Name: " + teacher1.name);
        System.out.println("Teacher ID: " + teacher1.id);
        System.out.println("Subject: " + teacher1.subject);
    }
    public static void displayGroupInfo(StudentGroup group) {
        System.out.println("Group Name: " + group.groupName);
        System.out.println("Number of Students: " + group.students.size());
        System.out.println("Student List:");
        for (Student student : group.students) {
            System.out.println("Name: " + student.name + ", ID: " + student.id + ", Age: " + student.age);
        }
        System.out.println();
    }
}
class Student {
    public String name;
    public int id;
    public int age;
    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}
class StudentGroup {
    public String groupName;
    public List<Student> students;
    public StudentGroup(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }
    public void addStudent(Student student) {
        students.add(student);
    }
    public void removeStudent(Student student) {
        students.remove(student);
    }
}
class Teacher {
    public String name;
    public int id;
    public String subject;
    public Teacher(String name, int id, String subject) {
        this.name = name;
        this.id = id;
        this.subject = subject;
    }
}
*/
//zadanie2
/*import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter group name: ");
        String groupName = scanner.nextLine();
        StudentGroup group = new StudentGroup(groupName);

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String studentName = scanner.nextLine();
            if (studentName.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character
            System.out.print("Enter student age: ");
            int studentAge = scanner.nextInt();
            scanner.nextLine(); // Consuming newline character

            Student student = new Student(studentName, studentId, studentAge);

            while (true) {
                System.out.print("Enter student grade (or type 'done' to finish): ");
                String gradeInput = scanner.nextLine();
                if (gradeInput.equalsIgnoreCase("done")) {
                    break;
                }
                double grade = Double.parseDouble(gradeInput);
                student.addGrade(grade);
            }

            try {
                group.addStudent(student);
                System.out.println("Student " + studentName + " added to group " + groupName);
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }

        displayGroupInfo(group);

        for (Student student : group.students) {
            try {
                System.out.println("Average Grade for " + student.name + ": " + calculateAverageGrade(student));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        scanner.close();
    }

    public static void displayGroupInfo(StudentGroup group) {
        System.out.println("Group Name: " + group.groupName);
        System.out.println("Number of Students: " + group.students.size());
        System.out.println("Student List:");
        for (Student student : group.students) {
            System.out.println("Name: " + student.name + ", ID: " + student.id + ", Age: " + student.age);
        }
        System.out.println();
    }

    public static double calculateAverageGrade(Student student) {
        List<Double> grades = student.getGrades();
        if (grades.isEmpty()) {
            throw new IllegalArgumentException("Student " + student.name + " has no grades.");
        }
        double sum = 0;
        for (Double grade : grades) {
            sum += grade;
        }
        return Math.round((sum / grades.size()) * 2) / 2.0;
    }
}

class Student {
    public String name;
    public int id;
    public int age;
    private List<Double> grades;

    public Student(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        if (grades.size() >= 20) {
            throw new IllegalStateException("Maximum number of grades reached for student " + name);
        }
        grades.add(grade);
    }

    public List<Double> getGrades() {
        return grades;
    }
}

class StudentGroup {
    public String groupName;
    public List<Student> students;

    public StudentGroup(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        if (students.size() >= 15) {
            throw new IllegalStateException("Maximum number of students reached for group " + groupName);
        }
        if (students.contains(student)) {
            throw new IllegalStateException("Student " + student.name + " is already in group " + groupName);
        }
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }
}

 */