package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "booking")
public class Booking {

    private int id;
    private String bookingName;
    private String cities;
    private String seats;
    private int price;

    public Booking(int id, String bookingName, String cities, String seats, int price) {
        this.id = id;
        this.bookingName = bookingName;
        this.cities = cities;
        this.seats = seats;
        this.price = price;
    }

    public Booking(String bookingName, String cities, String seats, int price) {
        this.bookingName = bookingName;
        this.cities = cities;
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

    @Column(name = "BOOKING_NAME")
    public String getBookingName() {
        return bookingName;
    }

    @Column(name = "CITIES")
    public String getCities() {
        return cities;
    }

    @Column(name = "SEATS")
    public String getSeats() {
        return seats;
    }

    @Column(name = "PRICE")
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

    public void setCities(String cities) {
        this.cities = cities;
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
                ", cities='" + cities + '\'' +
                ", seats='" + seats + '\'' +
                ", price=" + price +
                '}';
    }
}
