package library.system;


import java.time.Year;
import java.util.Random;

public class Book
{
    private String _title, _genre, _author;
    private int _year, _quantity, _isbn;
    private boolean _isForStudents = true;

    public String getTitle() {
        return _title;
    }
    public int getIsbn(){
        return _isbn;
    }
    public String getGenre(){
        return _genre;
    }
    public String getAuthor(){ return _author; }
    public int getYear(){
        return _year;
    }
    public boolean IsStudentBook() {return _isForStudents;}

    public Book(int isbn , String title,String author, String genre, int year, boolean isForStudents, int quantity)
    {
        String DEF_STR = "Error";
        _title = !title.isEmpty() ? title.trim() : DEF_STR;
        _genre = !genre.isEmpty() ? genre : DEF_STR;
        _author = !author.isEmpty() ? author : DEF_STR;
        _year = year <= Year.now().getValue() ? year : 0;
        _isbn = isbn > 0 ? isbn : new Random().nextInt(99999);
        _quantity = Math.max(quantity, 0);
        _isForStudents = isForStudents;
    }

    public void PrintInfo()
    {
        System.out.printf("Title: %s \n Author: %s \n Genre: %s \n ISBN: %s \n Year: %d \n Quantity: %d",_title, _author, _genre, _isbn, _year, _quantity );
    }

}