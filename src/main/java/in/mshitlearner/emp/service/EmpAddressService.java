package in.mshitlearner.emp.service;

import org.hibernate.jdbc.Expectation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.mshitlearner.emp.entity.Address;
import in.mshitlearner.emp.entity.Employee;
import in.mshitlearner.emp.repository.AddressRepository;
import in.mshitlearner.emp.repository.EmployeeRespository;

@Service
public class EmpAddressService {
		@Autowired
		public EmployeeRespository employeeRespository;
		@Autowired
		public AddressRepository addressRepository;
		
		@Transactional(rollbackFor = Exception.class)
		public void saveEmpAddress() {
			Employee employee =new Employee();
			employee.setName("Peer");
			employee.setAge(40);
			employee.setDeptName("Dev Manager");
			employee = employeeRespository.save(employee);
			System.out.println("Employee Seq ID ---"+ employee.getSeqID());
			Address address = new Address();
			address.setEmpSeqId(employee.getSeqID());
			address.setCity("Hyderabad");
			address.setDistrict("Hyderabad");
			address.setState("Telengana");
			address.setCountry("India");
			address = addressRepository.save(address);
			System.out.println("Address Seq ID ---"+ address.getAddressSeqId());			
		}
}
