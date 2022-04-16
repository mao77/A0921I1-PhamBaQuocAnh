package controller;

import model.bean.*;
import model.repository.ServiceTypeRepository;
import model.service.RentypeService;
import model.service.ServiceService;
import model.service.ServiceTypeService;
import model.service.impl.RentTypeServiceImpl;
import model.service.impl.ServiceServiceImpl;
import model.service.impl.ServiceTypeServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet",urlPatterns = "/services")
public class ServiceServlet extends HttpServlet {
    ServiceService serviceService = new ServiceServiceImpl();
    ServiceTypeService serviceTypeService = new ServiceTypeServiceImpl();
    RentypeService rentypeService = new RentTypeServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                // trả về một form thêm mới
                addService(request,response);
                break;
            case "edit":
                updateService(request,response);
                // chỉnh sửa
                break;
            case "delete":

                break;
            case "sort" :

                break;
            case "search":
                searchService(request,response);
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
                showAddServiceFrom(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                // chỉnh sửa
                break;
            case "delete":
                deleteService(request,response);
                break;
            case "sort" :

                break;
            case "search":

                break;
            default:
                showServiceList(request, response);
                // hien thi danh sách
        }
    }




    private void showServiceList(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/list.jsp");
        request.setAttribute("serviceList", serviceService.listAll());
        request.setAttribute("serviceTypeList", serviceTypeService.listAll());
        request.setAttribute("rentTypeList", rentypeService.listAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void showAddServiceFrom(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/create.jsp");
        request.setAttribute("serviceTypeList", serviceTypeService.listAll());
        request.setAttribute("rentTypeList", rentypeService.listAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void addService(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        int rentTypeId = Integer.parseInt( request.getParameter("rentTypeId"));
        int serviceTypeId = Integer.parseInt( request.getParameter("serviceTypeId"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        double poolArea = Double.parseDouble(request.getParameter("poolArea"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        Service service = new Service(name,area,cost,maxPeople,rentTypeId,serviceTypeId,standardRoom,descriptionOtherConvenience,poolArea,numberOfFloors);
        boolean check = serviceService.add(service);
        String mess = "Them moi thanh cong";
        if (!check) {
            mess = "them moi khong thanh cong";
        }
        request.setAttribute("mess", mess);
//        request.setAttribute("serviceList", serviceService.listAll());
        try {
            request.getRequestDispatcher("/view/service/create.jsp").forward(request, response);
        } catch (IOException | ServletException e) {
            e.printStackTrace();
        }
    }
    private void searchService(HttpServletRequest request, HttpServletResponse response) {
        String searchName = request.getParameter("searchName");
        String searchServiceTypeId= request.getParameter("searchServiceTypeId");
        String searchRentTypeId = request.getParameter("searchRentTypeId");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("view/service/list.jsp");
        request.setAttribute("serviceList", serviceService.search(searchName,searchRentTypeId,searchServiceTypeId));
        request.setAttribute("serviceTypeList", serviceTypeService.listAll());
        request.setAttribute("rentTypeList", rentypeService.listAll());
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
        Service  existingService = serviceService.getById(id);
        List<ServiceType> serviceTypeList = serviceTypeService.listAll();
        List<RentType> rentTypeList = rentypeService.listAll();
        try{
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/edit.jsp");
            request.setAttribute("existingService", existingService);
            request.setAttribute("serviceTypeList", serviceTypeList);
            request.setAttribute("rentTypeList", rentTypeList);
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void updateService(HttpServletRequest request, HttpServletResponse response) {

    }
    private void deleteService(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        serviceService.delete(id);
        List<Service> serviceList = serviceService.listAll();
        List<ServiceType> serviceTypeList = serviceTypeService.listAll();
        List<RentType> rentTypeList = rentypeService.listAll();
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        try {
            RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
