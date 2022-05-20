package entity;

//DTO：ゲッターとセッターで構成
public class Product {
	private Integer productId;
	private String productName;
	private Integer price;
	
	public Product(Integer productId,String productName,Integer price) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
	}
	//idのゲッター
	//戻り値有り、引数無し
	public Integer getProductId() {
		return this.productId;
	}
	//idのセッター
	//戻り値なし、引数あり
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	//nameのゲッター
	public String getProductName(){
		return this.productName;
	}
	//nameのセッター
	public void setProductName(String productName) {
		this.productName = productName;
	}
	//priceのゲッター
	public Integer getPrice() {
		return this.price;
	}
	//priceのセッター
	public void setPrice(Integer price) {
		this.price = price;
	}
}