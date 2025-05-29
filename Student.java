import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Student {
    private String name;
    private LocalDate dob;

    public Student(String name, String dobStr) {
        this.name = name;
        this.dob = parseDate(dobStr);
    }

    private LocalDate parseDate(String dobStr) {
        DateTimeFormatter formatter;
        if (dobStr.charAt(4) == '-') {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        }
        return LocalDate.parse(dobStr, formatter);
    }

    public void displayStudentInfo() {
        int age = Period.between(this.dob, LocalDate.now()).getYears();
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        Student s = new Student("shreya", "05-07-2005"); 
        s.displayStudentInfo();
    }
}
