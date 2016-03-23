/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain;

import com.inm.school.domain.entityes.Users;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Нюта
 */
public class UserServiceImplTest {
    
    public UserServiceImplTest() {
    }

    @Test
    public void testAddUser() {
    }

    @Test
    public void testUpdateUser() {
        int id = 12;
        UserServiceImpl service = new UserServiceImpl();
        Users user = service.getUser(id);
        user.setFirstname("vasja");
        user.setPass(String.valueOf(System.currentTimeMillis()));
//        assertTrue(service.updateUser(user));
    }

    @Test
    public void testGetUser() {
    }

    @Test
    public void testDeleteUser() {
    }

    @Test
    public void testUserList() {
    }
    
}
