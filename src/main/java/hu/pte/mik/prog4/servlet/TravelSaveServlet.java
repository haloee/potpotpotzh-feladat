package hu.pte.mik.prog4.servlet;

import hu.pte.mik.prog4.entity.TravelEntity;
import hu.pte.mik.prog4.service.TravelService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
public class TravelSaveServlet extends HttpServlet {
    private final TravelService travelService = new TravelService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var nev = req.getParameter("nev");
        var tipus = req.getParameter("tipus");
        var leiras = req.getParameter("leiras");
        var orszag = req.getParameter("orszag");
        var travel = new TravelEntity(null, nev, tipus, leiras, orszag);
        travelService.save(travel);
        resp.sendRedirect(req.getContextPath() + "/travelList.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/travelSave.jsp").forward(req,resp);
    }
}
