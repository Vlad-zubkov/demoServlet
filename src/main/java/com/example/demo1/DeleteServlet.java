package com.example.demo1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        String sid = request.getParameter("id");
        int id = Integer.parseInt(sid);

        int status = EmployeeRepository.delete(id);

        if (status > 0) {
            out.print("Record deleted successfully!");
            response.sendRedirect("viewServlet");
        } else {
            out.println("There is no record with such id!");
        }
        out.close();
    }
}
