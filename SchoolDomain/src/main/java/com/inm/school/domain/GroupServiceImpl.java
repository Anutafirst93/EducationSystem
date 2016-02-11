/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain;

import java.util.List;


/**
 *
 * @author Нюта
 */
public class GroupServiceImpl implements GroupService {
     
    /*
    insert into groups(name_group,mentor_id) values('group_some','menthor_some');
    
    select * from groups;
    
    update groups set menthor_id='Stas' where name_group ='JAVA 15-02';
    
    delete from groups where name_group = 'group_some';
    */

    @Override
    public void getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateGroup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List getGroupsList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
