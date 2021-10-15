package filter;
import annotation.WebRequest.WebRequestError;
import enunms.LoginPermissionEnum;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Field;

@WebRequestError
public class DetectionLoginFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request= (HttpServletRequest) servletRequest;
        HttpSession session=null;
        String url=null;
        //获取对象uri
        String requestURI = request.getRequestURI();
        if (LoginPermissionEnum.CHECK_MAP.contains(requestURI)){
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        session=request.getSession(false);
        if (session!=null){
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }
        Class<? extends DetectionLoginFilter> aClass = getClass();
        WebRequestError annotation = aClass.getAnnotation(WebRequestError.class);
        url=annotation.value();
        //拒绝其访问请求
        request.getRequestDispatcher(url).forward(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {

    }
}
