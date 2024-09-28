package Collection.model.vo;

public class Book implements java.io.Serializable{
	private static final long serialVersionUID = 3215122098120049021L;
	
	private String title; //도서제목
	private int price; //도서가격
	
	public Book() {}

	public Book(String title, int price) {
		this.title = title;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + "]";
	}
	
}
