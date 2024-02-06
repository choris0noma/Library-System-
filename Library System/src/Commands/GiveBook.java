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

        System.out.print("Enter book ISBN:");
        int num = scan.nextInt();

        System.out.print("Enter user NAME or ID:");
        int id = scan.nextInt();

        System.out.print("Enter quantity:");
        int quantity = scan.nextInt();

        libraryRef.GiveBook(num, id, quantity);

    }

}
