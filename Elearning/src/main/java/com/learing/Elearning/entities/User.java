
package com.learing.Elearning.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@JsonIgnoreProperties("course")
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPasswordhashsalted", query = "SELECT u FROM User u WHERE u.passwordhashsalted = :passwordhashsalted"),
    @NamedQuery(name = "User.findByRole", query = "SELECT u FROM User u WHERE u.role = :role"),
    @NamedQuery(name = "User.findByActive", query = "SELECT u FROM User u WHERE u.active = :active"),
    @NamedQuery(name = "User.updateByusername", query = "UPDATE User u SET u.username = :username, u.email = :email WHERE u.username = :username"),
    @NamedQuery(name = "User.findByCreateat", query = "SELECT u FROM User u WHERE u.createat = :createat"),
    @NamedQuery(name = "User.findByUpdatedat", query = "SELECT u FROM User u WHERE u.updatedat = :updatedat"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Column(name = "username")
    private String username;
    @Column(name = "passwordhashsalted")
    private String passwordhashsalted;
    @Column(name = "role")
    private String role; 
    @Column(name = "active")
    private Integer active;
    @Column(name = "createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    @Column(name = "updatedat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedat;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    /*@OneToMany(mappedBy = "user")
    private List<Test> testList;*/
    /*@OneToMany(mappedBy = "user")
    private List<Wishcourse> wishcourseList;
    @OneToMany(mappedBy = "user")
    private List<Usercourse> usercourseList;*/

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordhashsalted() {
        return passwordhashsalted;
    }

    public void setPasswordhashsalted(String passwordhashsalted) {
        this.passwordhashsalted = passwordhashsalted;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    }*/

    /*public List<Usercourse> getUsercourseList() {
        return usercourseList;
    }

    public void setUsercourseList(List<Usercourse> usercourseList) {
        this.usercourseList = usercourseList;
    }*/

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.elearning.elearning.entities.User[ userid=" + userid + " ]";
    }
    
}
