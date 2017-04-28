package org.yan.mewtwo.interceptor;

import org.yan.mewtwo.config.Constants;
import org.yan.mewtwo.model.Client;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;

public class ClientInterceptor implements Interceptor {

	@Override
	public void intercept(Invocation inv) {
		Controller c = inv.getController();
		Client client = c.getSessionAttr(Constants.SESSION_CLIENT_KEY);
		if (client == null) {
			String userAgent = c.getRequest().getHeader("User-Agent");
			client = Client.judge(userAgent);
			c.setSessionAttr(Constants.SESSION_CLIENT_KEY, client);
		}
		
		inv.invoke();
	}
	
}
