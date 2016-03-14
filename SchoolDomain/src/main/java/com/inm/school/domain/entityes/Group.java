/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain.entityes;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Нюта
 */

@Entity
public class Group  implements Serializable{
    @Column(name = "id")
    @Id
    private Integer id ;
    @Column(name = "namegroup")
    private String nameGroup;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;

    public Group() {
    }

    public Group(Integer id, String nameGroup, String firstname, String lastname) {
        this.id = id;
        this.nameGroup = nameGroup;
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public String toString() {
        return "Group{" + "id=" + id + ", nameGroup=" + nameGroup + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }
    
    
}
