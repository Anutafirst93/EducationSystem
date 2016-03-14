/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain;

import com.inm.school.domain.entityes.Group;
import com.inm.school.domain.entityes.Users;
import java.util.List;
import org.hibernate.Session;


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
        String req = "select g.id as id, g.namegroup as namegroup, u.firstname as firstname, u.lastname as lastname " +
"from users u, groups g " +
"where g.menthorid = u.id";
        Session session = com.inm.school.HibernateUtil.getSessionFactory().openSession();
        List<Group> grouplist;
        // select * from users
        grouplist = session.createSQLQuery(req).addEntity(Group.class).list();
        return grouplist;
    }

    @Override
    public void deleteId(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
