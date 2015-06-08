package com.example.fsw.utils;

import com.example.fsw.beans.Request;
import com.example.fsw.beans.Response;

public class UtilLogger {
	
	public static final void log(Request req) {
		System.out.println("Request(" + req.getName() + "): " + req.getValue());
	}

	public static final void log(Response req) {
		System.out.println("Response(" + req.getCode() + "): "
				+ req.getResult());
	}
}
