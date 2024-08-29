package com.study.springboot.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Reply {
	@Id
	@SequenceGenerator(
			name = "replyseq",
			sequenceName = "reply_seq",
			allocationSize = 1
			)
	@GeneratedValue(generator="replyseq")
	private Long rno;
	@NonNull
	private String content;
	@NonNull
	private String writer;
	@NonNull
	@Column(name="ref_bno")
	private Long refBno;
	
	@CreatedDate
	@Column(name="crete_date", insertable=false, updatable=false, columnDefinition="DATE DEFAULT SYSDATE")
	private LocalDateTime createDate;
	
	@LastModifiedDate
	@Column(name="update_date")
	private LocalDateTime updateDate;

}
