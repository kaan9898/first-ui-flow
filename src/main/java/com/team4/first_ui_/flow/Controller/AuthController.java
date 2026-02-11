package com.team4.first_ui_.flow.Controller;

import com.team4.first_ui_.flow.Dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthController {

    private final List<UserDTO> users = new ArrayList<>();

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        for (UserDTO u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return "redirect:/Products";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String confirmPassword,
                         Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "signup";
        }
        for (UserDTO u : users) {
            if (u.getUsername().equals(username)) {
                model.addAttribute("error", "Username already exists");
                return "signup";
            }
        }
        users.add(new UserDTO(username, password));
        return "redirect:/login";
    }

    @GetMapping("/error/403")
    public String errorPage(Model model) {
        model.addAttribute("message", "Access denied!");
        return "error";
    }
}
