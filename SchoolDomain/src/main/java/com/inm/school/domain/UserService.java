/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain;

import com.inm.school.domain.entityes.Users;
import java.util.List;

/**
 *
 * @author Нюта
 */
public interface UserService {
    public int          addUser(Users u);
//    public void      updateUser(Users u);
    public boolean      updateUser(Users u);
    public Users        getUser(int id); //выборка пол-ля по id 
    public boolean      deleteUser(int id);
    public List<Users>  userList();
}
