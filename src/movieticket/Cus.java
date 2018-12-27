package movieticket;

/**
 *
 * @author Sumanth
 */
public class Cus {
    int s_no,noofseats,price,hallno;
    String movName,seats,date,time;
    byte[] poster;

    public Cus(int s_no, int noofseats, int price, int hallno, String movName, String seats, String date, String time, byte[] poster) {
        this.s_no = s_no;
        this.noofseats = noofseats;
        this.price = price;
        this.hallno = hallno;
        this.movName = movName;
        this.seats = seats;
        this.date = date;
        this.time = time;
        this.poster = poster;
    }

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public int getNoofseats() {
        return noofseats;
    }

    public void setNoofseats(int noofseats) {
        this.noofseats = noofseats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getHallno() {
        return hallno;
    }

    public void setHallno(int hallno) {
        this.hallno = hallno;
    }

    public String getMovName() {
        return movName;
    }

    public void setMovName(String movName) {
        this.movName = movName;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        this.poster = poster;
    }
    
    

}
