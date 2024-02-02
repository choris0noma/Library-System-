package library.system;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Library {
    Connection databaseRef;
    public Library()
    {
         databaseRef = DataBase.getInstance().getConnection();
    }
    private ArrayList<Book> books = new ArrayList<Book>(Arrays.asList(
            new Book("Romeo and Juliet", "William Shakespeare", "Tragedy", 2323, 1596, 10, true),
            new Book("Fight Club", "Chuck Palahniuk", "Novel", 4334, 1996, 3, true),
            new Book("Faust", "Johann Wolfgang Goethe", "Tragedy", 666, 1808, 6, true),
            new Book("Bible", "unknown", "Religious text", 333, 0, 1, false)
    ));

    private ArrayList<User> users = new ArrayList<User>(Arrays.asList(
            new Student("David", 229, new ArrayList<Book>(books.subList(0, 3))),
            new Student("Mark", 993, books.get(0)),
            new Student("William", 1111, books.get(2)),
            new User("John", 2938),
            new User("Ibrahim", 467)
    ));


    public void AddNewUser(User newUser)
    {
        if (!users.contains(newUser)) users.add(newUser);
        try {
            PreparedStatement ps = databaseRef.prepareStatement("INSERT INTO userstable (name, ID) VALUES (?,?) ");
            ps.setString(1, newUser.getName());
            ps.setInt(2, newUser.GetID());

            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("User deleted successfully.");
            else System.out.println("User not found or deletion failed.");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(newUser.getName() + " was added successfully!");

    }

    public void DeleteUser(String name)
    {
        try {
            PreparedStatement ps = databaseRef.prepareStatement("DELETE FROM userstable WHERE name = ?");

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("User deleted successfully.");
            else System.out.println("User not found or deletion failed.");

            }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DeleteUser(int id)
    {
        try {
            PreparedStatement ps = databaseRef.prepareStatement("DELETE FROM userstable WHERE id = ?");

            ps.setInt(1 , id);

            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("User deleted successfully.");
            else System.out.println("User not found or deletion failed.");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddNewBook(Book newBook)
    {
        if (!books.contains(newBook)) books.add(newBook);
        System.out.println(newBook.getTitle() + " was added to the library");
    }

    public void PrintAllBooks()
    {
        for (int i = 0; i < books.size(); i++)
        {
            var currentBook = books.get(i);
            System.out.println(i + 1 + ". " + " "+ currentBook.getTitle() + " by " + currentBook.getAuthor());
        }
        System.out.println();
    }
    public void PrintAllUsers()
    {
        for (int i = 0; i < users.size(); i++)
        {
            var currentUser = users.get(i);
            System.out.printf("%d. Name: %s ID: %d \n",i + 1, currentUser.getName(), currentUser.GetID());
        }
    }
    public User GetUser(int id)
    {
        for (User currentUser : users) {
            if (currentUser.GetID() == id) return currentUser;
        }
        System.out.println("|| User not found ||");
        return null;
    }
    public User GetUser(String name)
    {
        for (User currentUser : users) {
            if (Objects.equals(currentUser.GetName(), name)) return currentUser;
        }
        System.out.println("|| User not found ||");
        return null;
    }
    public void GetBookINFO(int id)
    {
        if (id >=0 && id < books.size())
        {
            books.get(--id).PrintInfo();
        }
        else System.out.println("|| ERROR ||");
    }
    public  void GetBookINFO(String searchBook)
    {
        searchBook = searchBook.trim().toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(searchBook)) book.PrintInfo();
            return;
        }
    }

    public Book GetBook(int num)
    {
        if (num >=0 && num < books.size())
        {
            return books.get(num);
        }
        else System.out.println("|| ERROR ||");
        return null;
    }

    public Book GetBook(String title)
    {
        title = title.trim().toLowerCase();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().equals(title)) return book;
        }
        System.out.println("|| Book not found ||");
        return null;
    }
}






