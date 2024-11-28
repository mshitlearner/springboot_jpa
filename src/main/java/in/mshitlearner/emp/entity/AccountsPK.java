package in.mshitlearner.emp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class AccountsPK {
		@Column(name="MSH_ACC_SEQ_ID")
		private Integer accountSeqId;
		@Column(name="MSH_ACC_NO")
		private String accNo;
		@Column(name="MSH_ACC_TYPE")
		private String accType;
}
