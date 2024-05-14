package com.example.controller;

import com.example.dto.DTOBoard;
import com.example.dto.DTOUser;
import com.example.service.ServiceBoard;
import com.example.service.ServiceUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    ServiceUser _serviceUser;
    @Autowired
    ServiceBoard _serviceBoard;

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

    @GetMapping("board")
    public String board(Model m, HttpSession session){
        m.addAttribute("tableList", _serviceBoard.GetAllBoard());
        return "Mypage";
    }

    @PostMapping("/Write")
    public String write(DTOBoard board, Model m, HttpSession session){
        String currentUserName = (String) session.getAttribute("LoginOK");
        if(currentUserName != null){
            board.setWriter(currentUserName);
            _serviceBoard.Write(board);
            m.addAttribute("tableList", _serviceBoard.GetAllBoard());
            return "BoardMain";
        }else{
            return "Login";
        }
    }

    @GetMapping("/BoardMain")
    public String BoardMain(Model m, HttpSession session){
        if(session.getAttribute("LoginOK") == "LoginOK") {
            m.addAttribute("tableList", _serviceBoard.GetAllBoard());
            return "BoardMain";
        }
        else
            return "Login";
    }
        @GetMapping("/Write")
        public String getWriteForm(HttpSession session) {
            String currentUserName = (String) session.getAttribute("LoginOK");
            if (currentUserName != null) {
                return "BoardMain";
            } else {
                return "Login";
            }
        }

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