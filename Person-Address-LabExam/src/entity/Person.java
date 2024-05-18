package entity;

import java.io.Serializable;

public class Person implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
    private Date birthDate;
    private Address homeAddr;

    public Person(String name, Date birthDate, Address homeAddr) {
        this.name = name;
        this.birthDate = birthDate;
        this.homeAddr = homeAddr;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Address getHomeAddr() {
        return homeAddr;
    }

    public void setHomeAddr(Address homeAddr) {
        this.homeAddr = homeAddr;
    }
}
