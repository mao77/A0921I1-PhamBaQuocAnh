package com.codegym.controller;

import com.codegym.entity.service.Service;
import com.codegym.entity.service.ServiceRentType;
import com.codegym.entity.service.ServiceType;
import com.codegym.repository.service.ServiceRentTypeRepository;
import com.codegym.repository.service.ServiceTypeRepository;
import com.codegym.service.service.ServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    private ServiceServiceImpl serviceService;

    @Autowired
    private ServiceRentTypeRepository serviceRentTypeRepository;

    @Autowired
    private ServiceTypeRepository serviceTypeRepository;

    @ModelAttribute
    public List<ServiceRentType> serviceRentTypeList() {
        List<ServiceRentType> serviceRentTypeList = serviceRentTypeRepository.findAll();
        return serviceRentTypeList;
    }

    @ModelAttribute
    public List<ServiceType> serviceTypeList() {
        List<ServiceType> serviceTypeList = serviceTypeRepository.findAll();
        return serviceTypeList;
    }

    @GetMapping("")
    public String listService(Model model,
                              @PageableDefault(size = 2) Pageable pageable) {
        Page<Service> listService = serviceService.listService(pageable);
        model.addAttribute("listService", listService);
        return "service/list";
    }

    @GetMapping("/detail")
    public String detailService(Model model,
                                @RequestParam int id) {
        Service service = serviceService.getServiceById(id);
        model.addAttribute("service", service);
        return "service/detail";
    }

    @GetMapping("/create")
    public String createServiceView(Model model) {
        model.addAttribute("service", new Service());
        return "service/create";
    }

    @PostMapping("/create")
    public String createService(@ModelAttribute Service service) {
        serviceService.createService(service);
        return "redirect:/service";
    }

    @GetMapping("/edit")
    public String editServiceView(Model model,
                                  @RequestParam int id) {
        Service service = serviceService.getServiceById(id);
        model.addAttribute("service", service);
        return "/service/edit";
    }

    @PostMapping("/edit")
    public String editService(@ModelAttribute Service service) {
        serviceService.editService(service);
        return "redirect:/service";
    }

    @GetMapping("delete")
    public String deleteService(@RequestParam int id) {
        serviceService.deleteServiceById(id);
        return "redirect:/service";
    }

    @GetMapping("/search")
    public String searchServiceView() {
        return "/service/search";
    }

    @PostMapping("/search")
    public String searchService(@RequestParam double searchCost1,
                                @RequestParam double searchCost2,
                                @PageableDefault(size = 2) Pageable pageable,
                                Model model) {
        Page<Service> listService = serviceService.findServicesByCostBetween(searchCost1,searchCost2,pageable);
        model.addAttribute("listService", listService);
        return "/service/list";
    }
}
