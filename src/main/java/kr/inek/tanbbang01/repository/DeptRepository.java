package kr.inek.tanbbang01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.inek.tanbbang01.model.Dept;

@Repository
public interface DeptRepository extends JpaRepository<Dept, Long>{

}
