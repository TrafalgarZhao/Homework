package com.example.Finalproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@WebServlet("/search")
public class Search extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        List<String> list=new ArrayList<>();
        File file=new File("C:\\Game.txt");
        Path path=file.toPath();
        try(Stream<String> lines= Files.lines(path)) {
            lines.forEach(line -> {
                String[] items = line.split(" ");
                list.add(items[0]);
            });
        }
        if(list.contains(name)){
            req.getSession().setAttribute("name", name);
            req.getRequestDispatcher("result.jsp").forward(req, resp);
        }else{
            resp.sendRedirect("result2.html");
        }
    }
}
