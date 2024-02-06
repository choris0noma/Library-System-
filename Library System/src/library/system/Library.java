package library.system;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Library {
    Connection databaseRef;
    public Library()
    {
         databaseRef = DataBase.getInstance().getConnection();
    }

    public void UpdateBook(int isbn, String title, String author, String genre, Integer year, Boolean isStudent) {
        StringBuilder sqlBuilder = new StringBuilder("UPDATE books_storage SET ");

        List<Object> parameters = new ArrayList<>();
        if (!title.isEmpty()) {
            sqlBuilder.append("title = ?, ");
            parameters.add(title);
        }
        if (!author.isEmpty()) {
            sqlBuilder.append("author = ?, ");
            parameters.add(author);
        }
        if (!genre.isEmpty()) {
            sqlBuilder.append("genre = ?, ");
            parameters.add(genre);
        }
        if (year != null) {
            sqlBuilder.append("year_of_publication = ?, ");
            parameters.add(year);
        }
        if (isStudent != null) {
            sqlBuilder.append("uni_access_status = ?, ");
            parameters.add(isStudent);
        }


        sqlBuilder.delete(sqlBuilder.length() - 2, sqlBuilder.length());


        sqlBuilder.append(" WHERE isbn = ?");

        try {
            PreparedStatement preparedStatement = databaseRef.prepareStatement(sqlBuilder.toString());

            int i = 1;
            for (Object parameter : parameters)
            {
                preparedStatement.setObject(i++, parameter);
            }
            preparedStatement.setInt(i, isbn);

            int rowsUpdated = preparedStatement.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Book updated.");
            } else {
                System.out.println("No book updated.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void GiveBook(int isbn, int id, int quantity)
    {
        String updateSql = "UPDATE borrowed_books SET quantity = quantity + ? WHERE user_id = ? AND book_isbn = ?";
        String insertSql = "INSERT INTO borrowed_books (user_id, book_isbn, quantity) VALUES (?,?,?)";
        try {
            PreparedStatement updateS = databaseRef.prepareStatement(updateSql);
            updateS.setInt(1, quantity);
            updateS.setInt(2, id);
            updateS.setInt(3, isbn);

            PreparedStatement insertS = databaseRef.prepareStatement(insertSql);
            insertS.setInt(1, id);
            insertS.setInt(2, isbn);
            insertS.setInt(3, quantity);

            int updatedRows = updateS.executeUpdate();
            if (updatedRows <= 0)
            {
                int rowsUpdated = insertS.executeUpdate();
                if (rowsUpdated <= 0)
                {
                    System.out.println("Something went wrong");
                } else{
                    System.out.println("Book was given");
                }
            }
            else
            {
                System.out.println("Book was given");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddNewUser(User newUser)
    {
        try {
            PreparedStatement ps = databaseRef.prepareStatement("INSERT INTO userstable (name, ID) VALUES (?,?) ");
            ps.setString(1, newUser.getName());
            ps.setInt(2, newUser.GetID());

            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("User was added successfully.");
            else System.out.println("Something went wrong");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void DeleteUser(String name)
    {
        try {
            PreparedStatement ps = databaseRef.prepareStatement("DELETE FROM userstable WHERE name = ?");

            ps.setString(1, name);

            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("User was deleted successfully.");
            else System.out.println("User not found or deletion failed.");

            }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DeleteUser(int id)
    {
        String sql = "DELETE FROM userstable WHERE id = ?";
        try {
            PreparedStatement ps = databaseRef.prepareStatement(sql);

            ps.setInt(1 , id);

            int rows = ps.executeUpdate();

            if (rows > 0) System.out.println("User was deleted successfully.");
            else System.out.println("User not found or deletion failed.");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void AddNewBook(Book newBook)
    {
        String insertSql = "INSERT INTO books_storage (isbn, title, author, genre, year, uni_access_status) VALUES (?,?,?,?,?,?) ";
        try {
            PreparedStatement insertS = databaseRef.prepareStatement(insertSql);
            insertS.setInt(1, newBook.getIsbn());
            insertS.setString(2, newBook.getTitle());
            insertS.setString(3, newBook.getAuthor());
            insertS.setString(4, newBook.getGenre());
            insertS.setInt(5, newBook.getYear());
            insertS.setBoolean(6, newBook.IsStudentBook());

            int rows = insertS.executeUpdate();
            if (rows > 0) System.out.println("Book wad added successfully.");
            else System.out.println("Something went wrong");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void DeleteBook(int id)
    {
        String sql = "DELETE FROM books_storage WHERE isbn = ?";
        String secondSql = "DELETE FROM borrowed_books WHERE book_isbn = ?";
        try {
            PreparedStatement ps = databaseRef.prepareStatement(sql);
            PreparedStatement ds = databaseRef.prepareStatement(secondSql);
            ps.setInt(1 , id);
            ds.setInt(1, id);
            int rows = ps.executeUpdate();
            ds.executeUpdate();
            if (rows > 0) System.out.println("Book was deleted successfully.");
            else System.out.println("Book not found or deletion failed.");

        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void PrintAllBooks()
    {
        String sql = "SELECT * FROM books_storage";

        try{
            PreparedStatement preparedStatement = databaseRef.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int isbn = resultSet.getInt("isbn");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String genre = resultSet.getString("genre");
                    int year = resultSet.getInt("year");
                    String status = resultSet.getBoolean("uni_access_status")? "universal": "restricted";
                    System.out.printf("ISBN:%d. Title:%s Author:%s Genre:%s Year:%d Status:%s \n", isbn, title, author, genre, year, status);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void PrintAllUsers()
    {
        String sql = "SELECT * FROM userstable";

        try{
            PreparedStatement preparedStatement = databaseRef.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String status = resultSet.getBoolean("isStudent")? "student": "staff";
                    System.out.printf("ID:%d. Name:%s Status:%s \n", id, name, status);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void GetUserBorrowedBooks(int id)
    {

        String sql = "SELECT bs.* FROM borrowed_books bb JOIN books_storage bs ON bb.book_isbn = bs.isbn WHERE bb.user_id = ?";

        try  {
            PreparedStatement preparedStatement = databaseRef.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    do {
                        int isbn = resultSet.getInt("isbn");
                        String title = resultSet.getString("title");
                        String author = resultSet.getString("author");
                        String genre = resultSet.getString("genre");
                        int year = resultSet.getInt("year");

                        System.out.printf("ISBN:%d. Title:%s Author:%s Genre:%s Year:%d \n", isbn, title, author, genre, year);
                    } while (resultSet.next());
                } else {
                    System.out.println("No books found for user ID: "+ id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void ReturnBookToLib(int isbn, int id, int quantity)
    {
        String deleteSql = "DELETE FROM borrowed_books WHERE user_id = ? AND book_isbn = ? AND quantity = ?";
        String updateSql = "UPDATE borrowed_books SET quantity = quantity - ? WHERE user_id = ? AND book_isbn = ? AND quantity > ?";
        try {
            PreparedStatement updateStatement = databaseRef.prepareStatement(updateSql);
            PreparedStatement deleteStatement = databaseRef.prepareStatement(deleteSql);

            deleteStatement.setInt(1, id);
            deleteStatement.setInt(2, isbn);
            deleteStatement.setInt(3, quantity);

            updateStatement.setInt(1, quantity);
            updateStatement.setInt(2, id);
            updateStatement.setInt(3, isbn);
            updateStatement.setInt(4, quantity);

            int rowsDeleted = deleteStatement.executeUpdate();

            if (rowsDeleted <= 0)
            {
                int rowsUpdated = updateStatement.executeUpdate();
                if (rowsUpdated <= 0)
                {
                    System.out.println("Something went wrong");
                } else{
                    System.out.println("Book was returned");
                }
            }
            else
            {
                System.out.println("Book was returned");
            }

        } catch (SQLException e) {
                throw new RuntimeException(e);
            }
    }
}






