package com.example.department.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.department.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	@Query(value="select * from department where departmentid=?1",nativeQuery=true)
	Department findDepartmentId(Long departmentId);

}
