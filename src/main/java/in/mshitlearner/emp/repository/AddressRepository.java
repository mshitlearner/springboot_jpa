package in.mshitlearner.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mshitlearner.emp.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
