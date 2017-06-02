package entity;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.UUID;

@Entity
@NamedQueries({
                      @NamedQuery(name = "Vehicle.findAll",
                                  query = "SELECT c FROM Car c ORDER BY c.vin ASC"),
                      @NamedQuery(name = "Vehicle.findByModel",
                                  query = "SELECT c FROM Car c WHERE c.model=:model")
              })

public class Car {
	
	 	@Id
	    @Column(columnDefinition = "varchar(36)")
	private String vin;
	private String make;
	private String model;
	private String year;
	private int redlineRpm;
	private int maxFuelVolume;
	private String lastServiceDate;
	public Car() {
        this.vin = UUID.randomUUID()
                      .toString();
    }

	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getRedlineRpm() {
		return redlineRpm;
	}
	public void setRedlineRpm(int redlineRpm) {
		this.redlineRpm = redlineRpm;
	}
	public int getMaxFuelVolume() {
		return maxFuelVolume;
	}
	public void setMaxFuelVolume(int maxFuelVolume) {
		this.maxFuelVolume = maxFuelVolume;
	}
	public String getLastServiceDate() {
		return lastServiceDate;
	}
	public void setLastServiceDate(String lastServiceDate) {
		this.lastServiceDate = lastServiceDate;
	}

	@Override
	public String toString() {
		System.out.println("Car [vin=" + vin + ", make=" + make + ", model=" 
	+ model + ", year=" + year + ", redlineRpm="
				+ redlineRpm + ", maxFuelVolume=" + 
	maxFuelVolume + ", lastServiceDate=" + lastServiceDate + "]");
		return ("Car [vin=" + vin + ", make=" + make + ", model=" 
				+ model + ", year=" + year + ", redlineRpm="
							+ redlineRpm + ", maxFuelVolume=" + 
				maxFuelVolume + ", lastServiceDate=" + lastServiceDate + "]");
	}
	
	
}
