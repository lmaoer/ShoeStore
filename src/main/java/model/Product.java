package model;

public class Product {
	private String id, name; 
	private int cost;
	private int discount;
	private String image, imageDetail;
	private Brand brand;
	
	public Product() {
		
	}

	public Product(String id, String name, int cost, int discount, String image,
			String imageDetail, Brand brand) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
		this.discount = discount;
		this.image = image;
		this.imageDetail = imageDetail;
		this.brand = brand;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageDetail() {
		return imageDetail;
	}

	public void setImageDetail(String imageDetail) {
		this.imageDetail = imageDetail;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
