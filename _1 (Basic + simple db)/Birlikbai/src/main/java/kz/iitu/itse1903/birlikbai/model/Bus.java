package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "bus")
public class Bus {

    private int id;
    private String number;
    private String driverId;
    private String driverName;

    public Bus(int id, String number, String driverId, String driverName) {
        this.id = id;
        this.number = number;
        this.driverId = driverId;
        this.driverName = driverName;
    }

    public Bus(String number, String driverId, String driverName) {
        this.number = number;
        this.driverId = driverId;
        this.driverName = driverName;
    }

    public Bus() {
    }


    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Column(name = "NUMBER")
    public String getNumber() {
        return number;
    }

    @Column(name = "DRIVER_ID")
    public String getDriverId() {
        return driverId;
    }

    @Column(name = "DRIVER_NAME")
    public String getDriverName() {
        return driverName;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "id=" + id +
                ", number=" + number +
                ", driverId=" + driverId +
                ", driverName=" + driverName +
                '}';
    }
}


//package kz.iitu.itse1903.birlikbai.birlikbai.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "bus")
//public class Bus {
//
//    private int id;
//    private int number;
//    private Driver driverId;          //bus---driver (OneToOne)
//    private Driver driverName;        //bus---driver (OneToOne)
//
//    @OneToOne(mappedBy = "bus")
//    private Driver driver;
//    @OneToOne(mappedBy = "bus")
//    private Schedule schedule;
//
//    public Bus(int id, int number, Driver driverId, Driver driverName) {
//        this.id = id;
//        this.number = number;
//        this.driverId = driverId;
//        this.driverName = driverName;
//    }
//
//    public Bus(int number, Driver driverId, Driver driverName) {
//        this.number = number;
//        this.driverId = driverId;
//        this.driverName = driverName;
//    }
//
//    public Bus() {
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
//    @Column(name = "NUMBER")
//    public int getNumber() {
//        return number;
//    }
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "DRIVER_ID")
//    public Driver getDriverId() {
//        return driverId;
//    }
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "DRIVER_NAME", referencedColumnName = "NAME")
//    public Driver getDriverName() {
//        return driverName;
//    }
//
//
//    //Setters
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }
//
//    public void setDriverId(Driver driverId) {
//        this.driverId = driverId;
//    }
//
//    public void setDriverName(Driver driverName) {
//        this.driverName = driverName;
//    }
//
//    @Override
//    public String toString() {
//        return "Bus{" +
//                "id=" + id +
//                ", number=" + number +
//                ", driverId=" + driverId +
//                ", driverName=" + driverName +
//                '}';
//    }
//}
