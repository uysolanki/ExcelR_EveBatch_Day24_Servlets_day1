

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MultiplicationServlet
 */
@WebServlet("/MultiplicationServlet")
public class MultiplicationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MultiplicationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		ServletContext context=getServletContext();
		String s1=context.getInitParameter("appName");
		pw.println("Application Name is "+s1+"<br>");
		
		String s2=context.getInitParameter("developerName");
		pw.println("Developer Name is "+s2+"<br>");
		
		String s3=context.getInitParameter("ChiefArchitech");
		pw.println("Chief Arhchitech is "+s3+"<br>");
		
		String s4=context.getInitParameter("ChiefArchitechContact");
		pw.println("Chief Architech Contact "+s4+"<br>");
		
		ServletConfig config= getServletConfig();
		String borderSize=config.getInitParameter("bordersize");
		
		String servletName=config.getServletName();
		pw.println("Servlet Name "+servletName);
		//int n1=Integer.parseInt(request.getParameter("t1"));
		
		HttpSession session=request.getSession(false);
		int n1=(Integer) session.getAttribute("n1");
		
		Enumeration<String> parameters=config.getInitParameterNames();
		while(parameters.hasMoreElements())
			pw.print(parameters.nextElement()+",");
		
		pw.println("<table border="+borderSize+">");
		for(int i=1;i<=10;i++)
		{
			pw.println("<tr>");
			
			pw.println("<td>");
			pw.println(n1);
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("X");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println(i);
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println("=");
			pw.println("</td>");
			
			pw.println("<td>");
			pw.println(n1*i);
			pw.println("</td>");
			
			pw.println("</tr>");
		}
		
		pw.println("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
