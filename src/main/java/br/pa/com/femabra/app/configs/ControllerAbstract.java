package br.pa.com.femabra.app.configs;

import javax.servlet.http.HttpServletRequest;

public abstract class ControllerAbstract   {



    public void menssenger(String value, HttpServletRequest request){
        request.setAttribute("messenger",request);
    }



}
