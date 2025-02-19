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
@Table(name = "testquestion")
@NamedQueries({
    @NamedQuery(name = "Testquestion.findAll", query = "SELECT t FROM Testquestion t"),
    @NamedQuery(name = "Testquestion.findByTestquestionid", query = "SELECT t FROM Testquestion t WHERE t.testquestionid = :testquestionid"),
    @NamedQuery(name = "Testquestion.findByGivenanswer", query = "SELECT t FROM Testquestion t WHERE t.givenanswer = :givenanswer"),
    @NamedQuery(name = "Testquestion.findByCreateat", query = "SELECT t FROM Testquestion t WHERE t.createat = :createat"),
    @NamedQuery(name = "Testquestion.findByUpdatedat", query = "SELECT t FROM Testquestion t WHERE t.updatedat = :updatedat")})
public class Testquestion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "testquestionid")
    private Integer testquestionid;
    @Column(name = "givenanswer")
    private Integer givenanswer;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @JoinColumn(name = "question", referencedColumnName = "questionid")
    @ManyToOne
    private Question question;
    @JoinColumn(name = "test", referencedColumnName = "testid")
    @ManyToOne
    private Test test;

    public Testquestion() {
    }

    public Testquestion(Integer testquestionid) {
        this.testquestionid = testquestionid;
    }

    public Integer getTestquestionid() {
        return testquestionid;
    }

    public void setTestquestionid(Integer testquestionid) {
        this.testquestionid = testquestionid;
    }

    public Integer getGivenanswer() {
        return givenanswer;
    }

    public void setGivenanswer(Integer givenanswer) {
        this.givenanswer = givenanswer;
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

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testquestionid != null ? testquestionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Testquestion)) {
            return false;
        }
        Testquestion other = (Testquestion) object;
        if ((this.testquestionid == null && other.testquestionid != null) || (this.testquestionid != null && !this.testquestionid.equals(other.testquestionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Testquestion[ testquestionid=" + testquestionid + " ]";
    }
    
}
