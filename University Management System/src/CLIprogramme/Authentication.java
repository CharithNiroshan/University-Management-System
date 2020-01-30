package CLIprogramme;

import java.util.Scanner;

public class Authentication {
    //VARIABLES DECLARATION
    private String name;
    private String username;
    private String password;
    private int age;
    private String[] course_code=new String[3];
    private String[] course_name=new String[3];
    int role;

    //SCANNER OBJECT DECLARATION
    Scanner sc=new Scanner(System.in);

    //NULL CONSTRUCTOR
    public Authentication() {
    }

    //PARAMETER CONSTRUCTOR
    public Authentication(String name, String username, String password, int age,String[] course_code, String[] course_name) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;
        this.course_code = course_code;
        this.course_name = course_name;
    }

    //GETTERS AND SETTERS

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

    public String[] getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String[] course_code) {
        this.course_code = course_code;
    }

    public String[] getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String[] course_name) {
        this.course_name = course_name;
    }

    //SIGN IN ROLE SELECTION
    public void role_signin()
    {
        System.out.println("Please select your registration role [1] Lecturer,[2] Student.");
        System.out.println("Enter your choice:");
        role=sc.nextInt();
        switch(role)
        {
            case 1:Lecturer newlecturer=new Lecturer();
                newlecturer.lecture_form_signin();
                break;
            case 2:Student newstudent=new Student();
                newstudent.student_form_signin();
                break;
            default:System.out.println("Invalid choice");
        }
    }

    //SIGN UP ROLE SELECTION
    public void role_signup()
    {
        System.out.println("Please select your registration role [1] Lecturer,[2] Student.");
        System.out.println("Enter your choice:");
        role=sc.nextInt();
        switch(role)
        {
            case 1:Lecturer newlecturer=new Lecturer();
                newlecturer.lecture_form_signup();
                break;
            case 2:Student newstudent=new Student();
                newstudent.student_form_signup();
                break;
            default:System.out.println("Invalid choice");
        }
    }

    //SIGN UP METHOD
    public void signup()
    {
        System.out.println("Name:");
        String name=sc.nextLine();
        System.out.println("User Name:");
        String username=sc.nextLine();
        System.out.println("Password:");
        String password=sc.nextLine();
        System.out.println("Age:");
        int age=sc.nextInt();
        setName(name);
        setUsername(username);
        setPassword(password);
        setAge(age);
        System.out.println("Select the courses(If you are a lecturer only register for the course you lecture):");
        System.out.println("[1].SENG 11111:Object Oriented Programming");
        System.out.println("[2].SENG 11112:Introduction to Database");
        System.out.println("[3].SENG 11113:Project Management");
        System.out.println("Enter your choice:");
        String coursechoice=sc.next();
        String[] part=coursechoice.split(",");
        for(int i=0;i<part.length;i++)
        {
            switch (part[i])
            {
                case "1":this.course_code[i]="SENG 11111";
                    this.course_name[i]="Object Oriented Programming";
                    break;
                case "2":this.course_code[i]="SENG 11112";
                    this.course_name[i]="Introduction to Database";
                    break;
                case "3":this.course_code[i]="SENG 11113";
                    this.course_name[i]="Project Management";
                    break;
            }
        }
        DBConnection con=new DBConnection();
        System.out.println(getName());
        con.insert_student(getName(),getUsername(),getPassword(),getAge(),course_code[0],course_name[0],course_code[1],course_name[1],course_code[2],course_name[2]);
    }

    //SIGN IN METHOD
    public void signin() {
        System.out.println("User Name:");
        String username = sc.nextLine();
        System.out.println("Password:");
        String password = sc.nextLine();
        setUsername(username);
        setPassword(password);
        DBConnection con=new DBConnection();
        con.retrieve_student(getUsername(),getPassword());
    }


    //REGISTER NEW COURSE METHOD
    public void register_new_course(String username,String password)
    {
        System.out.println();
        System.out.println("Please Select a Option:");
        System.out.println("[1].Update courses");
        System.out.println("[2].exit");
        int new_choice=sc.nextInt();
        switch (new_choice)
        {
            case 1: System.out.println("Select all the courses you want to register:");
                System.out.println("[1].SENG 11111:Object Oriented Programming");
                System.out.println("[2].SENG 11112:Introduction to Database");
                System.out.println("[3].SENG 11113:Project Management");
                System.out.println("Enter your choice:");
                String coursechoice=sc.next();
                String[] part=coursechoice.split(",");
                for(int i=0;i<part.length;i++)
                {
                    switch (part[i])
                    {
                        case "1":this.course_code[i]="SENG 11111";
                            this.course_name[i]="Object Oriented Programming";
                            break;
                        case "2":this.course_code[i]="SENG 11112";
                            this.course_name[i]="Introduction to Database";
                            break;
                        case "3":this.course_code[i]="SENG 11113";
                            this.course_name[i]="Project Management";
                            break;
                    }
                }
                DBConnection con=new DBConnection();
                con.altering_student(username,password,course_code[0],course_name[0],course_code[1],course_name[1],course_code[2],course_name[2]);
            case 2:break;

        }
    }
}
