package com.byx.web.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.byx.domain.ResultInfo;
import com.byx.util.JsonUtils;

/**
 * 所有Servlet的基类
 */
public abstract class BaseServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// 获取请求uri
		String uri = request.getRequestURI();
		
		// 获取方法名
		String methodName = uri.substring(uri.lastIndexOf("/") + 1);
		
		try
		{
			// 获取方法对象
			Method method = this.getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			
			// 调用方法
			method.invoke(this, request, response);
		}
		catch (NoSuchMethodException e)
		{
			e.printStackTrace();
			responseFailResult(response, "接口不存在");
		}
		catch (Exception e)
		{
			e.printStackTrace();
			responseFailResult(response, "服务器内部错误");
		}
	}
	
	protected void responseJson(HttpServletResponse response, String json) throws IOException
	{
		response.setContentType("application/json; charset=utf-8");
		response.getWriter().print(json);
	}
	
	protected void responseSuccessResult(HttpServletResponse response, Object data) throws IOException
	{
		ResultInfo resultInfo = ResultInfo.success(data);
		responseJson(response, JsonUtils.toJson(resultInfo));
	}
	
	protected void responseFailResult(HttpServletResponse response, String errMsg) throws IOException
	{
		ResultInfo resultInfo = ResultInfo.fail(errMsg);
		responseJson(response, JsonUtils.toJson(resultInfo));
	}
	
	protected void responseResult(HttpServletResponse response, ResultInfo resultInfo) throws IOException
	{
		responseJson(response, JsonUtils.toJson(resultInfo));
	}
}
