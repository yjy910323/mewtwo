package org.yan.mewtwo.controller;

public class IndexController extends BaseController {
	
	public void index(){
		render(getViewPath() + "index/index.html");
	}
	
}
