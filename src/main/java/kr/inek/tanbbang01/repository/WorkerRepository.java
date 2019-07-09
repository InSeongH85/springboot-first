package kr.inek.tanbbang01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.inek.tanbbang01.model.Worker;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long>{
 
}
