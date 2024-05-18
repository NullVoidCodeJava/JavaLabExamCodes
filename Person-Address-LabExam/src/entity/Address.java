package entity;

import java.io.Serializable;

public class Address implements Serializable {
 
	private static final long serialVersionUID = 1L;
	private String area;
    private String dist;
    private int pin;

    public Address(String area, String dist, int pin) {
        this.area = area;
        this.dist = dist;
        this.pin = pin;
    }

    // Getters and setters
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }
}
