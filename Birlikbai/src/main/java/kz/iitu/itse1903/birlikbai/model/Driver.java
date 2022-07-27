package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    private int driverId;
    private String password;
    private String driverName;
    private int busId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "busId", referencedColumnName = "id")
    private Bus bus;

    public Driver(int driverId, String password, String driverName, int busId) {
        this.driverId = driverId;
        this.password = password;
        this.driverName = driverName;
        this.busId = busId;
    }

    public Driver(String password, String driverName, int busId) {
        this.password = password;
        this.driverName = driverName;
        this.busId = busId;
    }

    public Driver() {
    }


    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driverId")
    public int getDriverId() {
        return driverId;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "driverName")
    public String getDriverName() {
        return driverName;
    }

    @Column(name = "busId")
    public int getBusId() {
        return busId;
    }


    //Setters
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", password='" + password + '\'' +
                ", driverName='" + driverName + '\'' +
                ", busId=" + busId +
                '}';
    }
}




