package br.pa.com.femabra.admin.controllers;

import br.pa.com.femabra.admin.backingbean.PipeLineBackingBean;
import br.pa.com.femabra.database.models.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PipeLineController {


    @GetMapping("/pipeline")
    public ModelAndView get(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("pipeadmin.html");

        HttpSession httpSession = req.getSession();


        UserDTO user = (UserDTO) httpSession.getAttribute("user");
        mv.addObject("pipeLineBackingBean",new PipeLineBackingBean());


        return mv;
    }

}
