package movieticket;

/**
 *
 * @author Sumanth
 */
public class Mov {
    int s_no,hall_no;
    String movie_name,genre,date,time;
    byte[] poster;

    public int getS_no() {
        return s_no;
    }

    public void setS_no(int s_no) {
        this.s_no = s_no;
    }

    public int getHall_no() {
        return hall_no;
    }

    public void setHall_no(int hall_no) {
        this.hall_no = hall_no;
    }

    public String getMovie_name() {
        return movie_name;
    }

    public void setMovie_name(String movie_name) {
        this.movie_name = movie_name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public Mov(int s_no,  String movie_name, String genre,int hall_no, String date, String time, byte[] poster) {
        this.s_no = s_no;
        this.hall_no = hall_no;
        this.movie_name = movie_name;
        this.genre = genre;
        this.date = date;
        this.time = time;
        this.poster = poster;
    }
    

}
