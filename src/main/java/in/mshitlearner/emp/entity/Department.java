package in.mshitlearner.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="MSH_DEPARTMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
	
		@Id
		@Column(name="MSH_DEPT_SEQ_ID")
		private Integer deptSeqID;
		
		@Column(name="MSH_DEPT_NAME")
		private String deptName;
}
