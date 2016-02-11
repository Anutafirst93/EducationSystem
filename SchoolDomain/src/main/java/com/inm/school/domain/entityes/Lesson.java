/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain.entityes;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Нюта
 */
@Entity
@Table(name = "lesson")
@NamedQueries({
    @NamedQuery(name = "Lesson.findAll", query = "SELECT l FROM Lesson l")})
public class Lesson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "day")
    private String day;
    @Basic(optional = false)
    @Column(name = "lessontime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lessontime;
    @Basic(optional = false)
    @Column(name = "groupsid")
    private String groupsid;
    @Basic(optional = false)
    @Column(name = "menthorid")
    private int menthorid;

    public Lesson() {
    }

    public Lesson(Integer id) {
        this.id = id;
    }

    public Lesson(Integer id, String day, Date lessontime, String groupsid, int menthorid) {
        this.id = id;
        this.day = day;
        this.lessontime = lessontime;
        this.groupsid = groupsid;
        this.menthorid = menthorid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Date getLessontime() {
        return lessontime;
    }

    public void setLessontime(Date lessontime) {
        this.lessontime = lessontime;
    }

    public String getGroupsid() {
        return groupsid;
    }

    public void setGroupsid(String groupsid) {
        this.groupsid = groupsid;
    }

    public int getMenthorid() {
        return menthorid;
    }

    public void setMenthorid(int menthorid) {
        this.menthorid = menthorid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lesson)) {
            return false;
        }
        Lesson other = (Lesson) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.inm.school.domain.entityes.Lesson[ id=" + id + " ]";
    }
    
}
