package model;

public class Student {
    private int id;
    private String name;
    private Double score;
    private String major;

    public Student(int id, String name, Double score, String major) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.major = major;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return String.format("%-4d | %-20s | %.2f | %s", id, name, score, major);
    }
}
