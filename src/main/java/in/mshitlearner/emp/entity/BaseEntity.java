package in.mshitlearner.emp.entity;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
	
	@CreationTimestamp
	@Column(name ="CREATED_DATE", updatable = false)
	private Date createdDate;
	@UpdateTimestamp
	@Column(name ="UPDATED_DATE", insertable = false)		
	private Date updatedDate;
	
}
