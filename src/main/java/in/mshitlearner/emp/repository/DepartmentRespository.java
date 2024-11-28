package in.mshitlearner.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import in.mshitlearner.emp.entity.Department;

public interface DepartmentRespository extends CrudRepository<Department, Integer>{
	
		@Query(value="from Department")
		public List<Department> getAllDepartmentsByHQL();

		@Query(value="select * from MSH_DEPARTMENT", nativeQuery = true)
		public List<Department> getAllDepartmentsBySQL();
		
		@Query(value="from Department where deptSeqID = :deptSeqID")
		public List<Department> getAllDepartmentsByID(int deptSeqID);
	
		
}
