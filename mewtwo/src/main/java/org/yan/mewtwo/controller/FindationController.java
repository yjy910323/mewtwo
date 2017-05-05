package org.yan.mewtwo.controller;

public class FindationController extends BaseController {
	
	public void index(){
		render(getViewPath() + "findation/preference.html");
	}
}
