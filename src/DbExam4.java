import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbExam4 {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement stmt = null;

        try {
            // load JDBC Driver
            Class.forName("org.postgresql.Driver");

            // database connect
            con = DriverManager.getConnection("jdbc:postgresql:axizdb", "axizuser", "axiz");


            // SQL query string
            String sql = "SELECT * FROM products WHERE product_id=101 or product_name='地球儀'";

            // create statement
            stmt = con.prepareStatement(sql);

            // execute
            ResultSet rs = stmt.executeQuery();

            // output
            while (rs.next()) {
                int product_id = rs.getInt("product_id");
                String product_name = rs.getString("product_name");
                String price = rs.getString("price");

                System.out.println("product_id:"+product_id+",product_name:"+product_name+",price:"+price);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // close
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
