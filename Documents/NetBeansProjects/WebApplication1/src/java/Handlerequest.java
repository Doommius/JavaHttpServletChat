/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mark-
 */
@WebServlet(urlPatterns = {"/"})
public class Handlerequest extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private final AtomicLong count = new AtomicLong(0);
    public long getCount() { return count.get(); }
    private final ArrayList<String> chatmsg = new ArrayList<>();
    

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                //if (request.getParameter("input") == "null");
                if ("" == (request.getParameter("input"))) {
            } else if (null == (request.getParameter("input"))) { ;
            } else{
                    chatmsg.add(new SimpleDateFormat("yyyy.MM.dd  HH.mm.ss").format(new Date())+"  "+request.getParameter("input"));
            }
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet NewServlet</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>");
                out.println("Counter1 = "+count.incrementAndGet()+"<br>");
                out.println("Chat input is "+request.getParameter("input")+"<br>");
                out.println("<div style=\"height:550px;width:100%;border:1px solid #ccc;font:16px/26px Georgia, Garamond, Serif;overflow:auto;\">");
                for(int i = 0; i < chatmsg.size(); i++) {   
                    out.print(chatmsg.get(i)+"<br>");
                }  
                out.println("</div>");
                out.println("<form action=\"WebApplication1\">");
                out.println("Message: <input type=\"text\" name=\"input\" autofocus=\"autofocus\" ><br>");
                out.println("<input type=\"submit\" value=\"Submit\">");
                out.println("</form>");
                out.println("<A NAME=\"end\">");
                out.println("</h1>");
                out.println("</body>");
                out.println("</html>");
               
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>



}
