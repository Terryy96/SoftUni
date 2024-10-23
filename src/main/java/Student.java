import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
private String name;
private String lastName;
private int age;
private String hometown;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }


public Student (String name, String lastName, int age, String hometown){
        this.name=name;
        this.lastName=lastName;
        this.age=age;
        this.hometown=hometown;
}

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Student> students = new ArrayList<>();

        while (!input.equals("end")) {
            String[] data = input.split(" ");
            String name = data[0];
            String lastName = data[1];
            int age = Integer.parseInt(data[2]);
            String hometown = data[3];

            if (isStudentExisting(students, name, lastName)){
                Student student = getStudent(students, name, lastName);
            }else {
                Student student = new Student(name, lastName, age, hometown);
                students.add(student);
            }

            if (isStudentExisting(students, name, lastName)){
                Student student = getStudent(students, name, lastName);

                student.setName(name);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHometown(hometown);

            }

            input = scanner.nextLine();
        }

        String hometown = scanner.nextLine();

        for (Student student : students){
            if (student.getHometown().equals(hometown)){
                System.out.printf("%s %s is %d years old\n", student.getName(), student.getLastName(), student.getAge());
            }

        }
    }




    private static boolean isStudentExisting(List<Student> students, String name, String lastName){
        for (Student student : students){
            if (student.getName().equals(name) && student.getLastName().equals(lastName)){
                return true;
            }
        }
        return false;
    }
    public static Student getStudent(List<Student> students, String name, String lastName){
        Student existingStudent = null;

        for (Student student :students){
            if (student.getName().equals(name) && student.getLastName().equals(lastName)){
                existingStudent=student;
            }
        }
        return existingStudent;
    }
}
