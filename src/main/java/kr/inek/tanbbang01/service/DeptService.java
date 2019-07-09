package kr.inek.tanbbang01.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import kr.inek.tanbbang01.model.Dept;

public interface DeptService {
	// 전체 Depts
	public List<Dept> retrieveAllDepts();
	
	// 특정 Dept
	public Resource<Dept> retrieveDept(@PathVariable Long id);
	
	// Save Dept 
	public ResponseEntity<Dept> createDept(@Valid @RequestBody Dept dept);
	
	// Delete Dept
	public void deleteDept(@PathVariable Long id);
}
