package org.yan.mewtwo.config;

import org.yan.mewtwo.controller.PractiseController;
import org.yan.mewtwo.interceptor.ClientInterceptor;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.c3p0.C3p0Plugin;
import com.jfinal.render.FreeMarkerRender;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class WebConfig extends JFinalConfig {
	//private static final String MYSQL_DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";

	@Override
	public void configConstant(Constants me) {
		me.setDevMode(true);
		me.setViewType(ViewType.FREE_MARKER);
		
		try {
			PropKit.use("cons.properties");
			FreeMarkerRender.getConfiguration().setCacheStorage(new freemarker.cache.MruCacheStorage(0, 0));
			FreeMarkerRender.getConfiguration().setDateFormat("yyyy-MM-dd");
			FreeMarkerRender.getConfiguration().setDateTimeFormat("yyyy-MM-dd");
			// FreeMarkerRender.getConfiguration().setSharedVariable("FreemarkerKit",
			// new FreemarkerKit());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", PractiseController.class);
	}

	@Override
	public void configPlugin(Plugins me) {
		C3p0Plugin cp = new C3p0Plugin(PropKit.get("db.url"), PropKit.get("db.user"), PropKit.get("db.password"));
		me.add(cp);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(cp);
		me.add(arp);
	}

	@Override
	public void configInterceptor(Interceptors me) {
		me.add(new ClientInterceptor());
	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("contextPath"));
	}

	@Override
	public void configEngine(Engine me) {
	}
}
