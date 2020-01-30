package CLIprogramme;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("\t\t\t\t\t\t\t\t\t\t\tWelcome to University Management System");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t=======================================");
        System.out.println("Select [1] to sign in,[2] to sign up.");
        System.out.println("Enter your choice:");
        int signchoice=sc.nextInt();
        Authentication object=new Authentication();
        switch(signchoice)
        {
            case 1:object.role_signin();
                break;
            case 2:object.role_signup();
                break;
            default:System.out.println("Invalid Choice");
        }
    }
}
