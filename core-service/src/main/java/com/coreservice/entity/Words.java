package com.coreservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "ADM_WORDS")

public class Words extends BaseEntity implements GenericEntity<Words>{


    @Override
    public void update(Words source) {

    }

    @Override
    public Words createNewInstance() {
        return null;
    }
}
