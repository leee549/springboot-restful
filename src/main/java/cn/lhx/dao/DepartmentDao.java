package cn.lhx.dao;

import cn.lhx.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lee549
 * @date 2020/3/14 21:18
 */
@Repository
public class DepartmentDao {
    private static List<Department> departments = null;

    static {
        departments = new ArrayList();

        departments.add(new Department(101,"采购部"));
        departments.add(new Department(102,"仓储部"));
        departments.add(new Department(103,"财务部"));
        departments.add(new Department(104,"技术部"));
        departments.add(new Department(105,"人力资源部"));

    }
    public List<Department> getDepartments(){
        return departments;
    }

    public Department getDepartmentById(Integer id){
        for (Department department:departments){
            if (department.getId().equals(id)){
                return department;
            }
        }
        return departments.get(id);
    }
}
