package apap.tutorial.traveloke.controller;


import apap.tutorial.traveloke.model.HotelModel;
import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUserSubmit(
            @ModelAttribute UserModel user,
            Model model ){
        userService.addUser(user);
        model.addAttribute("user",user);
        return "redirect:/";
    }

    @GetMapping("/changepass")
    private String changePassFormPage(){
        return "form-change-pass";
    }


//    @RequestMapping(value = "/changePass", method = RequestMethod.POST)
//    public String changePassword(
//            @ModelAttribute UserModel user,
//            Model model ){
//        boolean validated = false;
//        userService.addUser(user);
//        model.addAttribute("user",user);
//        return "redirect:/";
//    }

    @PostMapping(value = "/changepass")
    private String gantiPass(
            final HttpServletRequest req,
            Model model
    ){
        String passLama = req.getParameter("passLama");
        String passBaru = req.getParameter("passBaru");
        String passKonfirmasi = req.getParameter("passKonfirmasi");
        System.out.println(passBaru);
        System.out.println(passKonfirmasi);
        String username = req.getRemoteUser();
        UserModel temp = userService.findByUsername(username);
        Boolean sesuai = userService.matchPass(temp, passLama);
        if (sesuai == true){
            Boolean berhasil = userService.updatePass(temp, passBaru, passKonfirmasi);
            if(berhasil == true){
                model.addAttribute("keliatan",true);
                model.addAttribute("takSama", true);
                model.addAttribute("konfirmasi", true);
                return "home";
            }
            else{
                model.addAttribute("keliatan",true);
                model.addAttribute("takSama", true);
                model.addAttribute("konfirmasi", false);
                return "home";
            }
        }
        else{
            model.addAttribute("takSama", false);
            return "home";
        }
    }
}
