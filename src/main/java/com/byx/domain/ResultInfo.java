package com.byx.domain;

/**
 * 返回给客户端的数据
 */
public class ResultInfo
{
	private final boolean flag;
	private final Object data;
	private final String errMsg;
	
	private ResultInfo(boolean flag, Object data, String errMsg)
	{
		this.flag = flag;
		this.data = data;
		this.errMsg = errMsg;
	}
	
	public static ResultInfo success(Object data)
	{
		return new ResultInfo(true, data, null);
	}
	
	public static ResultInfo fail(String errMsg)
	{
		return new ResultInfo(false, null, errMsg);
	}
	
	public boolean isFlag()
	{
		return flag;
	}
	public Object getData()
	{
		return data;
	}
	public String getErrMsg()
	{
		return errMsg;
	}

	@Override
	public String toString()
	{
		return "ResultInfo{" +
				"flag=" + flag +
				", data=" + data +
				", errMsg='" + errMsg + '\'' +
				'}';
	}
}
