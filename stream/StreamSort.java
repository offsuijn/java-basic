import java.util.Comparator;
import java.util.stream.Stream;

public class StreamSort {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("정수진", 3, 100),
                new Student("hehe", 1, 200)
        );
        
        studentStream.sorted(Comparator.comparing(Student::getBan)
        .thenComparing(Comparator.naturalOrder()))
                .forEach(System.out::println);
    }
}

class Student implements Comparator<Student> {
    String name;
    int ban;
    int totalScore;
    
    Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }
    
    public int compareTo(Student s) {
    return s.totalScore - this.totalScore;}
}
