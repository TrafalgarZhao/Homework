package com.example.Finalproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "HomeServlet", value = "/index")
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("name");
        if (name==null) {
            request.setAttribute("name", "Guest");
            request.setAttribute("buttonName", "Sign In");
            request.setAttribute("buttonLink", "sign-in");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            if (name.equals("Tom")) {
                request.setAttribute("name", name);
                request.setAttribute("buttonName", "Log Out");
                request.setAttribute("buttonLink", "log-out");
                request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
            } else {
                request.setAttribute("name", name);
                request.setAttribute("buttonName", "Log Out");
                request.setAttribute("buttonLink", "log-out");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }

        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = (String) request.getSession().getAttribute("name");
        if (name==null) {
            request.setAttribute("name", "Guest");
            request.setAttribute("buttonName", "Sign In");
            request.setAttribute("buttonLink", "sign-in");
            request.getRequestDispatcher("home.jsp").forward(request, response);
        } else {
            if (name.equals("Tom")) {
                request.setAttribute("name", name);
                request.setAttribute("buttonName", "Log Out");
                request.setAttribute("buttonLink", "log-out");
                request.getRequestDispatcher("homeAdmin.jsp").forward(request, response);
            } else {
                request.setAttribute("name", name);
                request.setAttribute("buttonName", "Log Out");
                request.setAttribute("buttonLink", "log-out");
                request.getRequestDispatcher("home.jsp").forward(request, response);
            }

        }
    }
}
