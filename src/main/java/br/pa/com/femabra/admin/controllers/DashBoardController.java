package br.pa.com.femabra.admin.controllers;

import br.pa.com.femabra.admin.backingbean.DashBoardBackingBean;
import br.pa.com.femabra.database.models.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DashBoardController {


    @GetMapping("/panel")
    public ModelAndView GET(HttpServletRequest req){
        ModelAndView mv = new ModelAndView("cad.html");


             HttpSession httpSession = req.getSession();


    UserDTO user= (UserDTO) httpSession.getAttribute("user");




        mv.addObject("userSession",user);
        DashBoardBackingBean backingBean  = new DashBoardBackingBean();

        mv.addObject("dashBackingBean",backingBean);

        return mv;
    }


}
