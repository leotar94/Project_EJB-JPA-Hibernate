package com.ejb.businesslogic;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.entities.Project;

/**
 * Session Bean implementation class Project
 */
@Stateless
public class ProjectBean implements ProjectBeanRemote {

    
    @PersistenceContext(unitName = "JPADB")
    private EntityManager em;
	@Override
	public void saveProject(Project project) {
		em.persist(project);		
	}
	public ProjectBean() {}

	@Override
	public Project findProject(Project project) {
		Project p = em.find(Project.class, project.getPnumber());
		return p;
	}

	@Override
	public List<Project> retrieveAllProjects() {
		String q = "SELECT p from "+Project.class.getName() + " p";
		Query query = em.createQuery(q);
		List<Project> projects =(List<Project>) query.getResultList();
		return projects;
	}

}
