package com.coreservice.repository;

import com.coreservice.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T extends GenericEntity<T>> extends JpaRepository<T, Long> {
}
