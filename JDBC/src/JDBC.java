import java.sql.*;

public class JDBC {
    public static void main(String[] args) {


        class MySQLConnectionExample {
            public static void main(String[] args) {
                // MySQL資料庫連線資訊
                String url = "jdbc:mysql://localhost:3306/college";
                String username = "root";
                String password = "123456";

                Connection connection = null;

                try {
                    // 載入MySQL JDBC驅動程式
//                    Class.forName("com.mysql.cj.jdbc.Driver");

                    // 建立資料庫連線
                    connection = DriverManager.getConnection(url, username, password);

                    // 執行資料庫操作
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM students");
                    while (resultSet.next()) {
                        System.out.println(resultSet.getString("first_name"));
                    };

                    // 關閉資料庫連線
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
