import service.StudentService;
import service.StudentServiceImpl;

public class Main {
    private static final StudentServiceImpl studentService = new StudentServiceImpl();
    public static void main(String[] args) {
        studentService.displayAllStudent();
        System.out.println("--------------------");
        studentService.displayStudentByScore();
        System.out.println("--------------------");
        studentService.caculateAverageScore();
        System.out.println("--------------------");
        studentService.statisticStudentByMajor();
        System.out.println("--------------------");
        studentService.findStudentHighestScore();
        System.out.println("--------------------");
        studentService.find3StudentHighestScore();
    }
}
