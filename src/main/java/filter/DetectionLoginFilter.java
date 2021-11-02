package filter;
import annotation.WebRequest.WebRequestError;
import enums.LoginPermissionEnum;
import pojo.bean.Organizer;
import pojo.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author DAHUANG
 */
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
        /**
         * 在session中获得的对象如果是Organizer类
         */
        if (session!=null&&(session.getAttribute("nowOrg")!=null)){
            if (!LoginPermissionEnum.CHECK_NOT_MAP_ORG.contains(requestURI)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        /**
         * 在session中获得的对象如果是User类
         */
        if (session!=null&&(session.getAttribute("nowUser")!=null)){
            if (!LoginPermissionEnum.CHECK_NOT_MAP_USER.contains(requestURI)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
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
