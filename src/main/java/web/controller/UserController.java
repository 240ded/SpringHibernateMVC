package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @RequestMapping(value = "/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping(value = "/saveUser")
    public String saveUser(@ModelAttribute("user") @Valid User user,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "user-info";
        userService.saveUser(user);
        return "redirect:/showAllUsers";
    }

    @RequestMapping(value = "/updateUser")
    public String updateUser(@RequestParam("userId") long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("userId") long id) {
        userService.deleteUser(id);
        return "redirect:/showAllUsers";
    }
}
