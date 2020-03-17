package cn.lhx;

import cn.lhx.dao.EmployeeDao;
import cn.lhx.entity.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot01WebApplicationTests {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    EmployeeDao employeeDao;


    @Test
    void contextLoads() {
        logger.trace("trace");
        logger.debug("debug");
        logger.info("info");
        logger.warn("warn");
        logger.error("error");
    }
    @Test
    void test(){
        //employeeDao.getEmployeeByName("AA");
        System.out.println("==="+employeeDao.getEmployeeById(1001));

    }



}
