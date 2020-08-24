package project_library.dto;

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
	private String rentDate;
	private String returnDate;
	private int isRent;
	private int idx;
	private int totalCount;
	private String memberCode2;
	private String bookCode2;
	
	public Rent() {
		
	}


	public Rent(
				String memberCode, 
				String memberName, 
				String phone, 
				int totalRental,
				String bookCode,
				String bookName,
				String author,
				String publisher,
				int price,
				int isRent,
				int totalCount,
				int idx,
				String memberCode2,
				String bookCode2,
				String returnDate,
				String rentDate
			) {
		this.memberCode = memberCode2;
		this.memberName = memberName;
		this.phone = phone;
		this.totalRental = totalCount;
		this.bookCode = bookCode;
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.isRent = isRent;
		this.totalRental = totalCount;
		this.idx = idx;
		this.memberCode = memberCode2;
		this.bookCode = bookCode;
		this.returnDate = returnDate;
		this.rentDate = rentDate;
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

	
	
	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
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


	public String getRentDate() {
		return rentDate;
	}


	public void setRentDate(String rentDate) {
		this.rentDate = rentDate;
	}


	public String getReturnDate() {
		return returnDate;
	}


	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}


	public int getIsRent() {
		return isRent;
	}


	public void setIsRent(int isRent) {
		this.isRent = isRent;
	}

	public int getIdx() {
		return idx;
	}


	public void setIdx(int idx) {
		this.idx = idx;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bookCode == null) ? 0 : bookCode.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + isRent;
		result = prime * result + ((memberCode == null) ? 0 : memberCode.hashCode());
		result = prime * result + ((memberName == null) ? 0 : memberName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + price;
		result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
		result = prime * result + ((rentDate == null) ? 0 : rentDate.hashCode());
		result = prime * result + ((returnDate == null) ? 0 : returnDate.hashCode());
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
				"Rent [bookCode=%s, bookName=%s, author=%s, publisher=%s, price=%s, totalRental=%s, memberCode=%s, memberName=%s, phone=%s, rentDate=%s, returnDate=%s, isRent=%s]",
				bookCode, bookName, author, publisher, price, totalRental, memberCode, memberName, phone, rentDate, returnDate, isRent);
	}
	
}
