package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.jws.WebParam;
import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping("home")
    public ModelAndView showList(){
        List<Customer> customerList=customerService.findAll();
        ModelAndView modelAndView=new ModelAndView("/view");
        modelAndView.addObject("customers",customerList);
        return modelAndView;
    }

    @RequestMapping("create-customer")
    public ModelAndView createForm(){
        ModelAndView modelAndView=new ModelAndView("/create");
        modelAndView.addObject("customer",new Customer());
        return modelAndView;
    }

    @PostMapping("create-customer")
    public ModelAndView create(@ModelAttribute Customer customer){
        ModelAndView modelAndView =new ModelAndView("/create");
        customerService.save(customer);
        modelAndView.addObject("message","thanh cong");
        return modelAndView;
    }

    @RequestMapping("edit/{id}")
    public ModelAndView editForm(@PathVariable Long id){
        Customer customer=customerService.findById(id);
        ModelAndView modelAndView=new ModelAndView("/edit");
        modelAndView.addObject("customer",customer);
        return modelAndView;
    }

    @PostMapping("edit")
    public ModelAndView edit(@ModelAttribute Customer customer){
        customerService.update(customer);
        ModelAndView modelAndView=new ModelAndView("/edit");
        modelAndView.addObject("message","thanh cong");
        return modelAndView;
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id,RedirectAttributes redirectAttributes){
        customerService.remove(id);
        redirectAttributes.addFlashAttribute("message","delete complete");
        return "redirect:/home";
    }
}
