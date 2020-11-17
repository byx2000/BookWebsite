package com.byx.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json工具类
 */
public class JsonUtils
{
	public static String toJson(Object obj)
	{
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
		try
		{
			return mapper.writeValueAsString(obj);
		} 
		catch (JsonProcessingException e)
		{
			e.printStackTrace();
			return null;
		}
	}
}
