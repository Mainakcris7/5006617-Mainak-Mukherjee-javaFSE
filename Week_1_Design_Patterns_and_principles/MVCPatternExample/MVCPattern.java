// Model
class Student {
    private String name;
    private String id;
    private String grade;

    public Student(String name, String id, String grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getGrade() {
        return grade;
    }

}

// View
class StudentView {
    public void displayStudentDetails(String studentName, String studentId, String studentGrade) {
        System.out.println("Student: ");
        System.out.println("Name: " + studentName);
        System.out.println("ID: " + studentId);
        System.out.println("Grade: " + studentGrade);
    }
}

// Controller
class StudentController {
    private Student student;
    private StudentView view;

    StudentController(Student student, StudentView view) {
        this.student = student;
        this.view = view;
    }

    public void setStudentName(String name) {
        student.setName(name);
        updateView();
    }

    public String getStudentName() {
        return student.getName();
    }

    public void setStudentId(String id) {
        student.setId(id);
        updateView();
    }

    public String getStudentId() {
        return student.getId();
    }

    public void setStudentGrade(String grade) {
        student.setGrade(grade);
        updateView();
    }

    public String getStudentGrade() {
        return student.getGrade();
    }

    public void updateView() {
        view.displayStudentDetails(student.getName(), student.getId(), student.getGrade());
    }
}

public class MVCPattern {
    public static void main(String[] args) {
        Student student = new Student("Mainak Mukherjee", "student_48", "O");
        StudentView viewDetails = new StudentView();
        viewDetails.displayStudentDetails(student.getName(), student.getId(), student.getGrade());

        StudentController controller = new StudentController(student, viewDetails);
        controller.setStudentGrade("A+"); // View automatically updated after changing the grade
    }
}