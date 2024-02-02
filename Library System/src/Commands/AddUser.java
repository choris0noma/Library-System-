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
        libraryRef.PrintAllUsers();
        System.out.println("COMMANDS:\n 1. add new user \n 2. delete user");
        System.out.print("Enter:");
        int option = scan.nextInt();
        scan.nextLine();
        switch (option)
        {
            case 1:
                AddNewUser(scan, libraryRef);
                break;
            case 2:
                DeleteUser(scan, libraryRef);

        }

    }

    private void AddNewUser(Scanner scan, Library libraryRef)
    {
        System.out.print("User Name:");
        String name = scan.nextLine();

        System.out.print("User ID:");
        int id = scan.hasNextInt() ? scan.nextInt() : 0;
        scan.nextLine();

        System.out.print("Is user a student? YES/NO:");
        String ans = scan.nextLine();

        User newUser;
        if (ans.trim().equalsIgnoreCase("yes")) {
            newUser = new Student(name, id);
        } else {
            newUser = new User(name, id);
        }

        libraryRef.AddNewUser(newUser);

    }
    private void DeleteUser(Scanner scan, Library libraryRef)
    {
        System.out.print("To delete enter NAME or ID:");

        if (scan.hasNextInt())
        {
            libraryRef.DeleteUser(scan.nextInt());
        }
        else
        {
            libraryRef.DeleteUser(scan.nextLine());
        }
    }


    }
