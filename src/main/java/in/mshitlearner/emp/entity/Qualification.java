package in.mshitlearner.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MSH_QUALIFICATION")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Qualification {
		
	@Id
	@Column(name="MSH_QUAL_SEQ_ID")
	private Integer qualSeqID;
	
	@Column(name="MSH_QUAL_NAME")
	private String qualName;
	
	@Column(name="MSH_QUAL_REQUIREMENTS")
	private String qualRequirements;
}
