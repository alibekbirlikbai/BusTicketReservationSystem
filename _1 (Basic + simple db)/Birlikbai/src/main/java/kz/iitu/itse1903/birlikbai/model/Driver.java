package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "driver")
public class Driver {

    private int id;
    private String driverId;
    private String password;
    private String driverName;
    private String busNumber;

    public Driver(int id, String driverId, String password, String driverName, String busNumber) {
        this.id = id;
        this.driverId = driverId;
        this.password = password;
        this.driverName = driverName;
        this.busNumber = busNumber;
    }

    public Driver(String driverId, String password, String driverName, String busNumber) {
        this.driverId = driverId;
        this.password = password;
        this.driverName = driverName;
        this.busNumber = busNumber;
    }

    public Driver() {
    }


    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Column(name = "DRIVER_ID")
    public String getDriverId() {
        return driverId;
    }

    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    @Column(name = "NAME")
    public String getDriverName() {
        return driverName;
    }

    @Column(name = "BUS_NUMBER")
    public String getBusNumber() {
        return busNumber;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", driverId=" + driverId +
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
