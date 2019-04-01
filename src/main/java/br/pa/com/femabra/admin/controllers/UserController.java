package br.pa.com.femabra.admin.controllers;

import br.pa.com.femabra.admin.backingbean.UserBackingBean;
import br.pa.com.femabra.app.configs.ControllerAbstract;
import br.pa.com.femabra.app.configs.ValidMenssage;
import br.pa.com.femabra.database.models.UserDTO;
import br.pa.com.femabra.database.repository.UserDTORepository;
import br.pa.com.femabra.services.commons.ServiceEmail;
import br.pa.com.femabra.services.commons.ServiceHash;
import br.pa.com.femabra.services.commons.ServiceMyToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalTime;
import java.util.Date;

@Controller
@SessionAttributes(value = "backingBean")
public class UserController extends ControllerAbstract {


    private static int  LIMIT_HOUR_VALIDATE =2;

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
    public ModelAndView GET(@ModelAttribute("backingBean") UserBackingBean backingBean , HttpServletRequest request) {

        ModelAndView mv = new ModelAndView(PAGE.RECEIVE_USER.path);

         if(request.getSession().getAttribute("tokenSession")!=null){
             backingBean.setActiveFieldsUser(true);
             backingBean.setTokenReceived(request.getSession().getAttribute("tokenSession").toString());
         }




        return mv;
    }


    @PostMapping("/user")
    public ModelAndView POST(@ModelAttribute("backingBean")UserBackingBean backingBean ,HttpServletRequest request) throws ValidMenssage {
        ModelAndView mv = new ModelAndView(PAGE.RECEIVE_USER.path);
        try {


            backingBean.getUser().setPasswd(ServiceHash.apply(backingBean.getUser().getPasswd()));
            backingBean.getUser().setTokenSecurity(ServiceMyToken.randomString(20));
            backingBean.getUser().setDateUpdate(new Date());

//            if(LocalTime.now().isAfter(backingBean.getUser().getHourExpiration())){
//                throw  new ValidMenssage("Tempo para Atualizar a senha expirou.");
//            }



            this.userDTORepository.save(backingBean.getUser());
            backingBean.setUser(new UserDTO());

    mv.addObject("messenger","credenciais Atualizadas.");

        }catch(Exception e){
            mv.addObject("messenger",e.getLocalizedMessage());
//            menssenger(e.getLocalizedMessage(),request);
        }
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
    public ModelAndView GET_RECEIVED_CREDENCIALS(@ModelAttribute("backingBean") UserBackingBean backingBean,@PathVariable("token") String value, HttpSession session) {

        ModelAndView mv = new ModelAndView("redirect:/"+"user");


        backingBean.setActiveFieldsUser(true);

        session.setAttribute("tokenSession",value);

        backingBean.setTokenReceived(value);


        return mv;
    }

    @PostMapping("/sendEmail")
    public ModelAndView POST_EMAIL(@ModelAttribute("backingBean") UserBackingBean backingBean , HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView(PAGE.RECEIVE_USER.path);
        try{

                if(backingBean.getEmail().isEmpty()){
                    backingBean.setActiveFieldsUser(true);
                }

            UserDTO user = this.userDTORepository.findByDescribeEmail(backingBean.getEmail());
            user.setHourExpiration(LocalTime.now().plusHours(LIMIT_HOUR_VALIDATE));
            user.setTokenSecurity(ServiceMyToken.randomString(20));
            backingBean.setUser(user);

                ServiceEmail.Send(backingBean.getEmail(),ServiceMyToken.randomString(20));
                backingBean.setEmail(new String());
            mv.addObject("messenger","Credenciais Atualizadas.");
        }catch(Exception e){
            mv.addObject("messenger",e.getLocalizedMessage());
//            menssenger(e.getLocalizedMessage(),request);
        }

        return mv;
    }

}
