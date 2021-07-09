package com.example.Finalproject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/registered")
public class registered extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user=req.getParameter("inputName");
        String pwd=req.getParameter("inputPassword");
        FileWriter file=new FileWriter("C:\\2.txt",true);
        file.write("\r\n"+user+" "+pwd);
        file.flush();
        file.close();
        resp.sendRedirect("rig-success.html");
    }
}
