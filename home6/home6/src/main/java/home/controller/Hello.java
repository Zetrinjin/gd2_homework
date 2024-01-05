package home.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Hello {

   /* @GetMapping("/hello")
    public String showForm() {
        return "hello";
    }*/

    @GetMapping(value = "/hello")
    public ModelAndView showHelloPage(ModelAndView modelAndView) {
        //Add model
        modelAndView.addObject("message", "Welcome to Spring web MVC");
        modelAndView.setViewName("hello");

        // Return view name
        return modelAndView;
    }
}


