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
        System.out.print("Select user ID:");
        int id = scan.nextInt();
        libraryRef.GetUserBorrowedBooks(id);

        System.out.print("Select book ISBN:");
        int isbn = scan.nextInt();

        System.out.print("Select book amount:");
        int quantity = scan.nextInt();

        libraryRef.ReturnBookToLib(isbn,id, quantity);

    }
}
