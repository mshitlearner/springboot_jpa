package in.mshitlearner.emp.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MSH_EMPLOYEE")
@Data
public class Employee extends BaseEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="MSH_EMP_SEQ_ID")
		private Integer seqID;
		@Column(name="MSH_EMP_NAME")
		private String name;
		@Column(name="MSH_EMP_AGE")
		private Integer age;
		@Column(name="MSH_EMP_DEPT_NAME")
		private String deptName;
}
