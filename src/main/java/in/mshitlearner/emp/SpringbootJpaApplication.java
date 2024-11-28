package in.mshitlearner.emp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import in.mshitlearner.emp.entity.Department;
import in.mshitlearner.emp.entity.Employee;
import in.mshitlearner.emp.entity.Qualification;
import in.mshitlearner.emp.repository.DepartmentRespository;
import in.mshitlearner.emp.repository.EmployeeRespository;
import in.mshitlearner.emp.repository.QualificationRepository;
import in.mshitlearner.emp.service.AccountService;
import in.mshitlearner.emp.service.EmpAddressService;

@SpringBootApplication
public class SpringbootJpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext  context = SpringApplication.run(SpringbootJpaApplication.class, args);
		EmployeeRespository empRep= context.getBean(EmployeeRespository.class);
		DepartmentRespository deptRep = context.getBean(DepartmentRespository.class);
		QualificationRepository qualRep = context.getBean(QualificationRepository.class);
		
		AccountService accountService = context.getBean(AccountService.class);
		//accountService.saveAccountDetails();
		
		EmpAddressService empAddressService = context.getBean(EmpAddressService.class);
		empAddressService.saveEmpAddress();
		
		
		/*
		Employee emp = new Employee();
		emp.setName("Ravi Shankar");
		emp.setAge(26);
		emp.setDeptName("Devops");
		empRep.save(emp);
		
		
		Department dep1 = new Department(1,"Accounts");
		Department dep2 = new Department(2,"Administrator");
		Department dep3 = new Department(3,"HR");
		Department dep4 = new Department(4,"Testing");
		Department dep5 = new Department(5,"Development");
		deptRep.saveAll(Arrays.asList(dep1,dep2,dep3,dep4,dep5));
		
		
		Qualification qual1 = new Qualification(1, "ASE", "PG Or Degree");
		Qualification qual2 = new Qualification(2, "SE", "PG");
		Qualification qual3 = new Qualification(3, "SSE", "PG");
		Qualification qual4 = new Qualification(4, "ATL", "PG");
		Qualification qual5 = new Qualification(5, "TL", "PG");
		Qualification qual6 = new Qualification(5, "MNG", "PG");
		qualRep.saveAll(Arrays.asList(qual1,qual2,qual3,qual4,qual5,qual6));
		*/
		
		
		List<Employee> empDeptList =  empRep.findByDeptName("Testing");
		empDeptList.forEach(employee -> {
			System.out.println("Employee Name Where Dept = Testing --- "+employee);
		});
		
		List<Employee> empAgeList =  empRep.findByAgeGreaterThanEqual(20);
		empAgeList.forEach(employee -> {
			System.out.println("Employee Name Where Age >= 20 --- "+employee);
		});
		
		List<Employee> empDeptAndAgeList =  empRep.findByDeptNameAndAge("Testing", 32);
				empDeptAndAgeList.forEach(employee -> {
			System.out.println("Employee Name Where Age = 20 and Dept = Testing --- "+employee);
		});
				
		List<Employee> empDeptAndAgeBetweenList =  empRep.findByDeptNameAndAgeBetween("Testing", 30,40);
		empDeptAndAgeBetweenList.forEach(employee -> {
			System.out.println("Employee Name Where Age Between 30 and 40 and Dept = Testing --- "+employee);
		});		
		
		List<Department> deptLst = deptRep.getAllDepartmentsByHQL();
		deptLst.stream().forEach(department ->
				System.out.println("Department - "+department));
		
		List<Department> deptByIDLst = deptRep.getAllDepartmentsByID(1);
		deptByIDLst.stream().forEach(department ->
				System.out.println("Department where DeptSeqID=1 - "+department));
		
		PageRequest pageRequest = PageRequest.of(0,2);
		Page<Qualification> pageData = qualRep.findAll(pageRequest);
		int totalPages = pageData.getTotalPages();
		System.out.println("Total Pages --- "+ totalPages);
		List<Qualification> qualLst = pageData.getContent();
		qualLst.stream().forEach(qualification -> System.out.println("Qualification ---"+qualification));
		
		Qualification qual = new Qualification();
		qual.setQualRequirements("PG");
		//qual.setQualSeqID(2);
		Example<Qualification> example = Example.of(qual);
		//List<Qualification> qualificationLst = qualRep.findAll(example); //Fetch all the records with out sorting
		List<Qualification> qualificationLst = qualRep.findAll(example, Sort.by("qualName").ascending()); // Fetch all the records and sort based on qualName
		qualificationLst.stream().forEach(qualification -> System.out.println("Qualification QBE  ---"+qualification));
		
		
		/*		
		Iterable<Department> dept = deptRep.findAllById(Arrays.asList(1,3,5));
		System.out.println("----Department List------");
		dept.forEach(department -> System.out.println(department));
		
		
		List<Employee> empList =  empRep.findAll(Sort.by(Sort.Order.asc("name")));
		//Lambada Expersion
		empList.forEach(employee -> {
			System.out.println("Lambada - Name - "+employee.getName());
		});
		
		//Using Stream
		empList.stream().forEach(employee ->{
			System.out.println("Stream - Name - "+employee.getName());
		});
		*/
		/*		
		List<Employee> employeeList =  empRep.findAll();
		//Stream - Sorting by Name
		List<Employee> sortedEmpList =  employeeList.stream().sorted((Obj1, Obj2) -> 
				Obj1.getName().compareTo(Obj2.getName())).collect(Collectors.toList());
		
		sortedEmpList.forEach(System.out::println);
		
		// Stream Using Comprator
		List<Employee> sortedEmpListUsingComp = employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).collect(Collectors.toList());
		System.out.println("---Comparator----");
		sortedEmpListUsingComp.forEach(System.out::println);
		
		// Stream Using Max
		Optional<Employee> maxEmpListUsingComp = employeeList.stream().max(Comparator.comparing(Employee::getName));
		System.out.println("---Max Comparator----");
		maxEmpListUsingComp.ifPresent(employee -> System.out.println("Max Employee Object -"+employee));
		
		// Stream - Comprator fetching second Name report
		Optional<Employee> secEmpListUsingComp = employeeList.stream().sorted(Comparator.comparing(Employee::getName).reversed()).skip(1).findFirst();
		System.out.println("---Second Max Comparator----");
		secEmpListUsingComp.ifPresent(employee -> System.out.println("Max Employee Object -"+employee));
		*/
		/*
		 * // Get the second maximum price OptionalDouble secondMaxPrice =
		 * products.stream() .mapToDouble(Product::getPrice) .boxed()
		 * .sorted(Comparator.reverseOrder()) .skip(1) .mapToDouble(Double::doubleValue)
		 * .findFirst();
		 */
		
	}

}
