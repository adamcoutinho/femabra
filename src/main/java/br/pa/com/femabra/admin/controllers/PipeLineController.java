package br.pa.com.femabra.admin.controllers;

import br.pa.com.femabra.admin.backingbean.PipeLineBackingBean;
import br.pa.com.femabra.database.models.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class PipeLineController {

    @Autowired
    @Qualifier("jdbcFemabra01")
    private JdbcTemplate jdbcTemplate;


    @GetMapping("/pipeline")
    public ModelAndView get(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("pipeadmin.html");

        HttpSession httpSession = req.getSession();


        List<Map<String,Object>> rows = jdbcTemplate.queryForList("SELECT * FROM TCOMLIBERACAO");


        for (Map row : rows) {
            System.out.println("codigo empresa: " + row.get("EMEPRESA") + "" + row.get("VALOR"));
        }

        UserDTO user = (UserDTO) httpSession.getAttribute("user");
        mv.addObject("pipeLineBackingBean", new PipeLineBackingBean());


        return mv;
    }

}
