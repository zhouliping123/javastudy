package com.example.demoeurekazuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class MyErrorFilter  extends ZuulFilter {
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		System.out.println("MyErrorFilter");
		return null;
	}

	@Override
	public String filterType() {
		return "error";
	}

	@Override
	public int filterOrder() {

		return 0;
	}
}
