package controllers;


import models.Branch;
import models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import services.IBranchService;
import services.IEmployeeService;
import validate.ValidateEmployeeCode;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    @Autowired
    private IEmployeeService employeeService;

    @Autowired
    private IBranchService branchService;

    @Autowired
    private ValidateEmployeeCode validateEmployeeCode;

    @ModelAttribute("branches")
    public Iterable<Branch> branches() {
        return branchService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView home(@PageableDefault(sort = "age",direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("index");
        Page<Employee> employees = employeeService.findAll(pageable);
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/findByName")
    public ModelAndView findByName(@RequestParam String findName) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("employees", employeeService.findAllByName(findName));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("employee", new Employee());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView create(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        validateEmployeeCode.validate(employee,bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("create");
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("redirect:/home");
            return modelAndView;
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        Employee employee = employeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public ModelAndView edit(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("edit");
        } else {
            employeeService.save(employee);
            ModelAndView modelAndView = new ModelAndView("redirect:/home");
            return modelAndView;
        }
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable Integer id){
        employeeService.delete(employeeService.findById(id).get());
        return new ModelAndView("redirect:/home");
    }


    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable int id){
        Employee employee = employeeService.findById(id).get();
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("employee",employee);
        return modelAndView;
    }
}
