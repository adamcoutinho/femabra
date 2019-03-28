package br.pa.com.femabra.admin.controllers;

import br.pa.com.femabra.admin.backingbean.UserBackingBean;
import br.pa.com.femabra.database.models.UserDTO;
import br.pa.com.femabra.database.repository.UserDTORepository;
import br.pa.com.femabra.services.commons.ServiceEmail;
import br.pa.com.femabra.services.commons.ServiceHash;
import br.pa.com.femabra.services.commons.ServiceMyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    @PersistenceContext(unitName = "CRM_MYSQL_UP")
    private EntityManager entityManagerMysql;

    @Autowired
    private UserDTORepository userDTORepository;

    enum PAGE {
        RECEIVE_USER("pages/U_12");


        private PAGE(String path) {
            this.path = path;
        }

        public String path;


    }


    @GetMapping("/user")
    public ModelAndView GET(@ModelAttribute("backingBean") UserBackingBean userBackingBean , HttpServletRequest request) {

        ModelAndView mv = new ModelAndView(PAGE.RECEIVE_USER.path);
        UserBackingBean backingBean =new UserBackingBean();
         if(request.getSession().getAttribute("tokenSession")!=null){
             backingBean.setActiveFieldsUser(true);
             backingBean.setTokenReceived(request.getSession().getAttribute("tokenSession").toString());
         }
        System.out.println("teste: -> "+request.getSession().getAttribute("tokenSession"));

        mv.addObject("backingBean",backingBean);
        return mv;
    }


    @PostMapping("/user")
    public ModelAndView POST(@ModelAttribute("backingBean")UserBackingBean backingBean) {
        ModelAndView mv = new ModelAndView(PAGE.RECEIVE_USER.path);

        System.out.println("userName: "+backingBean.getUser().getName());

        System.out.println("email: "+backingBean.getUser().getEmail());

        System.out.println("passwd: "+ServiceHash.apply(backingBean.getUser().getPasswd()));


        backingBean.getUser().setTokenSecurity(ServiceMyToken.randomString(20));


        this.entityManagerMysql.createNativeQuery("INSERT INTO user (email,name,passwd,token_security,type_user) VALUES ('adamcoutinho@gmail.com','sdasdasteste','adamcoutinho','asdasdasd4854',1) ");


        backingBean.setUser(new UserDTO());

        return mv;
    }

    @GetMapping("/credencial")
    public ModelAndView  GET_CREDENCIALS(){
        ModelAndView mv  = new ModelAndView("pages/U_12.html");
        UserBackingBean backingBean = new UserBackingBean();
        backingBean.setActiveFieldsUser(false);
        mv.addObject("backingBean", backingBean );
        return mv;
    }
    @GetMapping("/user/{token}")
    public ModelAndView GET_RECEIVED_CREDENCIALS(@PathVariable("token") String value, HttpSession session) {

        ModelAndView mv = new ModelAndView("redirect:/"+"user");

        UserBackingBean backingBean = new UserBackingBean();
        backingBean.setActiveFieldsUser(true);

        session.setAttribute("tokenSession",value);

        backingBean.setTokenReceived(value);
        mv.addObject("backingBean",backingBean);

        return mv;
    }

    @PostMapping("/sendEmail")
    public ModelAndView POST_EMAIL(@ModelAttribute("backingBean") UserBackingBean backingBean , HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView(PAGE.RECEIVE_USER.path);
        try{

                if(backingBean.getEmail().isEmpty()){
                    backingBean.setActiveFieldsUser(true);
                }


            ServiceEmail.Send(backingBean.getEmail(),ServiceMyToken.randomString(20));
                backingBean.setEmail(new String());

        }catch(Exception e){
            request.setAttribute("messenger",e.getLocalizedMessage());
        }

        return mv;
    }

}
