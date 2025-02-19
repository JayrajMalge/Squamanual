
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
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c"),
    @NamedQuery(name = "Course.findByCourseid", query = "SELECT c FROM Course c WHERE c.courseid = :courseid"),
    @NamedQuery(name = "Course.findByCategory", query = "SELECT c FROM Course c WHERE c.category = :category"),
    @NamedQuery(name = "Course.findByName", query = "SELECT c FROM Course c WHERE c.name = :name"),
    @NamedQuery(name = "Course.findByIsfree", query = "SELECT c FROM Course c WHERE c.isfree = :isfree"),
    @NamedQuery(name = "Course.findByPoints", query = "SELECT c FROM Course c WHERE c.points = :points"),
    @NamedQuery(name = "Course.findByDifficulty", query = "SELECT c FROM Course c WHERE c.difficulty = :difficulty"),
    @NamedQuery(name = "Course.findByActive", query = "SELECT c FROM Course c WHERE c.active = :active"),
    @NamedQuery(name = "Course.findByCreateat", query = "SELECT c FROM Course c WHERE c.createat = :createat"),
    @NamedQuery(name = "Course.findByUpdatedat", query = "SELECT c FROM Course c WHERE c.updatedat = :updatedat")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "courseid")
    private Integer courseid;
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
    /*@OneToMany(mappedBy = "course")
    private List<Test> testList;*/
/*@OneToMany(mappedBy = "course")
    private List<Wishcourse> wishcourseList;
    @JsonIgnoreProperties("course")
    @OneToMany(mappedBy = "course")
    private List<Usercourse> usercourseList;*/
    @JoinColumn(name = "category", referencedColumnName = "categoryid")
    @ManyToOne
    private Category category;
    /*@OneToMany(mappedBy = "course")
    private List<Topic> topicList;*/

    public Course() {
    }

    public Course(Integer courseid) {
        this.courseid = courseid;
    }

    public Integer getCourseid() {
        return courseid;
    }

    public void setCourseid(Integer courseid) {
        this.courseid = courseid;
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

    /*public List<Test> getTestList() {
        return testList;
    }

    public void setTestList(List<Test> testList) {
        this.testList = testList;
    }*/

    /*public List<Wishcourse> getWishcourseList() {
        return wishcourseList;
    }

    public void setWishcourseList(List<Wishcourse> wishcourseList) {
        this.wishcourseList = wishcourseList;
    }

    public List<Usercourse> getUsercourseList() {
        return usercourseList;
    }

    public void setUsercourseList(List<Usercourse> usercourseList) {
        this.usercourseList = usercourseList;
    }
    */
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    
    /*public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (courseid != null ? courseid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.courseid == null && other.courseid != null) || (this.courseid != null && !this.courseid.equals(other.courseid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.Course[ courseid=" + courseid + " ]";
    }
    
}
