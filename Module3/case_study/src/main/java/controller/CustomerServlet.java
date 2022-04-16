package controller;

import model.bean.Customer;
import model.bean.CustomerType;
import model.service.CustomerService;
import model.service.CustomerTypeService;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.CustomerTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends HttpServlet {
    CustomerService customerService = new CustomerServiceImpl();
    CustomerTypeService customerTypeService = new CustomerTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về một form thêm mới
                save(request,response);
                break;
            case "edit":
                updateCustomer(request,response);
                // chỉnh sửa
                break;
            case "delete":

                break;
            case "sort" :

                break;
            case "search":
                searchCustomer(request,response);
                break;
            default:

                // hien thi danh sách
        }
    }




    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về một form thêm mới
                showAddCustomerFrom(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                // chỉnh sửa
                break;
            case "delete":
                deleteCustomer(request,response);
                break;
            case "sort" :

                break;
            case "search":

                break;
            default:
                showCustomerList(request, response);
                // hien thi danh sách
        }
    }


    private void showAddCustomerFrom(HttpServletRequest request, HttpServletResponse response) {

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        request.setAttribute("customerTypeList", customerTypeService.listAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCustomerList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customerList", customerService.listAll());
        request.setAttribute("customerTypeList", customerTypeService.listAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void save(HttpServletRequest request, HttpServletResponse response) {
//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int typeID = Integer.parseInt(request.getParameter("customerTypeId"));
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(typeID,name,birthday,gender,idCard,phone,email,address);
        boolean check = customerService.add(customer);
        String mess = "Them moi thanh cong";
        if (!check) {
            mess = "them moi khong thanh cong";
        }
        request.setAttribute("mess", mess);
//        request.setAttribute("classList", customerService.listAll());
        try {
            request.getRequestDispatcher("/view/customer/create.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer existingCustomer = customerService.getById(id);
        List<CustomerType> customerTypeList = customerTypeService.listAll();
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
            request.setAttribute("customer", existingCustomer);
            request.setAttribute("customerTypeList", customerTypeList);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        int typeId = Integer.parseInt(request.getParameter("customerTypeId"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer book = new Customer(id, typeId, name, birthday, gender, idCard, phone, email, address);
        customerService.updadate(book);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.delete(id);
        List<Customer> customerList = customerService.listAll();
        List<CustomerType> customerTypeList = customerTypeService.listAll();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchEmail= request.getParameter("searchEmail");
        String searchTypeId = request.getParameter("searchTypeId");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        request.setAttribute("customerList", customerService.search(searchName,searchEmail,searchTypeId));
        request.setAttribute("customerTypeList", customerTypeService.listAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }
