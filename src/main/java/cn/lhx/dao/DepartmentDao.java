package cn.lhx.dao;

import cn.lhx.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @author lee549
 * @date 2020/3/14 21:18
 */
@Repository
public class DepartmentDao {
    private static Map<Integer,Department> departments = null;

    static {
        departments = new HashMap<>();

        departments.put(101,new Department(101,"采购部"));
        departments.put(102,new Department(102,"仓储部"));
        departments.put(103,new Department(103,"财务部"));
        departments.put(104,new Department(104,"技术部"));
        departments.put(105,new Department(105,"人力资源部"));

    }
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    public Department getDepartmentById(Integer id){

        return departments.get(id);
    }
}
