/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jayraj Malge
 */
@Entity
@Table(name = "test")
@NamedQueries({
    @NamedQuery(name = "Test.findAll", query = "SELECT t FROM Test t"),
    @NamedQuery(name = "Test.findByTestid", query = "SELECT t FROM Test t WHERE t.testid = :testid"),
    @NamedQuery(name = "Test.findByDatetime", query = "SELECT t FROM Test t WHERE t.datetime = :datetime"),
    @NamedQuery(name = "Test.findByNoofquestions", query = "SELECT t FROM Test t WHERE t.noofquestions = :noofquestions"),
    @NamedQuery(name = "Test.findByCreateat", query = "SELECT t FROM Test t WHERE t.createat = :createat"),
    @NamedQuery(name = "Test.findByUpdatedat", query = "SELECT t FROM Test t WHERE t.updatedat = :updatedat")})
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "testid")
    private Integer testid;
    @Column(name = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datetime;
    @Column(name = "noofquestions")
    private Integer noofquestions;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
     @OneToMany(mappedBy = "test")
    private List<Testquestion> testquestionList;
    @JoinColumn(name = "course", referencedColumnName = "courseid")
    @ManyToOne
    private Course course;
    @JoinColumn(name = "topic", referencedColumnName = "topicid")
    @ManyToOne
    private Topic topic;
    @JoinColumn(name = "user", referencedColumnName = "userid")
    @ManyToOne
    private User user;

    public Test() {
    }

    public Test(Integer testid) {
        this.testid = testid;
    }

    public Integer getTestid() {
        return testid;
    }

    public void setTestid(Integer testid) {
        this.testid = testid;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Integer getNoofquestions() {
        return noofquestions;
    }

    public void setNoofquestions(Integer noofquestions) {
        this.noofquestions = noofquestions;
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

    public List<Testquestion> getTestquestionList() {
        return testquestionList;
    }

    public void setTestquestionList(List<Testquestion> testquestionList) {
        this.testquestionList = testquestionList;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
        hash += (testid != null ? testid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Test)) {
            return false;
        }
        Test other = (Test) object;
        if ((this.testid == null && other.testid != null) || (this.testid != null && !this.testid.equals(other.testid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Test[ testid=" + testid + " ]";
    }
    
}
