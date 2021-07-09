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

@WebServlet("/recent")
public class recent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> list= new ArrayList<>();
        File file=new File("C:\\Game.txt");
        Path path=file.toPath();
        try(Stream<String> lines= Files.lines(path)) {
            lines.forEach(line -> {
                String[] items = line.split(" ");
                list.add(items[0]);
            });
        }
        List<String> name=new ArrayList<>();
        name.add(list.get(list.size() - 1));
        name.add(list.get(list.size()-2));
        name.add(list.get(list.size()-3));

        request.getSession().setAttribute("name",name);
        request.getRequestDispatcher("recentbook.jsp").forward(request,response);
    }
}
