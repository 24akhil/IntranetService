package com.softech.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.softech.dao.DBHelper;
import com.softech.dao.ProfileDAO;

/**
 * Servlet implementation class FetchCities
 */
@WebServlet("/FetchCitiesJSON")
public class FetchCitiesJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchCitiesJSON() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		System.out.println("vbnm");
		ResultSet rs=ProfileDAO.fetchCities(request.getParameter("stateid"));
	    ArrayList <JSONObject> json=DBHelper.getFormatedResult(rs);
	    out.println(json);}

}

