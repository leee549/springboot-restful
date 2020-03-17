package cn.lhx.controller;

import cn.lhx.dao.DepartmentDao;
import cn.lhx.dao.EmployeeDao;
import cn.lhx.entity.Department;
import cn.lhx.entity.Employee;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

/**
 * @author lee549
 * @date 2020/3/16 13:34
 */
@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.listAll();
        model.addAttribute("emps",employees);

        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        employeeDao.save(employee);
        System.out.println("保存的员工为："+employee);
        return "redirect:/emps";
    }
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id , Model model){
        Employee employee = employeeDao.getEmployeeById(id);

        model.addAttribute("emp",employee);

        Collection<Department> departments = departmentDao.getDepartments();

        model.addAttribute("depts",departments);
        return "emp/add";
    }
    @PutMapping("/emp")
    public String update(Employee employee){
        employeeDao.save(employee);
        System.out.println("修改+++++"+employee);
        return "redirect:/emps";
    }
    @DeleteMapping("/emp/{id}")
    public String delete(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }


}
