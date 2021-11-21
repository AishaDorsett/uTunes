package com.JavaIdea4.UTunes.controller;

import java.io.IOException;

import com.JavaIdea4.UTunes.model.User;
import com.JavaIdea4.UTunes.model.Authority;
import com.JavaIdea4.UTunes.repository.UserRepository;
import com.JavaIdea4.UTunes.repository.AuthoritiesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthoritiesRepository authoritiesRepository;

	@RequestMapping("/users/new")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping("/users")
    public RedirectView signup(@ModelAttribute User user) throws IOException {
        userRepository.save(user);

        Authority authority = new Authority(user.getUsername(), "ROLE_USER");
        authoritiesRepository.save(authority);
        return new RedirectView("/login");
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "users/login";
    }
}


// import org.springframework.data.domain.Sort;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.view.RedirectView;
// import org.springframework.security.core.userdetails.UserDetails;

// import java.io.IOException;
// import java.util.List;

// @Controller
// public class UserController {


//     @Autowired
//     UserRepository userRepository;
//     @Autowired
//     AuthoritiesRepository authoritiesRepository;

//     @GetMapping("/users/new")
//     public String signup(Model model) {
//         model.addAttribute("user", new User());
//         return "users/new";
//     }

//     @PostMapping("/users")
//     public RedirectView signup(@ModelAttribute User user) throws IOException {
//         userRepository.save(user);

//         Authority authority = new Authority(user.getUsername(), "ROLE_USER");
//         authoritiesRepository.save(authority);
//         return new RedirectView("/login");
//     }

//     @GetMapping("/login")
//     public String login(Model model) {
//         return "users/login";
//     }

// }
