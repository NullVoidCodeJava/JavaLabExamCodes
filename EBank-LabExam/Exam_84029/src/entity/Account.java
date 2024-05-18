package entity;

public class Account {
		
	    private int accNumber;
	    private String name;
	    private String email;
	    private String phone;
	    private double balance;
	    private int userid;
	    
		public Account(int accNumber, String name, String email, String phone, double balance, int userid) {
			super();
			this.accNumber = accNumber;
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.balance = balance;
			this.userid = userid;
		}

		public Account(String name, String email, String phone, double balance, int userid) {
			super();
			this.name = name;
			this.email = email;
			this.phone = phone;
			this.balance = balance;
			this.userid = userid;
		}

		public Account() {
			
		}

		public int getAccNumber() {
			return accNumber;
		}

		public void setAccNumber(int accNumber) {
			this.accNumber = accNumber;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public double getBalance() {
			return balance;
		}

		public void setBalance(double balance) {
			this.balance = balance;
		}
		

		public int getUserid() {
			return userid;
		}

		public void setUserid(int userid) {
			this.userid = userid;
		}

		@Override
		public String toString() {
			return "Account [accNumber=" + accNumber + ", name=" + name + ", email=" + email + ", phone=" + phone
					+ ", balance=" + balance + ", userid=" + userid + "]";
		}

		
	}

