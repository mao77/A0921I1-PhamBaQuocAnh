import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ProductDiscountCalculatorServlet",urlPatterns = "/display-discount")
public class ProductDiscountCalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        float listPrice = Float.parseFloat(request.getParameter("listPrice"));
        float discountPercent = Float.parseFloat(request.getParameter("discountPercent"));
        String productDescription = request.getParameter("productDescription");

        float discountAmount = (float) (listPrice * discountPercent * 0.01);
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>Product: " + productDescription + "</h1>");
        writer.println("<h1>listPrice: " + listPrice + "</h1>");
        writer.println("<h1>discountPercent: " + discountPercent + "%</h1>");
        writer.println("<h1>discountAmount: " + discountAmount + "</h1>");
        writer.println("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
