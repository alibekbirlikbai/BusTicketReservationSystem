package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "driver")
public class Driver {

    private int driverId;
    private String password;
    private String driverName;
    private Integer busNumber;

    public Driver(int driverId, String password, String driverName, Integer busNumber) {
        this.driverId = driverId;
        this.password = password;
        this.driverName = driverName;
        this.busNumber = busNumber;
    }

    public Driver() {
    }


    //Getters
    @Id
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

    @Column(name = "busNumber")
    public Integer getBusNumber() {
        return busNumber;
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

    public void setBusNumber(Integer busNumber) {
        this.busNumber = busNumber;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverId=" + driverId +
                ", password='" + password + '\'' +
                ", driverName='" + driverName + '\'' +
                ", busNumber=" + busNumber +
                '}';
    }
}



//package kz.iitu.itse1903.birlikbai.birlikbai.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "driver")
//public class Driver {
//
//    private int id;
//    private int driverId;
//    private String driverName;
//    private Bus busNumber;          //driver---bus (OneToOne)
//
//    @OneToOne(mappedBy = "driver")
//    private Bus bus;
//
//    public Driver(int id, int driverId, String driverName, Bus busNumber) {
//        this.id = id;
//        this.driverId = driverId;
//        this.driverName = driverName;
//        this.busNumber = busNumber;
//    }
//
//    public Driver(int driverId, String driverName, Bus busNumber) {
//        this.driverId = driverId;
//        this.driverName = driverName;
//        this.busNumber = busNumber;
//    }
//
//    public Driver() {
//    }
//
//
//    //Getters
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "ID")
//    public int getId() {
//        return id;
//    }
//
//    @Column(name = "DRIVER_ID")
//    public int getDriverId() {
//        return driverId;
//    }
//
//    @Column(name = "NAME")
//    public String getDriverName() {
//        return driverName;
//    }
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "BUS_NUMBER", referencedColumnName = "NUMBER")
//    public Bus getBusNumber() {
//        return busNumber;
//    }
//
//
//    //Setters
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setDriverId(int driverId) {
//        this.driverId = driverId;
//    }
//
//    public void setDriverName(String driverName) {
//        this.driverName = driverName;
//    }
//
//    public void setBusNumber(Bus busNumber) {
//        this.busNumber = busNumber;
//    }
//
//    @Override
//    public String toString() {
//        return "Driver{" +
//                "id=" + id +
//                ", driverId=" + driverId +
//                ", driverName='" + driverName + '\'' +
//                ", busNumber=" + busNumber +
//                '}';
//    }
//}
