import java.util.*;

public class StudentService {
    private List<Student> studentList = new ArrayList<>();

    // Add a student
    public void addStudent(Student student) {
        studentList.add(student);
        System.out.println("✅ Student added successfully.");
    }

    // View all students
    public void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("⚠️ No student records found.");
        } else {
            for (Student s : studentList) {
                System.out.println(s);
            }
        }
    }

    // Search student by roll number
    public Student searchStudent(int rollNumber) {
        for (Student s : studentList) {
            if (s.getRollNumber() == rollNumber) {
                return s;
            }
        }
        return null;
    }

    // Update student by roll number
    public boolean updateStudent(int rollNumber, String newName, String newCourse) {
        Student s = searchStudent(rollNumber);
        if (s != null) {
            s.setName(newName);
            s.setCourse(newCourse);
            return true;
        }
        return false;
    }

    // Delete student by roll number
    public boolean deleteStudent(int rollNumber) {
        Iterator<Student> iterator = studentList.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getRollNumber() == rollNumber) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
