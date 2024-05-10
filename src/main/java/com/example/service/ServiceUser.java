package com.example.service;

import com.example.dto.DTOUser;
import com.example.entity.EntityUser;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceUser {
    @Autowired
    UserRepository userRopo;
    public void Join(DTOUser user){
        System.out.println(user.User_Name);
        System.out.println(user.User_Age);

        userRopo.save(user.ToEntity());
    }
    public boolean Login(DTOUser user){
        System.out.println(user.User_Name);
        System.out.println(user.User_Age);

        List<EntityUser> list = userRopo.findUserPass(user.User_Name, user.User_Age);

        if(list.size()==0)
            return false;
        else
            return true;
    }

    public Iterable<EntityUser> GetAllUser(){
        return userRopo.findAll();
    }
}
