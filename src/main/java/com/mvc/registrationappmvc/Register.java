package com.mvc.registrationappmvc;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/Register")
public class Register extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("UName");
        int age = Integer.parseInt(request.getParameter("UAge"));
        String city = request.getParameter("UCity");
        String email = request.getParameter("UEmail");
        String pswd = request.getParameter("UPswd");

        Model model = new Model();
        model.setName(name);
        model.setAge(age);
        model.setCity(city);
        model.setEmail(email);
        model.setPassword(pswd);
        HttpSession session = request.getSession();
        session.setAttribute("UName", name);
        int rowsAffected = model.register();
        if(rowsAffected == 0){
            response.sendRedirect("/RegistrationAppMVC/failed.jsp");
        }
        else{
            response.sendRedirect("/RegistrationAppMVC/successful.jsp");
        }
    }
}