package cn.lhx.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author lee549
 * @date 2020/3/14 21:05
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    //private String password;
    private String email;
    private Integer sex;
    private Department department;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
}
