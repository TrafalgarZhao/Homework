package com.swufe.javaee.request_response;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/uploadImage")

@MultipartConfig
public class UploadImageServelt extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getPart("Upload").write("D:\\java-ee-swufe-master\\03_more_servlet\\request-response\\src\\main\\resources");
        response.sendRedirect("Success.html");

    }
}
