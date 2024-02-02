package library.system;

import java.util.ArrayList;

public class Student extends User
{


    public Student(String name, int id) {
        super(name, id);
    }

    public Student(String name, int id, ArrayList<Book> borrowed_books) {
        super(name, id, borrowed_books);
    }

    public Student(String name, int id, Book borrowed_book) {
        super(name, id, borrowed_book);
    }

    public void GrantBook(Book newBook)
    {
        if (newBook.IsStudentBook())
        {
            GrantBook(newBook);
            AlertSuccess(newBook);
        }
        else System.out.println("This Book is not for students");
    }
}
