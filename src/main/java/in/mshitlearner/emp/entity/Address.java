package in.mshitlearner.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MSH_EMP_ADDRESS")
@Data
public class Address {
		
		@Id
		@Column(name = "MSH_ADD_SEQ_ID")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer addressSeqId;
		@Column(name = "MSH_EMP_SEQ_ID")		
		private Integer empSeqId;
		@Column(name = "MSH_ADD_CITY")
		private String city;
		@Column(name = "MSH_ADD_DISTRICT")
		private String district;
		@Column(name = "MSH_ADD_STATE")
		private String state;
		@Column(name = "MSH_ADD_COUNTRY")
		private String country;
		
}
