package Commands;

import library.system.Book;
import library.system.Library;
import library.system.User;

import java.util.Scanner;

public class GiveBook implements ICommand
{

    @Override
    public void Execute(Library libraryRef)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("|| LIST OF USERS: ||");
        libraryRef.PrintAllUsers();

        System.out.println("|| LIST OF BOOKS: ||");
        libraryRef.PrintAllBooks();

        System.out.print("Enter book TITLE or NUMBER:");
        Book bookGrant;
        if (scan.hasNextInt())
        {
            int num = scan.nextInt() - 1;
            bookGrant = libraryRef.GetBook(num);
        }
        else
        {
            String name = scan.next();
            bookGrant = libraryRef.GetBook(name);
        }

        User userRec;
        System.out.print("Enter user NAME or ID:");
        if (scan.hasNextInt())
        {
            int id = scan.nextInt();
            userRec = libraryRef.GetUser(id);
            userRec.GrantBook(bookGrant);
        }
        else
        {
            String name = scan.next();
            userRec = libraryRef.GetUser(name);
            userRec.GrantBook(bookGrant);
        }


    }

}
