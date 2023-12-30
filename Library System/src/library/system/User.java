package library.system;

import java.util.ArrayList;

public class User {
    private int id;
    private String name;
    private String group;
    private ArrayList<Book> borrowed_books;

    public int getId() {
        return id;
    }
    public void setId(int userId) {
        if(userId < 0) {
            System.out.println("Error");
        }
        else {
            this.id = userId;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String userName){
        if(userName.isEmpty()) {
            System.out.println("User Name cannot be empty ! ");
        }
        else {
            this.name = userName;
        }
    }
    public String getGroup(){
        return group;
    }
    public void setGroup(String userGroup) {
        if(userGroup.isEmpty()) {
            System.out.println("User Group cannot be empty ! ");
        }
        else {
            this.group = userGroup;
        }
    }
    public ArrayList<Book> getBorrowed_books(){
        return borrowed_books;
    }
    public void setBorrowed_books(ArrayList<Book>BorrowedBook) {
        this.borrowed_books = BorrowedBook;
        ArrayList <String> BorrowedBooks1 = new ArrayList<>();
        ArrayList<String> BorrowedBook2 = new ArrayList<>();
        ArrayList<String> BorrowedBook3 = new ArrayList<>();
        ArrayList<String> BorrowedBook4 = new ArrayList<>();
        ArrayList<String> BorrowedBook5 = new ArrayList<>();
        ArrayList<String> BorrowedBook6 = new ArrayList<>();
        Library certain_book = new Library();
        User certain_id = new User();
        if (certain_id.getId() == 1 ) {
        BorrowedBooks1.add(certain_book.getBook1());
        BorrowedBooks1.add(certain_book.getBook6());
        BorrowedBooks1.add(certain_book.getBook11());
        BorrowedBooks1.add(certain_book.getBook16());
        System.out.println(BorrowedBooks1);
        }

        if (certain_id.getId() == 2) {
            BorrowedBook2.add(certain_book.getBook3());
            BorrowedBook2.add(certain_book.getBook20());
            BorrowedBook2.add(certain_book.getBook4());
            BorrowedBook2.add(certain_book.getBook18());
            System.out.println(BorrowedBook2);
        }
        if (certain_id.getId() == 3) {
            BorrowedBook3.add(certain_book.getBook7());
            BorrowedBook3.add(certain_book.getBook2());
            BorrowedBook3.add(certain_book.getBook5());
            System.out.println(BorrowedBook3);
        }
        else if (certain_id.getId() == 4 ) {
            BorrowedBook4.add(certain_book.getBook12());
            BorrowedBook4.add(certain_book.getBook11());
            BorrowedBook4.add(certain_book.getBook16());
            BorrowedBook4.add(certain_book.getBook13());
            System.out.println(BorrowedBook4);
        }
        else if (certain_id.getId() == 5 ) {
            BorrowedBook5.add(certain_book.getBook15());
            BorrowedBook5.add(certain_book.getBook20());
            BorrowedBook5.add(certain_book.getBook14());
            BorrowedBook5.add(certain_book.getBook10());
            System.out.println(BorrowedBook5);
        }
        else if (certain_id.getId() == 6 ) {
            BorrowedBook6.add(certain_book.getBook7());
            BorrowedBook6.add(certain_book.getBook16());
            BorrowedBook6.add(certain_book.getBook6());
            System.out.println(BorrowedBook6);
        }
        else {
            System.out.println("User do not found !!!");
        }

    }
}

