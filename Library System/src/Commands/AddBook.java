package Commands;

import library.system.Book;
import library.system.Library;

import java.util.Scanner;

public class AddBook implements ICommand
{
    @Override
    public void Execute(Library libraryRef)
    {
        Scanner scan = new Scanner(System.in);
        String title;
        String author;
        String genre;
        int isbn;
        int year;
        int quantity;
        boolean flag;


        System.out.print("Book title:");
        title = scan.nextLine();

        System.out.print("Author's name:");
        author = scan.nextLine();

        System.out.print("Genre:");
        genre = scan.nextLine();

        System.out.print("ISBN:");
        isbn = scan.nextInt();

        System.out.print("Year:");
        year = scan.hasNextInt()?  scan.nextInt() : 0;

        System.out.print("Quantity:");
        quantity = scan.hasNextInt()?  scan.nextInt() : 0;
        scan.nextLine();


        System.out.print("Is this book for students? YES/NO:");
        String ans = scan.nextLine();
        flag= ans.trim().equalsIgnoreCase("yes");

        Book newBook = new Book(isbn, title, author, genre , year, flag, quantity);
        libraryRef.AddNewBook(newBook);
    }


}
