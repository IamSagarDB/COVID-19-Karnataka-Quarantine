package in.dropcodes.covid19kar.Model;

public class QuarantineModel {
    private String slno, arrival_date, quarantine_date, from, to, house, street, thesil, city, state, pincode, destination, status;

    public QuarantineModel(String slno, String arrival_date, String quarantine_date, String from, String to, String house, String street, String thesil, String city, String state, String pincode, String destination, String status) {
        this.slno = slno;
        this.arrival_date = arrival_date;
        this.quarantine_date = quarantine_date;
        this.from = from;
        this.to = to;
        this.house = house;
        this.street = street;
        this.thesil = thesil;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
        this.destination = destination;
        this.status = status;
    }

    public String getSlno() {
        return slno;
    }

    public void setSlno(String slno) {
        this.slno = slno;
    }

    public String getArrival_date() {
        return arrival_date;
    }

    public void setArrival_date(String arrival_date) {
        this.arrival_date = arrival_date;
    }

    public String getQuarantine_date() {
        return quarantine_date;
    }

    public void setQuarantine_date(String quarantine_date) {
        this.quarantine_date = quarantine_date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getThesil() {
        return thesil;
    }

    public void setThesil(String thesil) {
        this.thesil = thesil;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}