package controller;

import model.bean.*;
import model.service.DivisionService;
import model.service.EducationDegreeService;
import model.service.EmployeeService;
import model.service.PositionService;
import model.service.impl.DivisionServiceImpl;
import model.service.impl.EducationDegreeServiceImpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.PositionServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employees")
public class EmployeeServlet extends HttpServlet {
    EmployeeService employeeService = new EmployeeServiceImpl();
    PositionService positionService = new PositionServiceImpl();
    DivisionService divisionService = new DivisionServiceImpl();
    EducationDegreeService educationDegreeService = new EducationDegreeServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về một form thêm mới
                addEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request,response);
                // chỉnh sửa
                break;
            case "delete":

                break;
            case "sort":

                break;
            case "search":
                searchEmployee(request,response);
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
                showAddEmployeeFrom(request, response);
                break;
            case "edit":
                showEditForm(request,response);
                // chỉnh sửa
                break;
            case "delete":
                deleteEmployee(request,response);
                break;
            case "sort":

                break;
            case "search":

                break;
            default:
                showEmployeeList(request, response);
                // hien thi danh sách
        }
    }



    private void showEmployeeList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        request.setAttribute("employeeList", employeeService.listALl());
        request.setAttribute("positionList", positionService.listAll());
        request.setAttribute("educationDegreeList", educationDegreeService.listAll());
        request.setAttribute("divisionList", divisionService.lisstAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAddEmployeeFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        request.setAttribute("positionList", positionService.listAll());
        request.setAttribute("educationDegreeList", educationDegreeService.listAll());
        request.setAttribute("divisionList", divisionService.lisstAll());
        request.setAttribute("employeeList", employeeService.listALl());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email,
                address, positionId, educationDegreeId, divisionId);
        boolean check = employeeService.add(employee);
        String mess = "Them moi thanh cong";
        if (!check) {
            mess = "them moi khong thanh cong";
        }
        request.setAttribute("mess", mess);
//        request.setAttribute("serviceList", serviceService.listAll());
        try {
            request.getRequestDispatcher("/view/employee/create.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchPositionId= request.getParameter("searchPositionId");
        String searchEducationDegreeId = request.getParameter("searchEducationDegreeId");
        String searchDivisionId = request.getParameter("searchDivisionId");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/employee/list.jsp");

        request.setAttribute("employeeList", employeeService.search(searchName,searchPositionId,searchEducationDegreeId,searchDivisionId));
        request.setAttribute("positionList", positionService.listAll());
        request.setAttribute("educationDegreeList", educationDegreeService.listAll());
        request.setAttribute("divisionList", divisionService.lisstAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee  existingEmployee = employeeService.getById(id);
        List<Position> positionList = positionService.listAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.listAll();
        List<Division> divisionList = divisionService.lisstAll();
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
            request.setAttribute("existingEmployee", existingEmployee);
            request.setAttribute("positionList", positionList);
            request.setAttribute("educationDegreeList", educationDegreeList);
            request.setAttribute("divisionList", divisionList);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double  salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int  educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));

        Employee book = new Employee(id, name, birthday, idCard, salary, phone, email, address,
                positionId,educationDegreeId,divisionId);
        employeeService.update(book);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.delete(id);
        List<Employee> employeeList = employeeService.listALl();
        List<Position> positionList = positionService.listAll();
        List<EducationDegree> educationDegreeList = educationDegreeService.listAll();
        List<Division> divisionList = divisionService.lisstAll();
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("divisionList", divisionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }


