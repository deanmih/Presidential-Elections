package com.example.Presidential.Elections;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;


@Controller
public class HomeController {

@Autowired
private UserRepository userRepository;

@Autowired
private PasswordEncoder passwordEncoder; 

@GetMapping("/")
public String Home(){
    return "start";
}

@GetMapping("/login")
public String getLogin() {
    return "login";
}

@GetMapping("/register")
public String getRegister(Model model) {
    model.addAttribute("user", new Users()); // Add a new Users object to the model
    return "register";
}

@PostMapping("/adduser")
public String addUser(@ModelAttribute("user") Users user) {
    String hashedPassword = passwordEncoder.encode(user.getPassword()); 
    user.setPassword(hashedPassword);
    userRepository.save(user); // Saves the user to the database
    return "redirect:/login"; // Redirects to a success page or another location
}

@PostMapping("/process-login")
public String processLogin(@ModelAttribute Users user, Model model) {
// Retrieve the stored user by username
    Users storedUser = userRepository.findByUsername(user.getUsername());

// Check if the passwords match
    if (storedUser != null && passwordEncoder.matches(user.getPassword(), storedUser.getPassword())) {
    // Add user information to the model
        model.addAttribute("username", storedUser.getUsername());
        model.addAttribute("bio", storedUser.getBio());
        return "profile";  // Redirect to the profile page
    } else {
        return "login";  // Invalid login, redirect back to the login page
    }
}


@GetMapping("/profile")
public String profile(Model model, Principal principal) {
    // Use the logged-in username to retrieve the user
    String loggedInUsername = principal.getName();  // Get the username from the authentication object
    Users storedUser = userRepository.findByUsername(loggedInUsername);

    // Add user details to the model
    if (storedUser != null) {
        model.addAttribute("username", storedUser.getUsername());
        model.addAttribute("bio", storedUser.getBio());
    }
    return "profile";
    }

public static class CandidateRequest {
        private String name;

        // Getter and setter for 'name'
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


}
