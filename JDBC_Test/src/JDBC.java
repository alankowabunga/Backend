import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class JDBC {
    public static void main(String[] args) {

        // MySQL資料庫連線資訊
        String url = "jdbc:mysql://localhost:3306/mydb";
        String username = "root";
        String password = "123456";

        Connection connection = null;

        try {

            // 建立資料庫連線
            connection = DriverManager.getConnection(url, username, password);

            // 執行資料庫操作
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("first_name"));
            }
            ;

            // 關閉資料庫連線
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}