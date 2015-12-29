/**
 * 
 */
package cn.edu.xmu.artworkauction.interceptor;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.edu.xmu.artworkauction.entity.User;
import cn.edu.xmu.artworkauction.utils.Login;
import cn.edu.xmu.artworkauction.utils.ResultTypeEnum;
import cn.edu.xmu.artworkauction.utils.SessionHelper;

/**
 * @author Administrator
 *
 */
public class LoginAnnotationInterceptor extends HandlerInterceptorAdapter{
	final Logger logger = LoggerFactory.getLogger(getClass());
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

	    HandlerMethod handler2 = (HandlerMethod) handler;
	    Login login = handler2.getMethodAnnotation(Login.class);

	    if (null == login) {
	        return true;
	    }
	    HttpSession session = request.getSession();
	    User user = (User) session.getAttribute(SessionHelper.UserHandler);
	    if (null == user) {
	        if (login.value() == ResultTypeEnum.page) {
	            request.getRequestDispatcher("/login.jsp?oprst=false&opmsg=请登录!").forward(request, response);
	        } else if (login.value() == ResultTypeEnum.json) {
	            response.setCharacterEncoding("utf-8");
	            response.setContentType("text/html;charset=UTF-8");
	            OutputStream out = response.getOutputStream();
	            PrintWriter pw = new PrintWriter(new OutputStreamWriter(out,"utf-8"));
	            pw.println("{\"result\":false,\"code\":11,\"errorMessage\":\"您未登录,请先登录\"}");
	            pw.flush();
	            pw.close();
	        }
	        return false;
	    }
	       return true;
	    }
	}
