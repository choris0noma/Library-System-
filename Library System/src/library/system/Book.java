package library.system;


import java.time.Year;

public class Book
{
    private String _title, _isbn, _genre, _author;
    private int _year, _quantity;
    private boolean _isForStudents = true;

    public String getTitle() {
        return _title;
    }
    public String getIsbn(){
        return _isbn;
    }
    public String getGenre(){
        return _genre;
    }
    public String getAuthor(){ return _author; }
    public int getYear(){
        return _year;
    }
    public boolean IsStdentBook() {return _isForStudents;}

    public Book(String title,String author, String genre, String isbn , int year, int quantity, boolean isForStudents)
    {
        String DEF_STR = "Error";
        _title = !title.isEmpty() ? title.trim() : DEF_STR;
        _isbn = !title.isEmpty() ? isbn : DEF_STR;
        _genre = !title.isEmpty() ? genre : DEF_STR;
        _author = !title.isEmpty() ? author : DEF_STR;
        _year = year <= Year.now().getValue() ? year : 0;
        _quantity = Math.max(quantity, 0);
        _isForStudents = isForStudents;
    }

    public void PrintInfo()
    {
        System.out.printf("Title: %s \n Author: %s \n Genre: %s \n ISBN: %s \n Year: %d \n Quantity: %d",_title, _author, _genre, _isbn, _year, _quantity );
    }

}