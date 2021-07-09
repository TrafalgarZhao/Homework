package com.example.Finalproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
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
        String pwd=req.getParameter("inputPassword");

        Map<String,String> map=new HashMap<>();
        File file=new File("C:\\2.txt");
        Path path=file.toPath();

        //try (Stream<String>lines= Files.lines(path)){
        //  Optional<String> user=lines.filter(line-> {
        //    String[] list=line.split(" ");
        //  return list[0].equals(name) && list[1].equals(pwd);
        //}).findAny();
        //}
        try(Stream<String>lines= Files.lines(path)) {
            lines.forEach(line -> {
                String[] items = line.split(" ");
                map.put(items[0], items[1]);
            });
        }

        if(map.containsKey(name) && map.get(name).equals(pwd)){
            req.getSession().setAttribute("name", name);
           // resp.sendRedirect("index");
            req.getRequestDispatcher("index").forward(req, resp);
        }else{
            resp.sendRedirect("Error.html");
        }


    }
}
