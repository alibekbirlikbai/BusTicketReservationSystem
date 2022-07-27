package kz.iitu.itse1903.birlikbai.model;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
@NamedQuery(name = "Schedule.findByCapitalCities",
        query = "select s from Schedule s where s.cities = 'Almaty,Astana'")
public class Schedule {

    private int id;
    private String cities;
    private int busNumber;
    private String date;        //01/09/2022
    private String timeStart;
    private String timeEnd;


    public Schedule(int id, String cities, int busNumber, String date, String timeStart, String timeEnd) {
        this.id = id;
        this.cities = cities;
        this.busNumber = busNumber;
        this.date = date;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
    }

    public Schedule(String cities, int busNumber, String date, String timeStart, String timeEnd) {
        this.cities = cities;
        this.busNumber = busNumber;
        this.date = date;
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

    @Column(name = "cities")
    public String getCities() {
        return cities;
    }

    @Column(name = "busNumber")
    public int getBusNumber() {
        return busNumber;
    }

    @Column(name = "date")
    public String getDate() {
        return date;
    }

    @Column(name = "timeStart")
    public String getTimeStart() {
        return timeStart;
    }

    @Column(name = "timeEnd")
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

    public void setBusNumber(int busNumber) {
        this.busNumber = busNumber;
    }

    public void setDate(String date) {
        this.date = date;
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
                ", busNumber='" + busNumber + '\'' +
                ", date='" + date + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", timeEnd='" + timeEnd + '\'' +
                '}';
    }
}

