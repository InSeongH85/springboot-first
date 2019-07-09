package kr.inek.tanbbang01.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.inek.tanbbang01.model.Dept;
import kr.inek.tanbbang01.service.DeptService;


@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	//GET /depts
	// retrieveAllDepts
	@GetMapping("/jpa/depts")
	public List<Dept> retrieveAllDepts() {
		return deptService.retrieveAllDepts();
	}

	// GET /depts/{id}
	@GetMapping("/jpa/depts/{id}")
	public Resource<Dept> retrieveDept(@PathVariable Long id) {
		return deptService.retrieveDept(id);
	}

	// Created Dept
	// input - details of depts
	// output - created & Return the created URI
	// GET  http://localhost:8080/jpa/depts
	// body : { "code": "ABC_2", "name":"tanbbang03", "isActive" : 1, "lastUpdatorId": 1, "dateCreated": "2002-07-19T04:29:24", "lastUpdated":"2002-07-19T04:29:24" }
	
	//HEATEOAS 
	// Hyper Media as the engine of application state
	@PostMapping("/jpa/depts")
	public ResponseEntity<Dept> createDept(@Valid @RequestBody Dept dept) {
		return deptService.createDept(dept);
	}
	
	@DeleteMapping("/jpa/depts/{id}")
	public void deleteDept(@PathVariable Long id) {
		deptService.deleteDept(id);
	}
}
