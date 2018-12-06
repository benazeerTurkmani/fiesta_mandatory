package com.example.demo.controller;

import org.springframework.stereotype.Controller;

@Controller
public class LoginController {

   /* @Autowired
    private BrugerRepository brugerRepo;

    String error = "";

    @GetMapping("/login")
    public String login(Model model){

        model.addAttribute("error", error);

        return "other_stuff/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Bruger bruger, HttpServletRequest request) {

        ArrayList<Bruger> eksisterendeBruger = (ArrayList<Bruger>) brugerRepo


        Bruger eksisterendeBruger = bruger.getEmail();

        ArrayList<Courses> courses = (ArrayList<Courses>) coursesRepo.findAll(Specification


        if (!eksisterendeBruger.getEmail().isEmpty()) {
            if (eksisterendeBruger.getPassword().equals(bruger.getPassword())) {
                HttpSession session = request.getSession();
                session.setAttribute("bruger", eksisterendeBruger);
                return "redirect:/forside";
            }
        }
        error = "Ugyldigt login";

        return "redirect:/login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        session_kontrol.logout(request);

        return "redirect:/login";
    }*/
}
