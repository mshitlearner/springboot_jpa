package in.mshitlearner.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "MSH_EMP_ACCOUNTS")
@Data
public class Accounts {
		
		@Column(name ="MSH_EMP_SEQ_ID")
		private Integer empSeqId;
		
		@EmbeddedId
		private AccountsPK accPK;
}
