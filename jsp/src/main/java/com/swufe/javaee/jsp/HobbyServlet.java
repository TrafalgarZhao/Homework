package com.swufe.javaee.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/hobbyFind")
public class HobbyServlet extends HttpServlet {
    private Map<String, List<String>> userHobby;
    @Override
    public void init() {
       userHobby = new HashMap<>();
       List<String> list= new ArrayList<>();
       list.add("skiing");
       list.add("knitting");
       userHobby.put("Bob", list);
       userHobby.put("Jim", list);
       userHobby.put("James", list);
       userHobby.put("Tom", list);
       userHobby.put("Fei", list);
       userHobby.put("Jone", list);
       userHobby.put("Fred", list);
       userHobby.put("Pradeep", list);
       userHobby.put("Philippe", list);

    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String hobby = request.getParameter("hobby");
       List<String> names = new ArrayList<>();
       userHobby.forEach((k, v) -> {
           if (v.contains(hobby)) {
               names.add(k);
           }
       });
       request.setAttribute("names", names);
       request.setAttribute("hobby", hobby);
       // Two JSPs have different UI styles.
       //  request.getRequestDispatcher("hobbyResult.jsp").forward(request, response);
       request.getRequestDispatcher("hobbyResult2.jsp").forward(request, response);
    }

}
