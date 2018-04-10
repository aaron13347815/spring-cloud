//package com.yuecheng.base.filter;
//
//import javax.servlet.http.HttpServletRequest;
//
//import com.netflix.zuul.ZuulFilter;
//import com.netflix.zuul.context.RequestContext;
//import com.netflix.zuul.exception.ZuulException;
//
//public class AccessTokenFilter extends ZuulFilter {
//
//	@Override
//	public Object run() throws ZuulException {
//		RequestContext ctx = RequestContext.getCurrentContext();
//        HttpServletRequest request = ctx.getRequest();
//
//        Object accessToken = request.getParameter("accessToken");
//        if(accessToken == null) {
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            return null;
//        }
//        return null;
//	}
//
//	@Override
//	public boolean shouldFilter() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public int filterOrder() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public String filterType() {
//		// TODO Auto-generated method stub
//		return "pre";
//	}
//
//}
