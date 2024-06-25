package com.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ADM_MENU")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Menu extends BaseEntity {
    private String path;
    private String component;
    private String redirect;
}
