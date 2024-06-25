package com.coreservice.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(16)", updatable = false, nullable = false)
    protected Long id;
    protected Integer status;
    protected String createBy;
    @CreationTimestamp
    protected Date createdDate;
    protected String lastUpdatedBy;
    @UpdateTimestamp
    protected Date lastUpdatedDate;
}
