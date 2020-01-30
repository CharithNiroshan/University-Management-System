package CLIprogramme;

public class Lecturer {
    //LECTURER SIGN IN FORM
    public void lecture_form_signin()
    {
        System.out.println("Lecturer Sign in Form");
        System.out.println("==========================");
        Authentication object=new Authentication();
        object.signin();
    }

    //LECTURER SIGN UP FORM
    public void lecture_form_signup()
    {
        System.out.println("Lecturer Sign up Form");
        System.out.println("==========================");
        Authentication object=new Authentication();
        object.signup();
    }
}
