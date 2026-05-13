package dao;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> GetAllStudent() {
        List<Student> studentList = new ArrayList<>();
        Statement stmt = null;
        Connection conn = DBConnection.connection();
        String sqlGetAllStudent = "SELECT * FROM student";
        try {
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlGetAllStudent);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double score = rs.getDouble("score");
                String major = rs.getString("major");
                studentList.add(new Student(id, name, score, major));
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return studentList;
    }
}
