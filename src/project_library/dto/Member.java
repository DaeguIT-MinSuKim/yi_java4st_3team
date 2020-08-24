package project_library.dto;

public class Member {
	private String no;
	private String name;
	private String tel;
	private int rent;

	public Member() {

	}

	public Member(String no) {
		this.no = no;
	}

	public Member(String no, String name, String tel, int rent) {
		this.no = no;
		this.name = name;
		this.tel = tel;
		this.rent = rent;
	}

	public Member(String no, String name, String tel) {
		this.no = no;
		this.name = name;
		this.tel = tel;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getRent() {
		return rent;
	}

	public void setRent(int rent) {
		this.rent = rent;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no == null) ? 0 : no.hashCode());
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
		Member other = (Member) obj;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("MemberDto [no=%s, name=%s, tel=%s, rent=%s]", no, name, tel, rent);
	}

}
