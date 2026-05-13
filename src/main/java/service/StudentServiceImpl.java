package service;

import dao.StudentDaoImpl;
import model.Student;

import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService{
    private final StudentDaoImpl studentDao;

    public StudentServiceImpl() {
        this.studentDao = new StudentDaoImpl();
    }

    @Override
    public void displayAllStudent() {
        List<Student> students = studentDao.GetAllStudent();
        if (students.isEmpty()) {
            System.out.println("Danh sach rong");
        }
        students.stream()
                .map(Student::toString)
                .forEach(System.out::println);
    }

    @Override
    public void displayStudentByScore() {
        List<Student> students = studentDao.GetAllStudent();
        if (students.isEmpty()) {
            System.out.println("Danh sach rong");
        }
        students.stream()
                .filter(student -> student.getScore() >= 8.0)
                .map(Student::toString)
                .forEach(System.out::println);
    }

    @Override
    public void caculateAverageScore() {
        List<Student> students = studentDao.GetAllStudent();
        if (students.isEmpty()) {
            System.out.println("Danh sach rong");
        }
        double averageScore = students.stream()
                .mapToDouble(Student::getScore)
                .average()
                .orElse(0.0);
        System.out.println("Diem trung binh cua sinh vien: " + averageScore);
    }

    @Override
    public void statisticStudentByMajor() {
        List<Student> students = studentDao.GetAllStudent();
        if (students.isEmpty()) {
            System.out.println("Danh sach rong");
        }
        Map<String, Long> studentCount = students.stream()
                .collect(Collectors.groupingBy(
                        Student::getMajor,
                        Collectors.counting()
                ));
        System.out.println("Thong ke so luong sinh vien theo chuyen nganh: " + studentCount);
    }

    @Override
    public void findStudentHighestScore() {
        List<Student> students = studentDao.GetAllStudent();
        if (students.isEmpty()) {
            System.out.println("Danh sach rong");
        }
        String studentHighestScore = students.stream()
                .filter(student -> student.getMajor().equalsIgnoreCase("IT"))
                .max((s1, s2) -> Double.compare(s1.getScore(), s2.getScore()))
                .map(Student::toString)
                .orElse("Khong co sinh vien nao");
        System.out.println("SInh vien co diem cao nhat trong chuyen nganh IT: " + studentHighestScore);
    }

    @Override
    public void find3StudentHighestScore() {
        List<Student> students = studentDao.GetAllStudent();
        if (students.isEmpty()) {
            System.out.println("Danh sach rong");
        }
        List<Student> top3Students = students.stream()
                .sorted((s1, s2) -> Double.compare(s2.getScore(), s1.getScore()))
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("3 sinh vien co diem cao nhat: ");
        top3Students.stream()
                .map(Student::toString)
                .forEach(System.out::println);
    }
}
