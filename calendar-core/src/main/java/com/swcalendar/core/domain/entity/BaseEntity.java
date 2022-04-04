package com.swcalendar.core.domain.entity;

import java.time.LocalDateTime;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass //코드로만 존재하고 이 클래스를 상속받은 클래스에서 필드로 존재한다
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class) //AuditingEntityListener가 @CreatedDate어노테이션과 @LastModifiedDate을 읽어서 현재시간을 주입해줌
public class BaseEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedDate
  private LocalDateTime createdAt;

  @LastModifiedDate
  private LocalDateTime updatedAt;

  public BaseEntity(Long id){
    this.id = id;
  }
}
