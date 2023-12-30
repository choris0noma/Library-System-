package library.system;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
public class LibrarySystem {
    public static void main(String[] args)  {
        Scanner scan = new Scanner(System.in);
        Book book  = new Book();
        Library certain_book = new Library();
        User user = new User();
        while (true) {
            System.out.println("\n");
            System.out.println("Hello, You have the following available functions:");
            System.out.println("1) To add a new book;");
            System.out.println("2) To show all available books;");
            System.out.println("3) To add a new user;");
            System.out.println("4) To give a certain book to a certain user;");
            System.out.println("5) To return a book back to the library from the user.");
            System.out.println("\n");
            System.out.print("Option: ");

            int option = scan.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Book Title: ");
                    String title = scan.nextLine();
                    title = scan.nextLine();
                    book.setTitle(title);
                    System.out.print("Book ISBN: ");
                    String isbn = scan.nextLine();
                    book.setIsbn(isbn);
                    System.out.print("Book Genre: ");
                    String genre = scan.nextLine();
                    book.setIsbn(genre);
                    System.out.print("Book Author: ");
                    String author = scan.nextLine();
                    book.setAuthor(author);
                    System.out.print("Book Year: ");
                    int year = scan.nextInt();
                    book.setYear(year);
                    System.out.print("Book Quantity: ");
                    int quantity = scan.nextInt();
                    book.setQuantity(quantity);
                    System.out.println("\n");
                    System.out.println("Added a new book !!!");
                    System.out.println("Title: " + title);
                    System.out.println("Isbn: " + isbn);
                    System.out.println("Genre: " + genre);
                    System.out.println("Author: " + author);
                    System.out.println("Year: " + year);
                    System.out.println("Quantity: " + quantity);
                    System.out.println("\t\t" + "Congratulations !!!");
                    break;

                case 2:
                    System.out.println("Choose Book Genre:");
                    System.out.println("1)Romance");
                    System.out.println("2)Thrillers and horror");
                    System.out.println("3)Fantasy and science fiction");
                    System.out.println("4)Travel");
                    System.out.println("5)Humor");
                    System.out.println("6) All Genre");

                    System.out.print("Your option: ");
                    int number = scan.nextInt();
                    switch (number) {
                        case 1:
                            System.out.println("Romance :");
                            System.out.println(certain_book.getBook1());
                            System.out.println(certain_book.getBook2());
                            System.out.println(certain_book.getBook3());
                            System.out.println(certain_book.getBook4());

                            break;
                        case 2:
                            System.out.println("Thrillers and horror :");
                            System.out.println(certain_book.getBook5());
                            System.out.println(certain_book.getBook6());
                            System.out.println(certain_book.getBook7());
                            System.out.println(certain_book.getBook8());
                            break;
                        case 3:
                            System.out.println("Fantasy and science fiction :");
                            System.out.println(certain_book.getBook9());
                            System.out.println(certain_book.getBook10());
                            System.out.println(certain_book.getBook11());
                            System.out.println(certain_book.getBook12());
                            break;
                        case 4:
                            System.out.println("Travel :");
                            System.out.println(certain_book.getBook13());
                            System.out.println(certain_book.getBook14());
                            System.out.println(certain_book.getBook15());
                            System.out.println(certain_book.getBook16());
                            break;
                        case 5:
                            System.out.println("Humor :");
                            System.out.println(certain_book.getBook17());
                            System.out.println(certain_book.getBook18());
                            System.out.println(certain_book.getBook19());
                            System.out.println(certain_book.getBook20());
                            break;
                        case 6:
                            System.out.println("Romance :");
                            System.out.println(certain_book.getBook1());
                            System.out.println(certain_book.getBook2());
                            System.out.println(certain_book.getBook3());
                            System.out.println(certain_book.getBook4());

                            System.out.println("\n");

                            System.out.println("Thrillers and horror :");
                            System.out.println(certain_book.getBook5());
                            System.out.println(certain_book.getBook6());
                            System.out.println(certain_book.getBook7());
                            System.out.println(certain_book.getBook8());

                            System.out.println("\n");

                            System.out.println("Fantasy and science fiction :");
                            System.out.println(certain_book.getBook9());
                            System.out.println(certain_book.getBook10());
                            System.out.println(certain_book.getBook11());
                            System.out.println(certain_book.getBook12());

                            System.out.println("\n");

                            System.out.println("Travel :");
                            System.out.println(certain_book.getBook13());
                            System.out.println(certain_book.getBook14());
                            System.out.println(certain_book.getBook15());
                            System.out.println(certain_book.getBook16());

                            System.out.println("\n");

                            System.out.println("Humor :");
                            System.out.println(certain_book.getBook17());
                            System.out.println(certain_book.getBook18());
                            System.out.println(certain_book.getBook19());
                            System.out.println(certain_book.getBook20());
                            break;

                        default:
                            System.out.println("Do not found !");
                            break;
                    }
                    break;

                case 3:
                    System.out.print("User Name: ");
                    String name = scan.nextLine();
                    name = scan.nextLine();
                    user.setName(name);
                    System.out.print("User Group: ");
                    String group = scan.nextLine();
                    user.setGroup(group);
                    System.out.println("\n");
                    System.out.println("User added successfully!");
                    System.out.println("User Name: " + name);
                    System.out.println("User Group: " + group);
                    break;

                case 4:
                    ArrayList<String> BorrowedBook1 = new ArrayList<>();
                    ArrayList<String> BorrowedBook2 = new ArrayList<>();
                    ArrayList<String> BorrowedBook3 = new ArrayList<>();
                    ArrayList<String> BorrowedBook4 = new ArrayList<>();
                    ArrayList<String> BorrowedBook5 = new ArrayList<>();
                    ArrayList<String> BorrowedBook6 = new ArrayList<>();
                    User c_user = new User();
                    System.out.print("User Id: ");
                    int  certain_id = scan.nextInt();
                    c_user.setId(certain_id);
                    System.out.print("Your book: ");
                    if (certain_id == certain_book.getId1()) {
                        BorrowedBook1.add(certain_book.getBook1());
                        BorrowedBook1.add(certain_book.getBook6());
                        BorrowedBook1.add(certain_book.getBook17());
                        BorrowedBook1.add(certain_book.getBook9());
                        System.out.println(BorrowedBook1 + "\n");
                        System.out.println("Hello, Mark" );
                    }
                    else if (certain_id == certain_book.getId2() ) {
                        BorrowedBook2.add(certain_book.getBook3());
                        BorrowedBook2.add(certain_book.getBook20());
                        BorrowedBook2.add(certain_book.getBook4());
                        BorrowedBook2.add(certain_book.getBook18());
                        System.out.println(BorrowedBook2);
                        System.out.println("Hello, Ali");
                    }
                    else if (certain_id == certain_book.getId3() ) {
                        BorrowedBook3.add(certain_book.getBook7());
                        BorrowedBook3.add(certain_book.getBook2());
                        BorrowedBook3.add(certain_book.getBook5());
                        System.out.println(BorrowedBook3);
                        System.out.println("Hello, Emma");
                    }
                    else if (certain_id == certain_book.getId4() ) {
                        BorrowedBook4.add(certain_book.getBook12());
                        BorrowedBook4.add(certain_book.getBook11());
                        BorrowedBook4.add(certain_book.getBook16());
                        BorrowedBook4.add(certain_book.getBook13());
                        System.out.println(BorrowedBook4);
                        System.out.println("Hello, Eva");
                    }
                    else if (certain_id == certain_book.getId5() ) {
                        BorrowedBook5.add(certain_book.getBook15());
                        BorrowedBook5.add(certain_book.getBook20());
                        BorrowedBook5.add(certain_book.getBook14());
                        BorrowedBook5.add(certain_book.getBook10());
                        System.out.println(BorrowedBook5);
                        System.out.println("Hello, Mark");
                    }
                    else if (certain_id == certain_book.getId6() ) {
                        BorrowedBook6.add(certain_book.getBook7());
                        BorrowedBook6.add(certain_book.getBook16());
                        BorrowedBook6.add(certain_book.getBook6());
                        System.out.println(BorrowedBook6);
                        System.out.println("Hello, Michael");
                    }
                    else {
                        System.out.println("User do not found !!!");
                    }
                    break;

                case 5:
                    System.out.print("User Id: ");
                    int ids = scan.nextInt();
                    ids = scan.nextInt();
                    user.setId(ids);
                    System.out.print("Return Book Name: ");
                    String rebook = scan.nextLine();
                    book.setTitle(rebook);
                    System.out.println("\n");
                    System.out.println("You returned successfully !!!");
                    System.out.println("Thank you for communication with us !!!");
                    System.out.println("Come back for new books. We are waiting you !!!");
                    break;

                default:
                    System.out.println("Do not found !");
                    System.out.println("Please, try again !");
                    break;
            }
        }
    }
}
