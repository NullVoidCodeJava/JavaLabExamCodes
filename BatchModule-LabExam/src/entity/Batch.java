package entity;

import java.util.Objects;

public class Batch {
	
    private int id;
    private String name;
    private String course;

    public Batch(String name, String course) {
        this.name = name;
        this.course = course;
    }


    public Batch()
    {
    	
    }


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCourse() {
		return course;
	}


	public void setCourse(String course) {
		this.course = course;
	}


	@Override
	public String toString() {
		return "Batch [id=" + id + ", name=" + name + ", course=" + course + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Batch other = (Batch) obj;
		return id == other.id;
	}
    
    
}