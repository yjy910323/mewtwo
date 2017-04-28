package org.yan.mewtwo.controller;

import org.yan.mewtwo.config.Constants;
import org.yan.mewtwo.model.Client;

import com.jfinal.core.Controller;

public class BaseController extends Controller {
	private static final String WEB_INF = "/WEB-INF/_view/";

	public String getViewPath() {
		Client client = getClient();
		return WEB_INF + client.getPath() + "/";
	}

	public Client getClient() {
		Client client = getSessionAttr(Constants.SESSION_CLIENT_KEY);
		return client;
	}

}
