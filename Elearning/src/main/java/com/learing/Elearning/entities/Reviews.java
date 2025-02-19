
package com.learing.Elearning.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "reviews")
@NamedQueries({
    @NamedQuery(name = "Reviews.findAll", query = "SELECT r FROM Reviews r"),
    @NamedQuery(name = "Reviews.findByReviewid", query = "SELECT r FROM Reviews r WHERE r.reviewid = :reviewid"),
    //@NamedQuery(name = "Reviews.findByUserandCourse", query="SELECT r FROM Reviews r WHERE r.user.userid = :userid AND r.course.courseid = :courseid"),
    @NamedQuery(name = "Reviews.findByDescriptionmarkup", query = "SELECT r FROM Reviews r WHERE r.descriptionmarkup = :descriptionmarkup"),
    @NamedQuery(name = "Reviews.findByCreateat", query = "SELECT r FROM Reviews r WHERE r.createat = :createat")})
public class Reviews implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "reviewid")
    private Integer reviewid;
    @Column(name = "descriptionmarkup")
    private String descriptionmarkup;
    @Column(name = "createat")
    @Temporal(TemporalType.DATE)
    private Date createat;
    @JoinColumn(name = "course", referencedColumnName = "courseid")
    @ManyToOne
    private Course course;
    @JoinColumn(name = "user", referencedColumnName = "userid")
    @ManyToOne
    private User user;
    

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public Reviews() {
    }

    public Reviews(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public Integer getReviewid() {
        return reviewid;
    }

    public void setReviewid(Integer reviewid) {
        this.reviewid = reviewid;
    }

    public String getDescriptionmarkup() {
        return descriptionmarkup;
    }

    public void setDescriptionmarkup(String descriptionmarkup) {
        this.descriptionmarkup = descriptionmarkup;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewid != null ? reviewid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reviews)) {
            return false;
        }
        Reviews other = (Reviews) object;
        if ((this.reviewid == null && other.reviewid != null) || (this.reviewid != null && !this.reviewid.equals(other.reviewid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Reviews[ reviewid=" + reviewid + " ]";
    }
    
}
