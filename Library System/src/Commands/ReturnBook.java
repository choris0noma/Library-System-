package Commands;

import library.system.Library;
import library.system.User;

import java.util.Scanner;

public class ReturnBook implements ICommand
{

    @Override
    public void Execute(Library libraryRef)
    {
        Scanner scan = new Scanner(System.in);
        libraryRef.PrintAllUsers();
        System.out.print("Select user by NAME or ID:");
        User userRec;
        if (scan.hasNextInt())
        {
            int num = scan.nextInt();
            userRec = libraryRef.GetUser(num);
        }
        else
        {
            String name = scan.next();
            userRec = libraryRef.GetUser(name);
        }

        userRec.PrintBorrowedBooks();
        System.out.print("Select book by TITLE or NUMBER:");
        if (scan.hasNextInt())
        {
            int id = scan.nextInt() - 1;
            userRec.GiveInBook(id);
        }
        else
        {
            String title = scan.nextLine();
            userRec.GiveInBook(title);
        }
        System.out.println("The Book was returned");
    }
}
