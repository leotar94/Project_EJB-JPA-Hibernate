package com.ejb.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity(name ="project")
public class Project implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Project() {}
	
	@Id
	private int pnumber;
	
	private String pname;
	
	private String plocation;
	
	private int dept_no;

	public int getPnumber() {
		return pnumber;
	}

	public void setPnumber(int pnumber) {
		this.pnumber = pnumber;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPlocation() {
		return plocation;
	}

	public void setPlocation(String plocation) {
		this.plocation = plocation;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	@Override
	public String toString() {
		return "Project [pnumber=" + pnumber + ", pname=" + pname + ", plocation=" + plocation + ", dept_no=" + dept_no
				+ "]";
	}
	
	
}
/*VERSIONE VECCHIA MA NOTE UTILI
 *----------------------------------------------------------------------------|
 * NOTA => non c'è il nome della tabella perchè la tabella e la nostra classe |
 * hanno lo stesso nome. Stesso discorso si può fare con i nomi delle colonne |
 * ed i campi del Bean, ma nel mio caso ho chiamato in modo diverso campi e   |
 * colonne p.s. per utilizzare qu|
 * ---------------------------------------------------------------------------|
 */

