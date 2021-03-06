package com.oraclejava.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.oraclejava.model.Bbs;
import com.oraclejava.model.BbsDao;
import com.oraclejava.model.Member;
import com.oraclejava.model.MemberDao;

/**
 * Servlet implementation class GetBbsServlet
 */
@WebServlet("/GetBbs")
public class GetBbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBbsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json;charset=utf-8");
		
		Gson gson = new Gson();
		
		BbsDao dao = new BbsDao();
		List<Bbs> bbsList = dao.selectBbs();
		
		try(PrintWriter out = response.getWriter()) {
			out.println(gson.toJson(bbsList));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
