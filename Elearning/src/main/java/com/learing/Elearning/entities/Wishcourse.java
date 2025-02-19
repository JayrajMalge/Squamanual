
package com.learing.Elearning.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jayraj Malge
 */
@Entity
@Table(name = "wishcourse")
@NamedQueries({
    @NamedQuery(name = "Wishcourse.findAll", query = "SELECT w FROM Wishcourse w"),
    @NamedQuery(name = "Wishcourse.findByWishcourseid", query = "SELECT w FROM Wishcourse w WHERE w.wishcourseid = :wishcourseid"),
    
    @NamedQuery(name = "Wishcourse.findByName", query = "SELECT w FROM Wishcourse w WHERE w.name = :name"),
    @NamedQuery(name = "Wishcourse.findByIsfree", query = "SELECT w FROM Wishcourse w WHERE w.isfree = :isfree"),
    @NamedQuery(name = "Wishcourse.findByPoints", query = "SELECT w FROM Wishcourse w WHERE w.points = :points"),
    @NamedQuery(name = "Wishcourse.findByCourseAndUser", query = "SELECT w FROM Wishcourse w WHERE w.course.courseid = :courseid AND w.user.userid = :userid"),
    @NamedQuery(name = "Wishcourse.findByDifficulty", query = "SELECT w FROM Wishcourse w WHERE w.difficulty = :difficulty"),
    @NamedQuery(name = "Wishcourse.deleteByUserid", query = "DELETE  FROM Wishcourse w WHERE w.user.userid = :userid"),
    @NamedQuery(name = "Wishcourse.deleteByWishcourseid", query = "DELETE  FROM Wishcourse w WHERE w.wishcourseid = :wishcourseid"),
    @NamedQuery(name = "Wishcourse.findByActive", query = "SELECT w FROM Wishcourse w WHERE w.active = :active"),
    @NamedQuery(name = "Wishcourse.findByUser", query="SELECT w FROM Wishcourse w WHERE w.user = :user"),
    @NamedQuery(name = "Wishcourse.findByCreateat", query = "SELECT w FROM Wishcourse w WHERE w.createat = :createat"),
    @NamedQuery(name = "Wishcourse.findByUpdatedat", query = "SELECT w FROM Wishcourse w WHERE w.updatedat = :updatedat")})
public class Wishcourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "wishcourseid")
    private Integer wishcourseid;
    @Column(name = "name")
    private String name;
    @Lob
    @Column(name = "descriptionmarkup")
    private String descriptionmarkup;
    @Column(name = "isfree")
    private Integer isfree;
    @Column(name = "points")
    private Integer points;
    @Column(name = "difficulty")
    private String difficulty;
    @Column(name = "active")
    private Integer active;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @JoinColumn(name = "course", referencedColumnName = "courseid")
    @ManyToOne
    private Course course;
    @JoinColumn(name = "user", referencedColumnName = "userid")
    @ManyToOne
    private User user;

    public Wishcourse() {
    }

    public Wishcourse(Integer wishcourseid) {
        this.wishcourseid = wishcourseid;
    }

    public Integer getWishcourseid() {
        return wishcourseid;
    }

    public void setWishcourseid(Integer wishcourseid) {
        this.wishcourseid = wishcourseid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionmarkup() {
        return descriptionmarkup;
    }

    public void setDescriptionmarkup(String descriptionmarkup) {
        this.descriptionmarkup = descriptionmarkup;
    }

    public Integer getIsfree() {
        return isfree;
    }

    public void setIsfree(Integer isfree) {
        this.isfree = isfree;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Date getCreateat() {
        return createat;
    }

    public void setCreateat(Date createat) {
        this.createat = createat;
    }

    public Date getUpdatedat() {
        return updatedat;
    }

    public void setUpdatedat(Date updatedat) {
        this.updatedat = updatedat;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (wishcourseid != null ? wishcourseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishcourse)) {
            return false;
        }
        Wishcourse other = (Wishcourse) object;
        if ((this.wishcourseid == null && other.wishcourseid != null) || (this.wishcourseid != null && !this.wishcourseid.equals(other.wishcourseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName()+"\n"+this.getCreateat()+"\n"+this.getUser()+"\n"+this.getCourse();
    }
    
}
