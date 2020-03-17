package cn.lhx.dao;

import cn.lhx.entity.Department;
import cn.lhx.entity.Employee;
import cn.lhx.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author lee549
 * @date 2020/3/14 21:18
 */
@Repository
public class EmployeeDao {
    private static List<Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new ArrayList<>();
        employees.add(new Employee(1001, "AA", "123@test.com", 0, new Department(101, "采购部"), new Date()));
        employees.add(new Employee(1002, "BB", "222@test.com", 1, new Department(102, "仓储部"), new Date()));
        employees.add(new Employee(1003, "CC", "222@test.com", 0, new Department(103, "财务部"), new Date()));
        employees.add(new Employee(1004, "DD", "222@test.com", 0, new Department(104, "技术部"), new Date()));
        employees.add(new Employee(1005, "EE", "222@test.com", 1, new Department(105, "人力资源部"), new Date()));

    }

    public List<Employee> listAll() {
        return employees;
    }

    public Employee getEmployeeById(Integer id) {
        for (Employee employee:employees){
            if (employee.getId().equals(id)){
                return employee;
            }
        }
        return employees.get(id);
    }

    public Employee getEmployeeByName(String name) {
        for (Employee employee:employees) {
            //Employee employee = employees.get(i);
            if (employee.getName().equals(name)) {
                System.out.println(employee);
                return employee;
            }
        }
        return null;
    }
    private static Integer initId = 1006;

    public void save(Employee employee){
        if (employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.add(employee);

    }


}
