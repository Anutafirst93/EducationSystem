/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.inm.school.domain;

import com.inm.school.HibernateUtil;
import com.inm.school.domain.entityes.Users;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;


/**
 *
 * @author Нюта
 */
public class UserServiceImpl implements UserService{
    private final Session session; 
    public UserServiceImpl(){
        //создание и открытие сессии
        session = new HibernateUtil().getSessionFactory().openSession();
    }
    /*
    insert into users (login,pass,firstname,lastname,role,email) values ('was@mail.ru',
'1234','was','pupkin','admin','was@mail.ru');
    insert into users (login,pass,firstname,lastname,role,email) values ('sveta@mail.ru',
'2222','sveta','inazova','admin','sveta@mail.ru');
    
    select login from users;
    select * from users;
    
    update users set pass='1111' where login ='was@mail.ru';
    
    delete from users where login = 'sveta@mail.ru';
    */

    @Override
    public int addUser(Users u) {
        session.beginTransaction();
        int id = -1;
        try{
            id = (int)session.save(u);
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }
        return id;
    }

    @Override
    public boolean updateUser(Users u) {        
        String query = "update users set login=:login, "
                + " firstname=:firstname, lastname=:lastname, "
                + "roles=:roles, email=:email where id=:id";
        int rows = 0;
        session.beginTransaction();
        try{
            Query q = session.createSQLQuery(query).setParameter("login", u.getLogin())
                    .setParameter("firstname", u.getFirstname())
                    .setParameter("lastname", u.getLastname())
                    .setParameter("roles", u.getRoles())
                    .setParameter("email", u.getEmail())
                    .setParameter("id", u.getId());
            System.out.println("update request");
            System.out.println(q.toString());
            rows= q.executeUpdate();
            session.getTransaction().commit();
        }catch(Exception ex){
            ex.printStackTrace();
            session.getTransaction().rollback();
        }
        return (rows > 0);
    }

    @Override
    public Users getUser(int id) {
        Users u = (Users)session.get(Users.class, id);
        return u;
    }

    @Override
    public boolean deleteUser(int id) {
        boolean resalt = true;
        session.beginTransaction();
        try{
            session.createSQLQuery("delete from users where id = :id").addEntity(Users.class).setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
            resalt = true;
        }catch(Exception ex){
            resalt = false;
        }
        return resalt;
    }

    @Override
    public List<Users> userList() {
        List<Users> userlist;
        // select * from users
        userlist = session.createSQLQuery("select * from users").addEntity(Users.class).list();
        return userlist;
    }

    @Override
    public List<Users> getMentors(int start, int offset) {
        String query = "select * from users where roles = :role order by id asc limit :start, :offset";
        return session.createSQLQuery(query)
                .addEntity(Users.class)
                .setParameter("start", start)
                .setParameter("offset", offset)
                .setParameter("role", Users.Roles.MENTOR.name())
                .list();
    }

    @Override
    public int getUsersCount(String role) {
        String query = "select * from users where roles = :role";
        return session.createSQLQuery(query)
                .addEntity(Users.class)
                .setParameter("role", role)
                .list().size();
    }
    
    
} 

