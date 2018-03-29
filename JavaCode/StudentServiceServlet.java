/*Author = Monjura Afrin Rumi*/
/*
 * doPost() = read data from survey.html. Call StudentDAO class to store data in database.
 * Calls DataProcessor class to calculate mean and standard deviation if provided. 
 * Based on the values of Dataset, calls one of acknowledgement.jsp. Store beans in session
 * doGet() = receive id value from acknowledgement.jsp file. Call StudentDAO class to retrieve info of that
 * student from Database. Store student bean in session. Call student.jsp to show those info.
 */

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hw4.*;

/**
 * Servlet implementation class StudentServiceServlet
 */
@WebServlet("/StudentServiceServlet")
public class StudentServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentServiceServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String fname=request.getParameter("fname");
		String mname=request.getParameter("mname");
		String lname=request.getParameter("lname");
		
		String address=request.getParameter("address");
		String zip_code=request.getParameter("zip");
		String city=request.getParameter("city");
		
		String state=request.getParameter("state");
		String phone=request.getParameter("phone");
		String student_id=request.getParameter("student_id");
		
		String email=request.getParameter("email");
		String url=request.getParameter("url");
		String date=request.getParameter("date");
		
		String gmonth=request.getParameter("txtList");
		String gyear=request.getParameter("gyear");
		
		String[] like=request.getParameterValues("thingsliked");
		
		String interested=request.getParameter("interested");
		String recommend=request.getParameter("recommend");
		String num = request.getParameter("num");
		
		StudentDAO stdao=new StudentDAO();
		stdao.storetName(fname, mname, lname);
		stdao.StoreAddress(address, zip_code, city, state);
		stdao.StoreContact(phone, email, url);
		stdao.storeStudent(student_id, gmonth, gyear);
		stdao.storeOther(date, like, interested,recommend);
		int rs=stdao.insertData();
		if (rs==-1)
		{
			System.out.println("failed to insert");
		}
		String allId=stdao.getStudentIds();		
		StudentBean sb=new StudentBean();
		sb.setFname(fname);
		sb.setAllid(allId);			
		HttpSession session = request.getSession();
		session.setAttribute("studentbean", sb);
		//request.setAttribute("studentbean", sb);
		String forward="";
		
		DataBean db = new DataBean();
		if (num!=""){
			DataProcessor dp=new DataProcessor(num,db);		
			dp.mean_calculate();
			dp.std_calculate();																				
			if(db.getMean()>=90)
			{				
				forward = "/WEB-INF/WinnerAcknlowledgement.jsp";
			}
			else
			{
				forward = "/WEB-INF/SimpleAcknowledgement.jsp";
			}			
		}
		else
		{
			db.setMean(0);
			db.setStd(0);
			forward = "/WEB-INF/SimpleAcknowledgement.jsp";
		}
		session.setAttribute("databean", db);
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response); 
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id=request.getParameter("id");		
		StudentDAO stdao=new StudentDAO();
		StudentBean sb=new StudentBean();
		String student_check=stdao.getPersonalData(id, sb);
		HttpSession session = request.getSession();
		session.setAttribute("studentbean", sb);
		//request.setAttribute("studentbean", sb);
		String forward="";
		if (student_check=="No data")
		{
			forward = "/WEB-INF/NoSuchStudent.jsp";
		}
		else
		{
			forward = "/WEB-INF/Student.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
		dispatcher.forward(request, response);
	}
	
}