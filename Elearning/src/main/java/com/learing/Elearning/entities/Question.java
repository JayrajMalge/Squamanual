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
import jakarta.persistence.Lob;
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
@Table(name = "question")
@NamedQueries({
    @NamedQuery(name = "Question.findAll", query = "SELECT q FROM Question q"),
    @NamedQuery(name = "Question.findByQuestionid", query = "SELECT q FROM Question q WHERE q.questionid = :questionid"),
    @NamedQuery(name = "Question.findByCorrectoption", query = "SELECT q FROM Question q WHERE q.correctoption = :correctoption"),
    @NamedQuery(name = "Question.findByDifficulty", query = "SELECT q FROM Question q WHERE q.difficulty = :difficulty"),
        @NamedQuery(name = "Question.findByConcept", query = "SELECT q FROM Question q WHERE q.concept.conceptid = :concept"),
    @NamedQuery(name = "Question.findByActive", query = "SELECT q FROM Question q WHERE q.active = :active"),
    @NamedQuery(name = "Question.findByCreateat", query = "SELECT q FROM Question q WHERE q.createat = :createat"),
    @NamedQuery(name = "Question.findByUpdatedat", query = "SELECT q FROM Question q WHERE q.updatedat = :updatedat")})
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "questionid")
    private Integer questionid;
    @Lob
    @Column(name = "questionmarkup")
    private String questionmarkup;
    @Column(name = "correctoption")
    private Integer correctoption;
    @Lob
    @Column(name = "answermarkup")
    private String answermarkup;
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
    /*@OneToMany(mappedBy = "question")
    private List<Testquestion> testquestionList;*/
    @JoinColumn(name = "concept", referencedColumnName = "conceptid")
    @ManyToOne
    private Concept concept;

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Question() {
    }

    public Question(Integer questionid) {
        this.questionid = questionid;
    }

    public Integer getQuestionid() {
        return questionid;
    }

    public void setQuestionid(Integer questionid) {
        this.questionid = questionid;
    }

    public String getQuestionmarkup() {
        return questionmarkup;
    }

    public void setQuestionmarkup(String questionmarkup) {
        this.questionmarkup = questionmarkup;
    }

    public Integer getCorrectoption() {
        return correctoption;
    }

    public void setCorrectoption(Integer correctoption) {
        this.correctoption = correctoption;
    }

    public String getAnswermarkup() {
        return answermarkup;
    }

    public void setAnswermarkup(String answermarkup) {
        this.answermarkup = answermarkup;
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

    /*public List<Testquestion> getTestquestionList() {
        return testquestionList;
    }

    public void setTestquestionList(List<Testquestion> testquestionList) {
        this.testquestionList = testquestionList;
    }*/

    /*public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (questionid != null ? questionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Question)) {
            return false;
        }
        Question other = (Question) object;
        if ((this.questionid == null && other.questionid != null) || (this.questionid != null && !this.questionid.equals(other.questionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Question[ questionid=" + questionid + " ]";
    }
    
}
