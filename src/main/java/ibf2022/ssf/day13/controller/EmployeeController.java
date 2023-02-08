package ibf2022.ssf.day13.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import ibf2022.ssf.day13.model.Employee;
import ibf2022.ssf.day13.repository.EmployeeRepo;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepo empRepo;

    @GetMapping("/home")
    public String employeeListPage(Model model) {

        List<Employee> employees = empRepo.findAll(); // calls the findAll method in the repo

        model.addAttribute("employeesList", employees);
        return "employeesList";
    }

    @GetMapping("/addNew")
    public String addPage(Model model) {

        Employee emp = new Employee();

        model.addAttribute("addEmployee", emp);
        return "employeeAdd";
    }

    @PostMapping("/addNew") // @valid is to ensure that the info entered in the employeeAdd form is correct
    public String addEmployee(@Valid @ModelAttribute("addEmployee") Employee employeeForm,
            BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "employeeAdd";
        }

        Boolean bResult = false;
        bResult = empRepo.save(employeeForm);

        return "redirect:/employees/home";
    }

    @GetMapping("/deleteEmployee/{email}")
    public String deleteEmployee(@PathVariable("email") String email) {

        Employee emp = empRepo.findByEmailId(email);

        Boolean bResult = empRepo.delete(emp);

        return "redirect:/employees/home";
    }

    @GetMapping("/updateEmployee/{email}")
    public String updateEmployee(@PathVariable("email") String email, Model model) {

        // This process does not update but CREATES new emp object
        Employee emp = empRepo.findByEmailId(email);
        model.addAttribute("addEmployee", emp);

        return "employeeUpdate";
    }

    @PostMapping("/updateEmployee")
    public String updateEmployeeProcess(@ModelAttribute("employee") Employee emp, BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "employeeUpdate";
        }

        Boolean bResult = empRepo.updateEmployee(emp);

        return "redirect:/employees/home";
    }
}
