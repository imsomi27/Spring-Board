package com.studysetting.common;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import lombok.*;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
public class BaseDateEntity {

	@CreationTimestamp
	private LocalDateTime createDttm;

	@UpdateTimestamp
	private LocalDateTime updateDttm;
}