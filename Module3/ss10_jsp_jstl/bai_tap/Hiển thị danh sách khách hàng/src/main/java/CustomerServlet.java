import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = {"/start"})
public class CustomerServlet extends HttpServlet {
       static List<Customer> customerList = new ArrayList<>();
       static {
            customerList.add(new Customer("Anh","01-01-2000","Da Nang"));
            customerList.add(new Customer("Em","01-01-2000","Da Nang"));
            customerList.add(new Customer("Long","01-01-2000","Da Nang"));
            customerList.add(new Customer("Hoang","01-01-2000","Da Nang"));
            customerList.add(new Customer("Nghia","01-01-2000","Da Nang"));
        }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/index.jsp");
        request.setAttribute("customerList",customerList);
        requestDispatcher.forward(request,response);
    }
}
