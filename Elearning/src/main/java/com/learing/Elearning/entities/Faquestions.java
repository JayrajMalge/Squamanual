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
@Table(name = "faquestions")
@NamedQueries({
    @NamedQuery(name = "Faquestions.findAll", query = "SELECT f FROM Faquestions f"),
    @NamedQuery(name = "Faquestions.findAllGropuByQuestion", query = "SELECT f FROM Faquestions f GROUP BY question"),
    @NamedQuery(name = "Faquestions.findByQuestionid", query = "SELECT f FROM Faquestions f WHERE f.questionid = :questionid"),
    @NamedQuery(name = "Faquestions.findByQuestion", query = "SELECT f FROM Faquestions f WHERE f.question = :question"),
    @NamedQuery(name = "Faquestions.findByAnswer", query = "SELECT f FROM Faquestions f WHERE f.answer = :answer"),
    @NamedQuery(name = "Faquestions.findByUser", query = "SELECT f FROM Faquestions f WHERE f.user.userid = :userid"),
    @NamedQuery(name = "Faquestions.updateByQuestion", query = "SELECT f FROM Faquestions f WHERE f.user.userid = :userid"),
    @NamedQuery(name = "Faquestions.findByCreateat", query = "SELECT f FROM Faquestions f WHERE f.createat = :createat"),
    @NamedQuery(name = "Faquestions.findByUpdatedat", query = "SELECT f FROM Faquestions f WHERE f.updatedat = :updatedat")})
public class Faquestions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "questionid")
    private Integer questionid;
    @Column(name = "question")
    private String question;
    @Column(name = "answer")
    private String answer;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @JoinColumn(name = "user", referencedColumnName = "userid" ,nullable = false)
    @ManyToOne
    private User user;
 
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public Faquestions() {
    }

    public Faquestions(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionid != null ? questionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Faquestions)) {
            return false;
        }
        Faquestions other = (Faquestions) object;
        if ((this.questionid == null && other.questionid != null) || (this.questionid != null && !this.questionid.equals(other.questionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Faquestions[ questionid=" + questionid + " ]";
    }
    
}
