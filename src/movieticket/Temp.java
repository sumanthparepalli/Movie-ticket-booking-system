package movieticket;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Sumanth
 */
@Entity
@Table(name = "temp", catalog = "movie", schema = "")
@NamedQueries({
    @NamedQuery(name = "Temp.findAll", query = "SELECT t FROM Temp t")
    , @NamedQuery(name = "Temp.findBySNo", query = "SELECT t FROM Temp t WHERE t.sNo = :sNo")
    , @NamedQuery(name = "Temp.findByMovieName", query = "SELECT t FROM Temp t WHERE t.movieName = :movieName")
    , @NamedQuery(name = "Temp.findByGenre", query = "SELECT t FROM Temp t WHERE t.genre = :genre")
    , @NamedQuery(name = "Temp.findByHallNo", query = "SELECT t FROM Temp t WHERE t.hallNo = :hallNo")
    , @NamedQuery(name = "Temp.findByDate", query = "SELECT t FROM Temp t WHERE t.date = :date")
    , @NamedQuery(name = "Temp.findByTime", query = "SELECT t FROM Temp t WHERE t.time = :time")})
public class Temp implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
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
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "time")
    private String time;

    public Temp() {
    }

    public Temp(Integer sNo) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sNo != null ? sNo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Temp)) {
            return false;
        }
        Temp other = (Temp) object;
        if ((this.sNo == null && other.sNo != null) || (this.sNo != null && !this.sNo.equals(other.sNo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "movieticket.Temp[ sNo=" + sNo + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }

}
