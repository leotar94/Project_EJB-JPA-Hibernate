package com.ejb.clientutil;

import java.util.Properties;

import javax.naming.Context;
import org.wildfly.naming.client.WildFlyInitialContext;
import javax.naming.NamingException;

public class JNDILookupClass {
	private static Context initialContext;
	
	private static final String PKG_INTERFACES = "org.wildfly.naming.client.WildFlyInitialContextFactory";
	
	public static Context getInitialContext() throws NamingException{
		if (initialContext == null) {
			Properties prop = new Properties();
			prop.put(Context.INITIAL_CONTEXT_FACTORY,"org.wildfly.naming.client.WildFlyInitialContextFactory");
			prop.put(Context.URL_PKG_PREFIXES, PKG_INTERFACES);
			prop.put(Context.PROVIDER_URL,"http-remoting://localhost:8080");
//			prop.put("jboss.naming.client.ejb.context", true);
			initialContext = new WildFlyInitialContext(prop);			
		}
		return initialContext;
	}
}
