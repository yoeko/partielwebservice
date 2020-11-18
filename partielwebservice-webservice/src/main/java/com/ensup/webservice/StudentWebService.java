package com.ensup.webservice;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ensup.partielwebservice.dao.EtudiantDao;
import com.ensup.partielwebservice.dao.IEtudiantDao;
import com.ensup.partielwebservice.domaine.Etudiant;
import com.ensup.partielwebservice.service.EtudiantService;
import com.ensup.partielwebservice.service.IEtudiantService;

@Path("/json/student")
public class StudentWebService {
	
	private IEtudiantDao dao = new EtudiantDao();
	private EtudiantService studentService = new EtudiantService(dao);
	
	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Etudiant> getAll() {
		return studentService.getAllStudent();
	}

	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void createStudent(Etudiant etudiant) {		
		studentService.createEtudiant(etudiant);
	}
}
