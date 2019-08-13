package com.tecsoon.ims.interceptor;
import java.util.Map;

import com.tecsoon.ims.entity.Admin;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
@SuppressWarnings("serial")
public class AdminInterceptor extends AbstractInterceptor {
	@Override
	// 管理员登录拦截器
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext context = invocation.getInvocationContext();
		@SuppressWarnings("rawtypes")
		Map session = context.getSession();
		Admin admin = (Admin) session.get("admin");
		if (admin != null) {
			return invocation.invoke();
		}
		context.put("message", "您还没有登录，请登录系统。");
		return Action.LOGIN;
	}
}