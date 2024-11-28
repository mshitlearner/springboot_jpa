package in.mshitlearner.emp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mshitlearner.emp.entity.Employee;

public interface EmployeeRespository extends JpaRepository<Employee, Integer> {
	
		public List<Employee> findByDeptName(String departmentName);
		
		public List<Employee> findByAgeGreaterThanEqual(Integer age);
		
		public List<Employee> findByDeptNameAndAge(String deptName, Integer age);
		
		public List<Employee> findByDeptNameIn(List<String> deptName);
		
		public List<Employee> findByDeptNameAndAgeBetween(String deptName, Integer fromAge, Integer toAge);
	
}
