package TH240425;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("An", 75),
                new Student("Binh", 45),
                new Student("Chi", 90),
                new Student("Dung", 30),
                new Student("Em", 60)
        );

        Optional<Student> topStudent = students.stream()
                .max(Comparator.comparingInt(Student::getScore));

        topStudent.ifPresent(s -> {
            System.out.println("Bài 1 - Top student: " + s.getName() + " - " + s.getScore());
        });

        double average = students.stream()
                .mapToInt(Student::getScore)
                .average()
                .orElse(0);

        System.out.println("Bài 2 - Average score: " + average);

        Map<String, List<Student>> grouped = students.stream()
                .collect(Collectors.groupingBy(s -> s.getScore() >= 50 ? "Pass" : "Fail"));

        System.out.println("Bài 3 - Pass group: " + grouped.get("Pass"));
        System.out.println("Bài 3 - Fail group: " + grouped.get("Fail"));
    }
}
