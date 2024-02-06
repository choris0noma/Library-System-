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
        System.out.println("COMMANDS:\n 1. to see users' borrowed books \n 2. to update book info \n 3.to delete book");
        System.out.print("Enter:");
        int option = scan.nextInt();

        switch (option)
        {
            case 1:
                libraryRef.PrintAllUsers();
                System.out.print("Enter ISBN:");
                int id = scan.nextInt();
                libraryRef.GetUserBorrowedBooks(id);
                break;
            case 2:
                System.out.print("Select by ISBN:");
                int isbn = scan.nextInt();
                scan.nextLine();

                System.out.print("Enter NEW TITLE:");
                String title = scan.nextLine();

                System.out.print("Enter NEW AUTHOR:");
                String author = scan.nextLine();

                System.out.print("Enter NEW GENRE:");
                String genre = scan.nextLine();

                System.out.print("Enter NEW YEAR OF PUBLICATION:");
                String yearInput = scan.nextLine();
                Integer year = null;

                if (!yearInput.isEmpty()) {
                    try {
                        year = Integer.parseInt(yearInput);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid year format. Year will be left unchanged.");
                    }
                }

                System.out.print("Enter NEW STATUS, is Student yes/no?:");
                String ans = scan.next();
                Boolean flag = null;
                if (!ans.isEmpty()) {
                   flag = ans.trim().equalsIgnoreCase("yes");
                }

                libraryRef.UpdateBook(isbn,title, author, genre, year, flag);
                break;
            case 3:
                System.out.print("Enter ISBN:");
                int num = scan.nextInt();
                libraryRef.DeleteBook(num);

        }
    }
}
