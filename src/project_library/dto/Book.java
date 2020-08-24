package project_library.dto;

public class Book {
	private String no;
	private String bookName;
	private String author;
	private String publisher;
	private int price;
	private boolean rent;
	private int totalRent;

	public Book(String no) {
		this.no = no;
	}

	public Book(String no, String bookName, String author, String publisher, int price) {
		this.no = no;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
	}

	public Book(String no, String bookName, String author, String publisher, int price, boolean rent, int totalRent) {
		this.no = no;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.rent = rent;
		this.totalRent = totalRent;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isRent() {
		return rent;
	}

	public void setRent(boolean rent) {
		this.rent = rent;
	}

	public int getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(int totalRent) {
		this.totalRent = totalRent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + (rent ? 1231 : 1237);
		result = prime * result + totalRent;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("BookDto [no=%s, bookName=%s, author=%s, publisher=%s, price=%d, rent=%b, totalRent=%d]",
				no, bookName, author, publisher, price, rent, totalRent);
	}

}
