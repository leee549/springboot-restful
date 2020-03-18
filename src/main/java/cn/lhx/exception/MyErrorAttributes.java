package cn.lhx.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

/**
 * @author lee549
 * @date 2020/3/18 21:41
 */
@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
    @Override
    /**
     * RequestAttributes.SCOPE_REQUEST = 0
     */
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
        Map<String,Object> map= super.getErrorAttributes(webRequest, includeStackTrace);
        map.put("company","bilibili");
        Map<String,Object> ext = (Map<String, Object>) webRequest
                                 .getAttribute("ext", RequestAttributes.SCOPE_REQUEST);
        map.put("ext",ext);
        return map;
    }
}
