package servlet.counter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

@WebServlet(name = "RequestCounter", urlPatterns = "counter")
public class RequestCounter extends HttpServlet {
   private  AtomicInteger count;

    @Override
    public void init() throws ServletException {
        count = new AtomicInteger(0);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        try(PrintWriter writer = resp.getWriter()) {
            writer.write("<h1>" + "Count: " + count + "</h1>");
            writer.write("<div>");
            writer.write("Context Path: " + req.getContextPath());
            writer.write("<br>");
            writer.write("Local Addr: " + req.getLocalAddr());
            writer.write("</br>");
            writer.write("<br1>");
            writer.write("Method: " + req.getMethod());
            writer.write("</br1>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter writer = resp.getWriter()) {
            writer.write(Integer.toString(count.incrementAndGet()));
        }
    }
}
