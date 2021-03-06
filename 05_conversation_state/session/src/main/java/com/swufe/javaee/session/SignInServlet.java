package com.swufe.javaee.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String password = req.getParameter("inputPassword");
        final String path = "C:\\Users\\赵子熠\\Desktop\\test\\password.txt";
        Stream<String> lines = Files.lines(Paths.get(path));
        Map<String,String> map= new HashMap<>();
        lines.forEach(line -> {
            String[] name_pwd = line.split(" ");
            map.put(name_pwd[0], name_pwd[1]);
        });
        if(map.containsKey(name)&& map.get(name).equals(password)){
            req.getSession().setAttribute("user", name);
            resp.sendRedirect("index");
        }else{
            resp.sendRedirect("wrong.html");
        }

    }
}
