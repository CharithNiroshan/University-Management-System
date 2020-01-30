package CLIprogramme;

public class Student {
    //STUDENT SIGN IN FORM
    public void student_form_signin()
    {
        System.out.println("Student Registration Form");
        System.out.println("==========================");
        Authentication object=new Authentication();
        object.signin();
    }

    //STUDENT SIGN UP FORM
    public void student_form_signup()
    {
        System.out.println("Student Registration Form");
        System.out.println("==========================");
        Authentication object=new Authentication();
        object.signup();
    }
}
