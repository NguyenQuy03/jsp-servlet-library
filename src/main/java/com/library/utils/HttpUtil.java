package com.library.utils;

import java.io.BufferedReader;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class HttpUtil {
	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}
	
	public <E> E toModel(Class<E> eclass) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(value, eclass);
		} catch (IOException e) {
			return null;
		}
	}
	
	public static HttpUtil of(BufferedReader reader) {
		StringBuilder builder = new StringBuilder();
		
		try {
			String line;
			while((line = reader.readLine()) != null) {
				builder.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		return new HttpUtil(builder.toString());
	}
}
