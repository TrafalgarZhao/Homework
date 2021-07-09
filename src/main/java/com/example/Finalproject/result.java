package com.example.Finalproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@WebServlet("/result")
public class result extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String name= request.getParameter("name");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        List<String> list=new ArrayList<>();

        out.println("<html><body>");
        String P="C:\\1\\"+name+".txt";
        File file=new File(P);
        Path path=file.toPath();
        try(Stream<String> lines= Files.lines(path)) {
            lines.forEach(line -> {
                String[] items = line.split("\n");
                out.println("<a>" + items[0] + "</a>"+"</br>");
            });
        }






        out.println("</body></html>");
    }
}
