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
public class StudingroupImpl implements UserService{

   
     /*
    insert into studingroup values ('1','JAVA 15-02');
    select login, pass, firstname, lastname, email from users where Id in 
        (select userid from studingroup where groupid = 'JAVA 15-02') and role = 'stud';
    
    select login, pass, firstname, lastname, email from users where Id in 
        (select userid from studingroup where groupid in (select groupid from studingroup where userid = '3')) and role = 'menthor';
    
    select firstname, lastname, email from users where Id = 
(select menthor_id from groups where name_group = 
(select groupid from studingroup where userid = 
(select Id from users where lastname = 'inazova' and role = 'stud')));
    
    update studingroup set groupid = 'JAVA 15-03' where userid = '2';
    */


    @Override
    public int addUser(Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateUser(Users u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Users getUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteUser(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Users> userList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
