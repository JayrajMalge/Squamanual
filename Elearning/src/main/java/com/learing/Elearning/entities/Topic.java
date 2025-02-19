
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



@Entity
@Table(name = "topic")
@NamedQueries({
    @NamedQuery(name = "Topic.findAll", query = "SELECT t FROM Topic t"),
    @NamedQuery(name = "Topic.findByTopicid", query = "SELECT t FROM Topic t WHERE t.topicid = :topicid"),
    @NamedQuery(name = "Topic.findByName", query = "SELECT t FROM Topic t WHERE t.name = :name"),
    @NamedQuery(name = "Topic.findByActive", query = "SELECT t FROM Topic t WHERE t.active = :active"),
    @NamedQuery(name = "Topic.findByCourseid", query = "SELECT t FROM Topic t WHERE t.course.courseid = :courseid"),
    @NamedQuery(name = "Topic.findByCreateat", query = "SELECT t FROM Topic t WHERE t.createat = :createat"),
    @NamedQuery(name = "Topic.findByUpdatedat", query = "SELECT t FROM Topic t WHERE t.updatedat = :updatedat")})
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "topicid")
    private Integer topicid;
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private Integer active;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    /*@OneToMany(mappedBy = "topic")
    private List<Test> testList;*/
    @JoinColumn(name = "course", referencedColumnName = "courseid")
    @ManyToOne
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
    /*@OneToMany(mappedBy = "topic")
    private List<Concept> conceptList;*/
    /*@JoinColumn(name = "course", referencedColumnName = "courseid")
    @ManyToOne
    private Course course;*/

    public Topic() {
    }

    public Topic(Integer topicid) {
        this.topicid = topicid;
    }

    public Integer getTopicid() {
        return topicid;
    }

    public void setTopicid(Integer topicid) {
        this.topicid = topicid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    /*public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }*/

    /*public List<Concept> getConceptList() {
        return conceptList;
    }

    public void setConceptList(List<Concept> conceptList) {
        this.conceptList = conceptList;
    }*/

    /*public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (topicid != null ? topicid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Topic)) {
            return false;
        }
        Topic other = (Topic) object;
        if ((this.topicid == null && other.topicid != null) || (this.topicid != null && !this.topicid.equals(other.topicid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Topic[ topicid=" + topicid + " ]";
    }
    
}
