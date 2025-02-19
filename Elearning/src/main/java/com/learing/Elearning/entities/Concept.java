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
@Table(name = "concept")
@NamedQueries({
    @NamedQuery(name = "Concept.findAll", query = "SELECT c FROM Concept c"),
    @NamedQuery(name = "Concept.findByConceptid", query = "SELECT c FROM Concept c WHERE c.conceptid = :conceptid"),
    @NamedQuery(name = "Concept.findByTitle", query = "SELECT c FROM Concept c WHERE c.title = :title"),
    @NamedQuery(name = "Concept.findByActive", query = "SELECT c FROM Concept c WHERE c.active = :active"),
    @NamedQuery(name = "Concept.findByTopicid", query = "SELECT c FROM Concept c WHERE c.topic.topicid = :topicid"),
    @NamedQuery(name = "Concept.findByCreateat", query = "SELECT c FROM Concept c WHERE c.createat = :createat"),
    @NamedQuery(name = "Concept.findByUpdatedat", query = "SELECT c FROM Concept c WHERE c.updatedat = :updatedat")})
public class Concept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conceptid")
    private Integer conceptid;
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "descriptionmarkup")
    private String descriptionmarkup;
    @Column(name = "active")
    private Integer active;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    /*@OneToMany(mappedBy = "concept")
    private List<Question> questionList;*/
    @JoinColumn(name = "topic", referencedColumnName = "topicid")
    @ManyToOne
    private Topic topic;
    /*@JoinColumn(name = "topic", referencedColumnName = "topicid")
    @ManyToOne
    private Topic topic;*/


    public Concept() {
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Concept(Integer conceptid) {
        this.conceptid = conceptid;
    }

    public Integer getConceptid() {
        return conceptid;
    }

    public void setConceptid(Integer conceptid) {
        this.conceptid = conceptid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptionmarkup() {
        return descriptionmarkup;
    }

    public void setDescriptionmarkup(String descriptionmarkup) {
        this.descriptionmarkup = descriptionmarkup;
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

    /*public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }*/

    /*public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conceptid != null ? conceptid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concept)) {
            return false;
        }
        Concept other = (Concept) object;
        if ((this.conceptid == null && other.conceptid != null) || (this.conceptid != null && !this.conceptid.equals(other.conceptid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Concept[ conceptid=" + conceptid + " ]";
    }
    
}
