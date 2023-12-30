package library.system;

public class Book {
    private String title;
    private String isbn;
    private String genre;
    private String author;
    private int year;
    private int  quantity;

    public  String getTitle() {
       return title;
    }
    public void setTitle(String bookTitle){
        if(bookTitle.isEmpty()) {
            System.out.println("Title cannot be empty !");
        }
        else {
            this.title = bookTitle;
        }
    }
    public String getIsbn(){
        return isbn;
    }
    public void setIsbn(String bookIsbn){
         if(bookIsbn.isEmpty() ) {
            System.out.println("Error");
        }
         if(bookIsbn.length() > 14) {
             System.out.println("Error");
         }
        else {
            this.isbn = bookIsbn;
        }
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String bookGenre){
        if(bookGenre.isEmpty()) {
            System.out.println("Genre cannot be empty !");
        }
        else {
            this.genre = bookGenre;
        }
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String bookAuthor){
        if(bookAuthor.isEmpty()) {
            System.out.println("Author's name can not be empty !");
        }
        else if (bookAuthor.charAt(0) == 'a') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'b') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'c') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'd') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'e') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'f') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'g') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'h') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'i') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'j') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'k') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'l') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'm') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'n') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'o') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'p') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'q') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'r') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 's') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 't') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'u') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'v') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'w') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'x') {
            System.out.println("Author Name must be start capital letter !");
        }
        else if (bookAuthor.charAt(0) == 'z') {
            System.out.println("Author Name must be start capital letter !");
        }
        else {
            this.author = bookAuthor;
        }
    }
    public int getYear(){
        return year;
    }
    public void setYear(int bookYear){
        if(bookYear < 0 ) {
            System.out.println("Error !");
        }
        else if (bookYear > 2025 ) {
            System.out.println("Error !");
        }
        else if (bookYear < 2000) {
            System.out.println("Error");
        }
        else {
            this.year = bookYear;
        }
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int bookQuantity){
        if(bookQuantity == 0) {
            System.out.println("Quantity can not be 0 !");
        }
        else if (bookQuantity > 0) {
            System.out.println("Error");
        }
        else {
            this.quantity = bookQuantity;
        }

    }
}
