package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    private int id;
    private String cities;
    private String busNumber;
    private String timeStart;
    private String timeEnd;

    public Schedule(int id, String cities, String busNumber, String timeStart, String timeEnd) {
        this.id = id;
        this.cities = cities;
        this.busNumber = busNumber;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Schedule(String cities, String busNumber, String timeStart, String timeEnd) {
        this.cities = cities;
        this.busNumber = busNumber;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Schedule() {
    }


    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Column(name = "CITIES")
    public String getCities() {
        return cities;
    }

    @Column(name = "BUS_NUMBER")
    public String getBusNumber() {
        return busNumber;
    }

    @Column(name = "TIME_START")
    public String getTimeStart() {
        return timeStart;
    }

    @Column(name = "TIME_END")
    public String getTimeEnd() {
        return timeEnd;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "id=" + id +
                ", cities='" + cities + '\'' +
                ", busNumber=" + busNumber +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd +
                '}';
    }
}


//package kz.iitu.itse1903.birlikbai.birlikbai.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "schedule")
//public class Schedule {
//
//    private int id;
//    private String cities;            //schedule---booking (OneToMany)
//    private Bus busNumber;            //schedule---bus (OneToOne)
//    private String timeStart;
//    private String timeEnd;
//    private int busySeats;
//    private int availableSeats;
//
//    public Schedule(int id, String cities, Bus busNumber, String timeStart, String timeEnd, int busySeats, int availableSeats) {
//        this.id = id;
//        this.cities = cities;
//        this.busNumber = busNumber;
//        this.timeStart = timeStart;
//        this.timeEnd = timeEnd;
//        this.busySeats = busySeats;
//        this.availableSeats = availableSeats;
//    }
//
//    public Schedule(String cities, Bus busNumber, String timeStart, String timeEnd, int busySeats, int availableSeats) {
//        this.cities = cities;
//        this.busNumber = busNumber;
//        this.timeStart = timeStart;
//        this.timeEnd = timeEnd;
//        this.busySeats = busySeats;
//        this.availableSeats = availableSeats;
//    }
//
//    public Schedule() {
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
//    @Column(name = "CITIES")
//    @OneToMany(mappedBy = "schedule")
//    public String getCities() {
//        return cities;
//    }
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "BUS_NUMBER", referencedColumnName = "NUMBER")
//    public Bus getBusNumber() {
//        return busNumber;
//    }
//
//    @Column(name = "TIME_START")
//    public String getTimeStart() {
//        return timeStart;
//    }
//
//    @Column(name = "TIME_END")
//    public String getTimeEnd() {
//        return timeEnd;
//    }
//
//    @Column(name = "BUSY_SEATS")
//    public int getBusySeats() {
//        return busySeats;
//    }
//
//    @Column(name = "AVAILABLE_SEATS")
//    public int getAvailableSeats() {
//        return availableSeats;
//    }
//
//
//    //Setters
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setCities(String cities) {
//        this.cities = cities;
//    }
//
//    public void setBusNumber(Bus busNumber) {
//        this.busNumber = busNumber;
//    }
//
//    public void setTimeStart(String timeStart) {
//        this.timeStart = timeStart;
//    }
//
//    public void setTimeEnd(String timeEnd) {
//        this.timeEnd = timeEnd;
//    }
//
//    public void setBusySeats(int busySeats) {
//        this.busySeats = busySeats;
//    }
//
//    public void setAvailableSeats(int availableSeats) {
//        this.availableSeats = availableSeats;
//    }
//
//    @Override
//    public String toString() {
//        return "Schedule{" +
//                "id=" + id +
//                ", cities='" + cities + '\'' +
//                ", busNumber=" + busNumber +
//                ", timeStart='" + timeStart + '\'' +
//                ", timeEnd='" + timeEnd + '\'' +
//                ", busySeats=" + busySeats +
//                ", availableSeats=" + availableSeats +
//                '}';
//    }
//}
