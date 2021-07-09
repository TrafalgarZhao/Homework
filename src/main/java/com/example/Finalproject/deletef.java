package com.example.Finalproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@WebServlet("/deletef")
public class deletef extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List list=new ArrayList();
        File f=new File("C:\\Game.txt");
        Path path=f.toPath();
        try(Stream<String> lines= Files.lines(path)) {
            lines.forEach(line -> {
                String[] items = line.split(" ");
                list.add(items[0]);
            });
        }
        request.getSession().setAttribute("list",list);
        request.getRequestDispatcher("delete.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String book=request.getParameter("book");
        List<String> list = new ArrayList<String>();
        //try
        //{
            File file = new File("C:\\Game.txt");
            if (file.isFile() && file.exists())
            {
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file));
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;

                while ((lineTxt = bufferedReader.readLine()) != null)
                {
                    if(lineTxt.equals(book)){
                    }else {
                        list.add(lineTxt);
                    }
                }
                FileWriter f=new FileWriter("C:\\Game.txt");
                int i=0;
                while(i<=list.size()-1){
                    f.write(list.get(i)+"\r\n");
                    i++;
                }
                f.close();
                bufferedReader.close();
                read.close();
                response.sendRedirect("success.html");
            }

            else
            {
                response.sendRedirect("wrong.html");
            }
        //}
        //catch (Exception e)
        //{
          //  response.sendRedirect("wrong.html");
        //}

    }

}
