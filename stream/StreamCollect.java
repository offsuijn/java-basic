import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class StreamCollect {
    public static void main(String[] args) {
        Student[] stuArr = {
                new Student("정수진", 3, 100),
                new Student("장수진", 1, 200),
                new Student("박수진", 3, 300),
                new Student("최수진", 1, 150),
                new Student("맹수진", 1, 250),
                new Student("수진", 3, 170)
        };

        List<String> names = Stream.of(stuArr).map(Student::getName)
                .collect(Collectors.toList());
        System.out.println(names);

        Student[] stuArr2 = Stream.of(stuArr).toArray(Student[]::new);

        for(Student s : stuArr2)
            System.out.println(s);

        Map<String, Student> stuMap = Stream.of(stuArr)
                .collect(Collectors.toMap(s->s.getName(), p->p));

        for(String name : stuMap.keySet())
            System.out.println(name + "-" + stuMap.get(name));

        long count = Stream.of(stuArr).collect(counting());
        long totalScore = Stream.of(stuArr)
                .collect(summingInt(Student::getTotalScore));

        System.out.println("count =" + count);
        System.out.println("totalScore = " + totalScore);

        Optional<Student> topStudent = Stream.of(stuArr)
                .collect(maxBy(Comparator.comparingInt(Student::getTotalScore)));
        System.out.println("totalScore = " + totalScore);

        String stuNames = Stream.of(stuArr).map(Student::getName)
                .collect(Collectors.joining(",", "{", "}"));

        System.out.println(stuNames);
    }
}
