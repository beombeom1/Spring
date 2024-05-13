package com.example.controller;

import com.example.dto.DTOUser;
import com.example.entity.EntityUser;
import com.example.repository.UserRepository;
import com.example.service.ServiceUser;
import jakarta.persistence.PostRemove;
import jakarta.servlet.http.HttpSession;
import org.hibernate.Remove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    ServiceUser _serviceUser;

//    @GetMapping("/hello")
//    public String Hello(Model m){
//        m.addAttribute("value","MinSu");
//        return "template";
//    }
//    @GetMapping("/getTest/{id}")
//    @ResponseBody
//    public String GetTest(@PathVariable int id){
//        return String.valueOf(id);
//    }
//
//    @PostMapping("/postTest")
//    @ResponseBody
//    public String PostTest(@RequestBody String param){
//        return param;

    @GetMapping("/Home")
    public String loginHome(Model m, HttpSession session){
        if(session.getAttribute("LoginOK") == "LoginOK") {
            m.addAttribute("tableList", _serviceUser.GetAllUser());
            return "MyPage";
        }
        else
            return "Login";
    }
    @GetMapping("/Logout")
    public String Logout(HttpSession session){
        session.removeAttribute("LoginOK");
        return "Login";
    }

    @GetMapping("/MakeDummy")
    public String makeDummy(){
        for(int i=0;i<10;i++){
            DTOUser user = new DTOUser();
            user.User_Age = String.valueOf(i);
            user.User_Name = String.valueOf(i);
            _serviceUser.Join(user);
        }
        return "Login";
    }
    @PostMapping("/Register")
    public String userRegister(DTOUser user, HttpSession session){


        _serviceUser.Join(user);

        return "Login";
    }
    @GetMapping("/PassChange/{id}/{pass}/{repass}")
    public String userPassChange(@PathVariable String id, @PathVariable String pass, @PathVariable String repass){
        _serviceUser.Repass(id, pass, repass);
        return "Login";
    }

    @PostMapping("/Login")
    public String userLogin(/*@RequestBody*/ DTOUser user, Model m, HttpSession session) {
        if(session.getAttribute("LoginOK") == "LoginOK") {
            m.addAttribute("tableList", _serviceUser.GetAllUser());
            return "MyPage";
        }
        else
        {
            boolean b = _serviceUser.Login(user);
            if(b){
                session.setAttribute("LoginOK","LoginOK");
                m.addAttribute("tableList", _serviceUser.GetAllUser());
                return "MyPage";
        }
            else
                return "Login";
        }

    }

    @GetMapping("/Deleteid/{id}/{pass}")
    public String userDelete(@PathVariable String id,@PathVariable String pass, HttpSession session)
    {
        _serviceUser.Deleteid(id, pass);
        session.invalidate();
        return "Login";
    }

//    @PostMapping("/dtoTest")
//    @ResponseBody
//    public String DTOTest(DTOUser user){
//        System.out.println(user.User_Name);
//        System.out.println(user.User_Age);
//        userRepo.save(user.ToEntity());
//        return user.toString();
//    }
//    @GetMapping("/dtoDeleteTest/{id}")
//    @ResponseBody
//    public String DTODeleteTest(@PathVariable int id){
//        userRepo.deleteById(id);
//        return "";
//    }
//    @GetMapping("/example/{id}")
//    public ResponseEntity<String> getExampleById(@PathVariable Long id){
//        if(id ==1){
//            return ResponseEntity.ok("Example with ID 1 found");
//        }else{
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Example not found");
//        }
//    }
//    @GetMapping("/dtoGetTest/{name}")
//    @ResponseBody
//    public String DTOGetTest(@PathVariable String name){
//        List<EntityUser> list = userRepo.findUserData(name);
//        if(list.size() == 0){
//            return "no user";
//        }else{
//            return list.get(0).getUser_name();
//        }
//        return list.get(0).getUser_name();

}