
package com.learing.Elearning.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "usercourse")
@NamedQueries({
    @NamedQuery(name = "Usercourse.findAll", query = "SELECT u FROM Usercourse u"),
    @NamedQuery(name = "Usercourse.findByUsercourseid", query = "SELECT u FROM Usercourse u WHERE u.usercourseid = :usercourseid"),
    @NamedQuery(name = "Usercourse.findBySubscriptionstart", query = "SELECT u FROM Usercourse u WHERE u.subscriptionstart = :subscriptionstart"),
    @NamedQuery(name = "Usercourse.findBySubscriptionend", query = "SELECT u FROM Usercourse u WHERE u.subscriptionend = :subscriptionend"),
    @NamedQuery(name = "Usercourse.deleteByUsercourseid", query = "DELETE FROM Usercourse u WHERE u.usercourseid = :usercourseid"),
    @NamedQuery(name = "Usercourse.findByCreateat", query = "SELECT u FROM Usercourse u WHERE u.createat = :createat"),
    @NamedQuery(name = "Usercourse.findByUserid", query = "SELECT u FROM Usercourse u WHERE u.user.userid = :userid"),
    @NamedQuery(name = "Usercourse.findByUpdatedat", query = "SELECT u FROM Usercourse u WHERE u.updatedat = :updatedat")})
public class Usercourse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usercourseid")
    private Integer usercourseid;
    @Column(name = "subscriptionstart")
    @Temporal(TemporalType.DATE)
    private Date subscriptionstart;
    @Column(name = "subscriptionend")
    @Temporal(TemporalType.DATE)
    private Date subscriptionend;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @JoinColumn(name = "course", referencedColumnName = "courseid",nullable = false)
    @ManyToOne
    private Course course;
    @JoinColumn(name = "user", referencedColumnName = "userid" ,nullable = false)
    @ManyToOne
    private User user;

    public Usercourse() {
    }

    public Usercourse(Integer usercourseid) {
        this.usercourseid = usercourseid;
    }

    public Integer getUsercourseid() {
        return usercourseid;
    }

    public void setUsercourseid(Integer usercourseid) {
        this.usercourseid = usercourseid;
    }

    public Date getSubscriptionstart() {
        return subscriptionstart;
    }

    public void setSubscriptionstart(Date subscriptionstart) {
        this.subscriptionstart = subscriptionstart;
    }

    public Date getSubscriptionend() {
        return subscriptionend;
    }

    public void setSubscriptionend(Date subscriptionend) {
        this.subscriptionend = subscriptionend;
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
        hash += (usercourseid != null ? usercourseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usercourse)) {
            return false;
        }
        Usercourse other = (Usercourse) object;
        if ((this.usercourseid == null && other.usercourseid != null) || (this.usercourseid != null && !this.usercourseid.equals(other.usercourseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Usercourse[ usercourseid=" + usercourseid + " ]"+"\n"+this.getCourse().getCourseid()
                +"\n"+this.getUser().getUserid()+"\n"+this.getSubscriptionend()+"\n"+this.getSubscriptionstart();
    }
    
}
