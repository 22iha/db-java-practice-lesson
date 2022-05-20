
import java.util.List;

import dao.ProductDao;
import entity.Product;
import util.DbUtil;

public class DbExam5 {

    public static void main(String[] args) {
        // Daoインスタンス化
        ProductDao dao = new ProductDao(DbUtil.getConnection());

        // 登録に使用するデータを用意
        Product newProduct = new Product(null, "ボールペン", 200);

        // 登録処理
        dao.register(newProduct);

        // データ取得
        List<Product> productList = dao.findAll();

        // 取得したデータを表示
        for (Product product : productList) {
            System.out.println("product_id:" + product.getProductId()
                    + ", product_name:" + product.getProductName()
                    + ", price:" + product.getPrice());
        }
    }
}
