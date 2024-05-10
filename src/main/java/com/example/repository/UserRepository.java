package com.example.repository;

import com.example.entity.EntityUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<EntityUser, Integer> {
    @Query("select u from EntityUser u where u.user_name = :userName")
    List<EntityUser> findUserData(String userName);

    @Query(value = "select * from Entity_User where user_name =:userName", nativeQuery = true)
    List<EntityUser> findUserDataQuery(String userName);

    @Query(value = "select * from Entity_User where user_name=:userName and user_age=:userPass", nativeQuery = true)
    List<EntityUser> findUserPass(String userName, String userPass);




}
