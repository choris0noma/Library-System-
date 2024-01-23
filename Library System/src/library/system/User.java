package library.system;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;

public class User
{
    private int _id;
    private String _name;
    private ArrayList<Book> _borrowed_books = new ArrayList<Book>();
    public String getName(){
        return _name;
    }

    public int GetID() {return _id;}
    public String GetName() {return _name; }

    public User(String name, int id)
    {
        _name = name;
        _id = id;
    }

    public User(String name, int id , ArrayList<Book> borrowed_books)
    {
        _name = name;
        _id = id;
        _borrowed_books.addAll(borrowed_books);
    }
    public User(String name, int id , Book borrowed_book)
    {
        _name = name;
        _id = id;
        _borrowed_books.add(borrowed_book);
    }

    public void PrintBorrowedBooks()
    {
        if (_borrowed_books.isEmpty())
        {
            System.out.printf("%s doesn't have any books \n", _name);
        }
        for (int i = 0; i < _borrowed_books.size(); i++)
        {
            var currentBook = _borrowed_books.get(i);
            System.out.println(++i + ". " + " "+ currentBook.getTitle() + " by " + currentBook.getAuthor());
        }
        System.out.println();
    }

    public void GiveInBook(int id)
    {
        if (id >= 0 && id < _borrowed_books.size()) _borrowed_books.remove(id);
        else System.out.println("|| NOT FOUND ||");
    }
    public void GiveInBook(String name)
    {
        name = name.trim().toLowerCase();
        for (Book b: _borrowed_books)
        {
            if (b.getTitle().toLowerCase().equals(name)) _borrowed_books.remove(b);
        }
        System.out.println("|| ERROR NOT FOUND ||");
    }

    public void GrantListBooks(ArrayList<Book> newBooks)
    {
        _borrowed_books.addAll(newBooks);
    }

    public void GrantBook(Book newBook)
    {
        _borrowed_books.add(newBook);
    }
    protected void AlertSuccess(Book b)
    {
        System.out.printf("The book: %s was given to user: %s", b.getTitle(),_name );
    }
}

