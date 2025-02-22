package Ex4_2;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St");
        Student student = new Student("Jane Doe", "456 College Rd", "CS", 2, 15000.0);
        Staff staff = new Staff("Dr. Smith", "789 Faculty Ln", "XYZ University", 75000.0);

        System.out.println(person);
        System.out.println(student);
        System.out.println(staff);
    }
}
