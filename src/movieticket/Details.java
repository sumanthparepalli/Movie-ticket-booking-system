package movieticket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sumanth
 */
@Entity
@Table(name = "details", catalog = "movie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Details.findAll", query = "SELECT d FROM Details d")
    , @NamedQuery(name = "Details.findBySNo", query = "SELECT d FROM Details d WHERE d.sNo = :sNo")
    , @NamedQuery(name = "Details.findByMovieName", query = "SELECT d FROM Details d WHERE d.movieName = :movieName")
    , @NamedQuery(name = "Details.findByGenre", query = "SELECT d FROM Details d WHERE d.genre = :genre")
    , @NamedQuery(name = "Details.findByHallNo", query = "SELECT d FROM Details d WHERE d.hallNo = :hallNo")
    , @NamedQuery(name = "Details.findByDate", query = "SELECT d FROM Details d WHERE d.date = :date")
    , @NamedQuery(name = "Details.findByTime", query = "SELECT d FROM Details d WHERE d.time = :time")})
public class Details implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "s_no")
    private Integer sNo;
    @Column(name = "movie_name")
    private String movieName;
    @Column(name = "genre")
    private String genre;
    @Column(name = "hall_no")
    private Integer hallNo;
    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;
    @Lob
    @Column(name = "poster")
    private byte[] poster;

    public Details() {
    }

    public Details(Integer sNo) {
        this.sNo = sNo;
    }

    public Integer getSNo() {
        return sNo;
    }

    public void setSNo(Integer sNo) {
        Integer oldSNo = this.sNo;
        this.sNo = sNo;
        changeSupport.firePropertyChange("SNo", oldSNo, sNo);
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        String oldMovieName = this.movieName;
        this.movieName = movieName;
        changeSupport.firePropertyChange("movieName", oldMovieName, movieName);
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        String oldGenre = this.genre;
        this.genre = genre;
        changeSupport.firePropertyChange("genre", oldGenre, genre);
    }

    public Integer getHallNo() {
        return hallNo;
    }

    public void setHallNo(Integer hallNo) {
        Integer oldHallNo = this.hallNo;
        this.hallNo = hallNo;
        changeSupport.firePropertyChange("hallNo", oldHallNo, hallNo);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        String oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        String oldTime = this.time;
        this.time = time;
        changeSupport.firePropertyChange("time", oldTime, time);
    }

    public byte[] getPoster() {
        return poster;
    }

    public void setPoster(byte[] poster) {
        byte[] oldPoster = this.poster;
        this.poster = poster;
        changeSupport.firePropertyChange("poster", oldPoster, poster);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sNo != null ? sNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Details)) {
            return false;
        }
        Details other = (Details) object;
        if ((this.sNo == null && other.sNo != null) || (this.sNo != null && !this.sNo.equals(other.sNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "movieticket.Details[ sNo=" + sNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
