package entity;

import java.sql.Date;
import java.util.Objects;

public class Module {
	
    private int id;
    private String name;
    private Date startDate;
    private int days;
    private String faculty;
    private int batchId;

    public Module(int id, String name, Date startDate, int days, String faculty, int batchId) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.days = days;
        this.faculty = faculty;
        this.batchId = batchId;
    }

	public Module(String name, Date startDate, int days, String faculty, int batchId) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.days = days;
		this.faculty = faculty;
		this.batchId = batchId;
	}

	public Module(){
		
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public String getFaculty() {
		return faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	@Override
    public String toString() {
        return "Module [id=" + id + ", name=" + name + ", startDate=" + startDate + ", days=" + days + ", faculty="
                + faculty + ", batchId=" + batchId + "]";
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
		Module other = (Module) obj;
		return id == other.id;
	}
	
	

    
}