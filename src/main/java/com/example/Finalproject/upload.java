package com.example.Finalproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/upload")
@MultipartConfig
public class upload extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        //String book=request.getParameter("book");
        String part2 =request.getParameter("book");
        Part part = request.getPart("IMG");
        Part part1 = request.getPart("TXT");

        //File file=new File("C:\\1\\"+part2+".txt");
        //if(!file.exists())
            //file.createNewFile();
        String p="C:\\IdeaProjects\\Finalproject\\src\\main\\webapp\\asset\\image\\"+part2+".jpg";
        part.write(p);
        //FileWriter f=new FileWriter("C:\\1\\"+part2+".txt");
        part1.write("C:\\1\\"+part2+".txt");
        FileWriter b=new FileWriter("C:\\Game.txt",true);
        b.write("\r\n"+part2);
        b.flush();
        b.close();


        response.sendRedirect("ok.html");
    }
}
