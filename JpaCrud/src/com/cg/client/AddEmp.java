package com.cg.client;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.Entity.Emp;

public class AddEmp 
{
	public static void main(String[] args) 
	{
		Emp emp = new Emp();
		emp.setEmpId(1001);
		emp.setEmpName("Ram Kumar");
		emp.setEmpSal(88000.0);
		emp.setEmpDept("hr");
		emp.setEmpdoj(LocalDate.of(2017, 8, 21));
		
		
		EntityManagerFactory fac=Persistence.createEntityManagerFactory("JPA-CRUD");
		EntityManager em= fac.createEntityManager();
		EntityTransaction tx = null;
		try
		{
			
			tx.begin();
			em.persist(emp);
			tx.commit();
			
		}
		catch(Exception ex)
		{
			
			if(tx != null) tx.rollback();
		}
		
		fac.close();
		System.out.println("table created");
		
	}
}
