package com.allmsi.mis.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.allmsi.sys.util.HttpRequestUtil;

/**
 * 用户请求拦截器
 * 
 * @author sunnannan
 *
 */
public class LogInterceptor extends HandlerInterceptorAdapter {
	public Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String browser = HttpRequestUtil.getBrower(request);
		String browserVersion = HttpRequestUtil.getBrowserVersion(request);
		String servletPath = request.getServletPath();
		String mode = request.getMethod();
		int parameterCount = request.getParameterMap().size();
		String ipAddress = HttpRequestUtil.getIp(request);
		logger.info("客户端ip为:{},浏览器为:{},版本号为:{},访问程序路径为:{},请求方式:{},参数个数为:{}", ipAddress, browser, browserVersion,
				servletPath, mode, parameterCount);
		return true;
	}

}
