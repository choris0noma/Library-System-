package library.system;

import Commands.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.Scanner;

public class CommandsManager
{
    public void ParseCommands() {
        Scanner scan = new Scanner(System.in);

        var library = new Library();

        while (true) {
            PrintMenu();

            int option = scan.nextInt();
            ICommand com;
            switch (option)
            {
                case 1:
                    com = new AddBook();
                    com.Execute(library);
                    break;
                case 2:
                    com = new BookInfo();
                    com.Execute(library);
                    break;
                case 3:
                    com = new AddUser();
                    com.Execute(library);
                    break;
                case 4:
                    com = new GiveBook();
                    com.Execute(library);
                    break;
                case 5:
                    com = new ReturnBook();
                    com.Execute(library);
                    break;
                default:
                    System.out.println("not found");
            }
        }
    }

    private void PrintMenu()
    {
        System.out.print(
                "\n " +
                        "Hello, You have the following available functions: \n" +
                        "1) To add a new book; \n" +
                        "2) To show book info; \n" +
                        "3) To add a new user; \n" +
                        "4) To give a certain book to a certain user; \n" +
                        "5) To return a book back to the library from the user. \n" +
                        "Option: "
        );
    }
}
