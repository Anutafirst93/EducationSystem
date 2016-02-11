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
public interface StudingroupService {
  
    public void getById (int id);
    //добавить парам. группа 
    public void updateGroup ();
    public List getGroupsList ();
    public void deleteId (int id);
}
