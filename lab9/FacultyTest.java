package lab9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FacultyTest {
	public static void main(String[] args) {
        // Creating sample students
        Student student1 = new Student("1", "Alice", 2022);
        Student student2 = new Student("2", "Bob", 2023);
        Student student3 = new Student("3", "Charlie", 2022);

        // Creating sample courses with students
        List<Student> studentsCourse1 = new ArrayList<>(Arrays.asList(student1, student2));
        Course course1 = new Course("C1", "Java Programming", "Programming", studentsCourse1, "John Doe");

        List<Student> studentsCourse2 = new ArrayList<>(Arrays.asList(student3));
        Course course2 = new Course("C2", "Data Structures", "Programming", studentsCourse2, "Jane Smith");

        List<Student> studentsCourse3 = new ArrayList<>(Arrays.asList(student1, student3));
        Course course3 = new Course("C3", "English Literature", "Literature", studentsCourse3, "Emily Johnson");

        List<Course> courses = new ArrayList<>(Arrays.asList(course1, course2, course3));

        // Creating a Faculty instance
        Falculty faculty = new Falculty("Example University", "123 Main St", courses);

        // Test getMaxPracticalCourse method
        Course maxPracticalCourse = faculty.getMaxPracticalCourse();
        System.out.println("Course with maximum students enrolled: " + maxPracticalCourse.getTitle());

        // Test groupStudentsByYear method
        Map<Integer, List<Student>> studentsByYear = faculty.groupStudentsByYear();
        for (Map.Entry<Integer, List<Student>> entry : studentsByYear.entrySet()) {
            System.out.println("Students in year " + entry.getKey() + ": " + entry.getValue().size());
        }

        // Test filterCourses method
        String typeToFilter = "Programming";
        Set<Course> filteredCourses = faculty.filterCourses(typeToFilter);
        System.out.println("Filtered courses of type " + typeToFilter + ":");
        for (Course course : filteredCourses) {
            System.out.println(course.getTitle() + " " + course.getStuNum());
        }
    }
}
