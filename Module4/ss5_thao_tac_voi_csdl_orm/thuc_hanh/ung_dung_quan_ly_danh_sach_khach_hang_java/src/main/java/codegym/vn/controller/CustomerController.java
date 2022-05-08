package codegym.vn.controller;

import codegym.vn.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
//    // setter injection: cách triển khai ngắn gọn, hay dùng
//    @Autowired
////    @Qualifier("studentServiceImpl")
//    private CustomerService service;
    // triển khai setter injection đầy đủ
//    @Autowired
//    @Qualifier("studentService1")
//    public void setService(StudentService service) {
//        this.service = service;
//    }

    @GetMapping(value = "/list"
//            ,headers = {"Content-Type=text/html","Accept=application/xml"}
            )
    public String list(Model model) {
//        List<Customer> customers = service.findAll();
//        model.addAttribute("customers", customers);
        return "customer/list";
    }

//    @GetMapping("/view/{student_id}")
//    public String viewStudent(@PathVariable("student_id") String id, Model model) {
//        Student student = service.findById(id);
//        model.addAttribute("student", student);
//        return "/student/view";
//    }

    // Dùng formatter
//    @GetMapping("/view/{customer_id}")
//    public String viewStudent(@PathVariable("customer_id") Customer customer, Model model) {
//        model.addAttribute("customer", customer);
//        return "/customer/view";
//    }
//
//    @GetMapping("/view")
//    public String viewCustomerByParam(@RequestParam("id") String id, Model model) {
//        Customer customer = service.findById(id);
//        model.addAttribute("customer", customer);
//        return "/customer/view";
//    }
//
//    @GetMapping("/create")
//    public String viewCreate(Model model) {
//        String[] classNames = {"A0921I1", "A1021I1", "A1121I1"};
//        model.addAttribute("student", new Student());
//        model.addAttribute("classNames", classNames);
//        return "/student/create";
//    }
//
//    @PostMapping("/create")
//    public String create(@ModelAttribute("student") Student student) {
//        service.create(student);
//        return "redirect:/student/list";
//    }
//
//    @GetMapping("/update/{student_id}")
//    public String showUpdate(@PathVariable("student_id") Student student, Model model) {
//        model.addAttribute("student", student);
//        return "/student/create";
//    }
//
//    @GetMapping("/index")
//    public String index() {
//        return "/student/index";
//    }
}
