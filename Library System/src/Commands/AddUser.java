package Commands;

import library.system.Library;
import library.system.Student;
import library.system.User;

import java.util.Scanner;

public class AddUser implements ICommand
{

    @Override
    public void Execute(Library libraryRef)
    {
        Scanner scan = new Scanner(System.in);

        System.out.print("User Name:");
        String name = scan.nextLine();

        System.out.print("User ID:");
        int id = scan.hasNextInt()? scan.nextInt(): 0;
        scan.nextLine();

        System.out.print("Is user a student? YES/NO:");
        String ans = scan.nextLine();

        if (ans.trim().equalsIgnoreCase("yes"))
        {
            Student newStudent = new Student(name, id);
            libraryRef.AddNewUser(newStudent);

        }
        else
        {
            User newUser = new User(name, id);
            libraryRef.AddNewUser(newUser);

        }



    }
}
