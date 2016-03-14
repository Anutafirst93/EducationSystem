/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain;

import com.inm.school.domain.entityes.Group;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Нюта
 */
public class GroupServiceImplTest {
    
    public GroupServiceImplTest() {
    }

    @Test
    public void testGetById() {
    }

    @Test
    public void testUpdateGroup() {
    }

    @Test
    public void testGetGroupsList() {
       GroupServiceImpl service = new GroupServiceImpl();
       List <Group> list = service.getGroupsList();
       for(Group g : list){
           System.out.println(g);
       }
        assertTrue(list.size()> 0);
    }

    @Test
    public void testDeleteId() {
    }
    
}
