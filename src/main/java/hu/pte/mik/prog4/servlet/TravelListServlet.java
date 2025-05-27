package hu.pte.mik.prog4.servlet;
import hu.pte.mik.prog4.service.TravelService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
public class TravelListServlet extends HttpServlet {
    private final TravelService travelService = new TravelService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("travels", this.travelService.listAll());
        req.getRequestDispatcher("/travelList.jsp")
                .forward(req, resp);
    }
}
