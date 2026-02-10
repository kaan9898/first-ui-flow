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
                return "redirect:/items";
            }
        }
        model.addAttribute("error", "Invalid username or password");
        return "login";
    }
}
