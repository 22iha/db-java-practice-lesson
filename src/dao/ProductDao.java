package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Product;
//import entity.User;

//情報の取得、更新
public class ProductDao{
	
	String SQL_SELECT_ALL = "SELECT * FROM products ORDER BY product_id ASC";
	String SQL_INSERT = "INSERT INTO products (product_name, price) VALUES (?, ?)";
	
	Connection con;

    public ProductDao(Connection con) {
        this.con = con;
    }
    
	public List<Product> findAll(){
		List<Product> list = new ArrayList<Product>();

        try (PreparedStatement stmt = con.prepareStatement(SQL_SELECT_ALL)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
            	Product p = new Product(rs.getInt("product_id"), rs.getString("product_name"), rs.getInt("price"));
                list.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
        return list;
	}
	public void register(Product pd) {
        try (PreparedStatement stmt = con.prepareStatement(SQL_INSERT)) {
            stmt.setString(1, pd.getProductName());
            stmt.setInt(2, pd.getPrice());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
}
