package br.pa.com.femabra.admin.controllers;

import br.pa.com.femabra.admin.backingbean.LoginBackingBean;
import br.pa.com.femabra.database.models.UserDTO;
import br.pa.com.femabra.properties.FemabraProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LoginController {

    @Autowired
    private FemabraProperties femabraProperties;



    enum PAGE {
        DASHBOARD("panel"),
        LOGIN("login"),
        RECEIVE_CREDENCIAL("pages/U_11");


        private PAGE(String path) {
            this.path = path;
        }

        private String path;

        public String getPath() {
            return path;
        }
    }

    @GetMapping("/login")
    public ModelAndView index() throws SQLException {
        ModelAndView mv = new ModelAndView("index.html");
//        ModelAndView mv = new ModelAndView("pipeadmin.html");
        mv.addObject("backingBean", new LoginBackingBean());

        return mv;

    }

    @PostMapping("/login")
    public ModelAndView POST(ModelMap model, @ModelAttribute("backingBean") LoginBackingBean backingBean, HttpServletRequest req, HttpSession session) throws Exception {
        String page = null;
        try {

            UserDTO user = new UserDTO();
            user.setName(backingBean.getUser());
            user.setPasswd(backingBean.getPasswd());
            session.setAttribute("user", user);




//            System.out.println(user.getName());
//            System.out.println(user.getPasswd());




            if (backingBean.getUser().equals("adminUser") && backingBean.getPasswd().equals("123")) {
                page = "redirect:/" + PAGE.DASHBOARD.path;
            } else {
//            page  = "forward:/" + PAGE.LOGIN.path;
                    page = "index.html";
                req.setAttribute("messenger","Login ou Senha Inválidos!");


            }
        } catch (Exception e) {
                req.setAttribute("menssenger",e.getLocalizedMessage());
        }
        return new ModelAndView(page);
    }

    @PostMapping("/credencial")
    public ModelAndView  POST_CREDENCIALS(){
        ModelAndView mv  = new ModelAndView("redirect:/pages/U_12");




        return mv;
    }



}
