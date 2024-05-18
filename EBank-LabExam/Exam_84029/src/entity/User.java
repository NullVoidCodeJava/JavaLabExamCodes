package entity;

import java.util.Objects;

public class User {

	private int userid;
	private String email;
	private String password;

	public User(int userid, String email, String password) {
		this.userid = userid;
		this.email = email;
		this.password = password;
	}

	public User(String email, String password) {

		this.email = email;
		this.password = password;
	}

	public User() {
		super();
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
    public String toString() {
        return "User [userid=" + userid + ", email=" + email + ", password=" + password + "]";
    }

	@Override
	public int hashCode() {
		return Objects.hash(userid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return userid == other.userid;
	}

}

