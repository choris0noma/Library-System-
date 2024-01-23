package Commands;

import library.system.Library;
import library.system.User;

import java.util.Scanner;

public class BookInfo implements ICommand
{
    @Override
    public void Execute(Library libraryRef)
    {
        Scanner scan = new Scanner(System.in);
        libraryRef.PrintAllBooks();
        System.out.println("COMMANDS:\n 1. get info by number \n 2. to see users' borrowed books");
        System.out.print("Enter:");
        int option = scan.nextInt();

        switch (option)
        {
            case 1:
                System.out.print("Enter NUMBER or TITLE:");


                if (scan.hasNextInt())
                {
                    int id = scan.nextInt();
                    libraryRef.GetBook(id);
                }
                else
                {
                    String title = scan.nextLine();
                    libraryRef.GetBook(title);
                }

                break;
            case 2:
                libraryRef.PrintAllUsers();
                System.out.print("Enter NAME or ID:");
                User userRec;
                
                if (scan.hasNextInt())
                {
                    int ID = scan.nextInt();
                    userRec = libraryRef.GetUser(ID);
                    userRec.PrintBorrowedBooks();
                }
                else
                {
                    String name = scan.next();
                    userRec = libraryRef.GetUser(name);
                    userRec.PrintBorrowedBooks();
                }

                break;

        }
    }
}
