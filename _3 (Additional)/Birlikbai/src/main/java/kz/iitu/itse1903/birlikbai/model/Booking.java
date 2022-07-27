package kz.iitu.itse1903.birlikbai.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Component
@Entity
@Table(name = "booking")
public class Booking {

    private int id;
    private String bookingName;
    private int scheduleId;
    private String seats;
    private int price;


    public Booking(int id, String bookingName, int scheduleId, String seats, int price) {
        this.id = id;
        this.bookingName = bookingName;
        this.scheduleId = scheduleId;
        this.seats = seats;
        this.price = price;
    }

    public Booking(String bookingName, int scheduleId, String seats, int price) {
        this.bookingName = bookingName;
        this.scheduleId = scheduleId;
        this.seats = seats;
        this.price = price;
    }

    public Booking() {
    }


    //Getters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    @Column(name = "bookingName")
    public String getBookingName() {
        return bookingName;
    }

    @Column(name = "scheduleId")
    public int getScheduleId() {
        return scheduleId;
    }

    @Column(name = "seats")
    public String getSeats() {
        return seats;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }


    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setBookingName(String bookingName) {
        this.bookingName = bookingName;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", bookingName='" + bookingName + '\'' +
                ", scheduleId=" + scheduleId +
                ", seats='" + seats + '\'' +
                ", price=" + price +
                '}';
    }
}


//package kz.iitu.itse1903.birlikbai.model;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "booking")
//public class Booking {
//
//    private int id;
//    private String bookingName;
//    private int scheduleId;
//    private String cities;
//    private String date;        //01/09/2022
//    private String timeStart;
//    private String timeEnd;
//    private int busNumber;
//    private String seats;
//    private int price;
//
//
//    public Booking(int id, String bookingName, int scheduleId, String cities, String date, String timeStart, String timeEnd, int busNumber, String seats, int price) {
//        this.id = id;
//        this.bookingName = bookingName;
//        this.scheduleId = scheduleId;
//        this.cities = cities;
//        this.date = date;
//        this.timeStart = timeStart;
//        this.timeEnd = timeEnd;
//        this.busNumber = busNumber;
//        this.seats = seats;
//        this.price = price;
//    }
//
//    public Booking(String bookingName, int scheduleId, String cities, String date, String timeStart, String timeEnd, int busNumber, String seats, int price) {
//        this.bookingName = bookingName;
//        this.scheduleId = scheduleId;
//        this.cities = cities;
//        this.date = date;
//        this.timeStart = timeStart;
//        this.timeEnd = timeEnd;
//        this.busNumber = busNumber;
//        this.seats = seats;
//        this.price = price;
//    }
//
//    public Booking() {
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
//    @Column(name = "bookingName")
//    public String getBookingName() {
//        return bookingName;
//    }
//
//    @Column(name = "scheduleId")
//    public int getScheduleId() {
//        return scheduleId;
//    }
//
//    @Column(name = "cities")
//    public String getCities() {
//        return cities;
//    }
//
//    @Column(name = "date")
//    public String getDate() {
//        return date;
//    }
//
//    @Column(name = "timeStart")
//    public String getTimeStart() {
//        return timeStart;
//    }
//
//    @Column(name = "timeEnd")
//    public String getTimeEnd() {
//        return timeEnd;
//    }
//
//    @Column(name = "busNumber")
//    public int getBusNumber() {
//        return busNumber;
//    }
//
//    @Column(name = "seats")
//    public String getSeats() {
//        return seats;
//    }
//
//    @Column(name = "price")
//    public int getPrice() {
//        return price;
//    }
//
//    //Setters
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setBookingName(String bookingName) {
//        this.bookingName = bookingName;
//    }
//
//    public void setScheduleId(int scheduleId) {
//        this.scheduleId = scheduleId;
//    }
//
//    public void setCities(String cities) {
//        this.cities = cities;
//    }
//
//    public void setDate(String date) {
//        this.date = date;
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
//    public void setBusNumber(int busNumber) {
//        this.busNumber = busNumber;
//    }
//
//    public void setSeats(String seats) {
//        this.seats = seats;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    @Override
//    public String toString() {
//        return "Booking{" +
//                "id=" + id +
//                ", bookingName='" + bookingName + '\'' +
//                ", scheduleId=" + scheduleId +
//                ", cities='" + cities + '\'' +
//                ", date='" + date + '\'' +
//                ", timeStart='" + timeStart + '\'' +
//                ", timeEnd='" + timeEnd + '\'' +
//                ", busNumber=" + busNumber +
//                ", seats='" + seats + '\'' +
//                ", price=" + price +
//                '}';
//    }
//}