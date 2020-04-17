/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author RoshDaboss
 */
public class zip extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet zip</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet zip at " + request.getContextPath() + "</h1>");
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
    @SuppressWarnings("UnnecessaryContinue")
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String str = request.getParameter("zipcode");
        Cookie cooksie = new Cookie("AppCookie",str);
        cooksie.setMaxAge(6000);
        response.addCookie(cooksie);
        Cookies.inputC(cooksie);
        Cookies.printC();
        for(int i =0;i<str.length();i++){
            if(str.substring(i,i+1).equals("1")||str.substring(i,i+1).equals("2")||str.substring(i,i+1).equals("3")||str.substring(i,i+1).equals("4")||str.substring(i,i+1).equals("5")||str.substring(i,i+1).equals("6")||str.substring(i,i+1).equals("7")||str.substring(i,i+1).equals("8")||str.substring(i,i+1).equals("9")||str.substring(i,i+1).equals("0")){
                continue;
            }
            else{
                RequestDispatcher rd = request.getRequestDispatcher("WrongZip.html");
                rd.forward(request, response);
            }
        }
        Blogs blog = new Blogs();
        String [] convo = blog.getConversation(Integer.valueOf(request.getParameter("zipcode")));
        int lines = 0;
        for(String s : convo){
            lines++;
            if(s==null){
                break;
            }
        }
        PrintWriter pw = response.getWriter();
        if(convo[0]==null){
            pw.println("<link href=\"main.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"");
        pw.println("<link href=\"https://fonts.googleapis.com/css?family=Quicksand:300,500\" rel=\"stylesheet\">");
            pw.println("<form action = 'zip.html'> ");
            pw.println("<center>");
            pw.println("<table>"); 
            pw.println("<tr><td>No Emergencies</td></tr>");
            pw.println("<tr><td><input type = 'submit' value = 'Back'></td></tr>");
            pw.println("</table>");
            pw.println("</center>");
            pw.println("</form>");
        }
        else{
        pw.println("<link href=\"main.css\" rel=\"stylesheet\" type=\"text/css\">\n" +
"");
        pw.println("<link href=\"https://fonts.googleapis.com/css?family=Quicksand:300,500\" rel=\"stylesheet\">");
        pw.println("<form action = 'zip.html'> ");
        pw.println("<center>");
        pw.println("<table>");
        for(int i =0;i<lines;i++){
            if(convo[i]!=null){
                pw.println("<tr><td>"+convo[i]+"</td></tr>");
            }
        }
        pw.println("<tr><td><input type = 'submit' value = 'Back'></td></tr>");
        pw.println("</table>");
        pw.println("</center>");
        pw.println("</form>");
        }
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
