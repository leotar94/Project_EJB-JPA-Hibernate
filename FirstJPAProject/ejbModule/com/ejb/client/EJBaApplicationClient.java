package com.ejb.client;

import java.util.List;

import javax.naming.Context;
import javax.naming.NamingException;

import com.ejb.businesslogic.ProjectBean;
import com.ejb.businesslogic.ProjectBeanRemote;
import com.ejb.clientutil.JNDILookupClass;
import com.ejb.entities.Project;

public class EJBaApplicationClient {

	//private static final String LOOKUP_STRING = "ProjectBean/remote";



	public static void main(String[] args) {
		ProjectBeanRemote bean = doLookup();
		System.out.println("avvio");
		Project p1 = new Project();
		p1.setPname("Banking App");
		p1.setPlocation("Town City");
		p1.setDept_no(1);
		
		Project p2 = new Project();
		p2.setPname("Office Automation");
		p2.setPlocation("Downtown");
		p2.setDept_no(2);
		
		bean.saveProject(p1);
		bean.saveProject(p2);
		
		p1.setPnumber(1);
		Project p3 = bean.findProject(p1);
		System.out.println(p3.toString());
		
		System.out.println("Lista Projects");
		List<Project> projects = bean.retrieveAllProjects();
		for(Project p : projects)
			System.out.println(p.toString());
	}



private static ProjectBeanRemote doLookup() {
	Context context = null;
	ProjectBeanRemote bean = null;
	try {
		context = JNDILookupClass.getInitialContext();
		final String lookupName = getLookupName();
		System.out.println("test");
		bean = (ProjectBeanRemote) context.lookup(lookupName);
		
	}catch(NamingException e) {
		e.printStackTrace();
	}
	return bean;
}

private static String getLookupName() {
	
	String appName="";
	String moduleName = "FirstJPAProject";
	String distinctName="";
	String beanName=ProjectBean.class.getSimpleName();
	final String interfaceName =ProjectBeanRemote.class.getName();
	String name = "ejb:"+appName+"/"+moduleName+"/"
			+ distinctName+"/"+beanName+"!"+interfaceName;
	System.out.println(name);
	return name;
}

}//ejb:FirstJPAProject/ProjectBean!com.ejb.businesslogic.ProjectBeanRemote