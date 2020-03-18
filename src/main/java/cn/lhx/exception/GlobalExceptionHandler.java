package cn.lhx.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lee549
 * @date 2020/3/18 11:55
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 1.浏览器客户端都是返回json数据
     * @param e
     * @return
     */
    // @ResponseBody
    // @ExceptionHandler(UserNotExitException.class)
    // public Map<String,Object> UserNotExitHandler(Exception e){
    //     Map<String,Object> map = new HashMap<>();
    //     map.put("code","user.notexits");
    //     map.put("message",e.getMessage());
    //     return map;
    //
    // }

    /**
     * 2.有自适应效果，但没有定制数据；
     * @param e
     * @param request
     * @return
     */
    // @ExceptionHandler(UserNotExitException.class)
    // public String UserNotExitHandler(Exception e, HttpServletRequest request){
    //     Map<String,Object> map = new HashMap<>();
    //     //传入错误状态码
    //     /**
    //      * Integer statusCode = (Integer) request.
    //      * getAttribute("javax.servlet.error.status_code");
    //      */
    //     request.setAttribute("javax.servlet.error.status_code",500);
    //     map.put("code","user.notexits");
    //     map.put("message",e.getMessage());
    //     return "forward:/error";
    //
    // }

    /**
     * 3.有自适应效果，也有自定义数据
     * HttpStatus.INTERNAL_SERVER_ERROR = 500;
     * 当出现错误时，会发送/error请求，默认被ErrorMvcAutoConfiguration
     * 中的BasicErrorController做自适应处理（html页面，json数据），
     * 其中HttpStatus status = getStatus(request)是获取状态码Integer statusCode = (Integer) request
     * .getAttribute("javax.servlet.error.status_code");
     * 这两种处理方法都通过getErrorAttributes来获取数据，那我们重写该方法从request域中即可拿到数据
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(UserNotExitException.class)
    public String UserNotExitHandler(Exception e, HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        //传入错误状态码 4xx 5xx
        /**
         * Integer statusCode = (Integer) request.
         * getAttribute("javax.servlet.error.status_code");
         */
        request.setAttribute("javax.servlet.error.status_code", HttpStatus.INTERNAL_SERVER_ERROR);
        map.put("code","user.notexits");
        map.put("message","用户出错了");
        request.setAttribute("ext",map);
        return "forward:/error";

    }


}
