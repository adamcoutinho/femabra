package br.pa.com.femabra.admin.controllers;

import br.pa.com.femabra.app.configs.ControllerAbstract;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes(value = {"backingBean"})
public class TestController extends ControllerAbstract {


        private static String NAME_PAGE="results::content-render";

    @GetMapping("/test")
    public String GET(){




        return NAME_PAGE;
    }

    @PostMapping("/test")
    public String POST(){


        return NAME_PAGE;
    }


}
