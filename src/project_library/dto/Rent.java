package project_library.dto;

import java.util.Date;

public class Rent {
	private String bookCode;
	private String bookName;
	private String author;
	private String publisher;
	private int price;
	private int totalRental;
	private String memberCode;
	private String memberName;
	private String phone;
	private Date RENT_DATE;
	private Date RETURN_DATE;
	private int isRent;
	
	
	public Rent() {
		
	}
	
	
	public Rent(String bookCode, String bookName, String author, String publisher, int price, int totalRental,
			String memberCode, String memberName, String phone, Date rENT_DATE, Date rETURN_DATE, int isRent) {
		super();
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.totalRental = totalRental;
		this.memberCode = memberCode;
		this.memberName = memberName;
		this.phone = phone;
		RENT_DATE = rENT_DATE;
		RETURN_DATE = rETURN_DATE;
		this.isRent = isRent;
	}


	public Rent(String bookCode, String memberCode) {
		this.bookCode = bookCode;
		this.memberCode = memberCode;
	}
	

	public Rent(String bookCode, String bookName, String author, String publisher, int price, int totalRental) {
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.totalRental = totalRental;
	}
	public String getBookCode() {
		return bookCode;
	}
	public void setBookCode(String bookCode) {
		this.bookCode = bookCode;
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
	public int getTotalRental() {
		return totalRental;
	}
	public void setTotalRental(int totalRental) {
		this.totalRental = totalRental;
	}
	public String getMemberCode() {
		return memberCode;
	}
	public void setMemberCode(String memberCode) {
		this.memberCode = memberCode;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((RENT_DATE == null) ? 0 : RENT_DATE.hashCode());
		result = prime * result + ((RETURN_DATE == null) ? 0 : RETURN_DATE.hashCode());
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookCode == null) ? 0 : bookCode.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + isRent;
		result = prime * result + ((memberCode == null) ? 0 : memberCode.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + totalRental;
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
		Rent other = (Rent) obj;
		return true;
	}


	@Override
	public String toString() {
		return String.format(
				"Rent [bookCode=%s, bookName=%s, author=%s, publisher=%s, price=%s, totalRental=%s, memberCode=%s, memberName=%s, phone=%s, RENT_DATE=%s, RETURN_DATE=%s, isRent=%s]",
				bookCode, bookName, author, publisher, price, totalRental, memberCode, memberName, phone, RENT_DATE,
				RETURN_DATE, isRent);
	}
	
	
}
