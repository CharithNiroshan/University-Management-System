package Interfaces;

public class Object {
    private String name;
    private String username;
    private String password;
    private int age;
    private String course1_code;
    private String course1_name;
    private String course2_code;
    private String course2_name;
    private String course3_code;
    private String course3_name;

    public Object(String name, String username, String password, int age, String course1_code, String course1_name, String course2_code, String course2_name, String course3_code, String course3_name) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.course1_code = course1_code;
        this.course1_name = course1_name;
        this.course2_code = course2_code;
        this.course2_name = course2_name;
        this.course3_code = course3_code;
        this.course3_name = course3_name;
    }

    public String getCourse1_code() {
        return course1_code;
    }

    public void setCourse1_code(String course1_code) {
        this.course1_code = course1_code;
    }

    public String getCourse1_name() {
        return course1_name;
    }

    public void setCourse1_name(String course1_name) {
        this.course1_name = course1_name;
    }

    public String getCourse2_code() {
        return course2_code;
    }

    public void setCourse2_code(String course2_code) {
        this.course2_code = course2_code;
    }

    public String getCourse2_name() {
        return course2_name;
    }

    public void setCourse2_name(String course2_name) {
        this.course2_name = course2_name;
    }

    public String getCourse3_code() {
        return course3_code;
    }

    public void setCourse3_code(String course3_code) {
        this.course3_code = course3_code;
    }

    public String getCourse3_name() {
        return course3_name;
    }

    public void setCourse3_name(String course3_name) {
        this.course3_name = course3_name;
    }



    //Course course[]=new Course[3];

    public Object(String name, String username, String password, int age) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public Object() {
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
