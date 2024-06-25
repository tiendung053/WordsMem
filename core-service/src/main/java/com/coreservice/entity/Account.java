package com.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Data
@Table(name = "ADM_ACCOUNT")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity implements GenericEntity<Account> {
    @Column(name = "ACCOUNT_NAME")
    private String username;

    @Column(name = "PASSWD")
    private String password;

    @Column(name = "CODE_USER")
    private String codeUser;

    @Column(name = "CODE_PRESENTER")
    private String codePresenter;

    @NotNull
    @Column(name = "TYPE")
    private Integer type;

    private String name;
    private String avatar;
    private String introduction;

    @Override
    public Long getId(){
        return this.id;
    }

    @Override
    public void update(Account source) {
        this.username = source.username;
        this.password = source.getPassword();
        this.codeUser = source.getCodeUser();
        this.codePresenter = source.getCodePresenter();
        this.type = source.getType();
        this.name = source.getName();
        this.avatar = source.getAvatar();
        this.introduction = source.getIntroduction();
        this.status = source.getStatus();
        this.createBy = source.getCreateBy();
        this.createdDate = source.getCreatedDate();
        this.lastUpdatedBy = source.lastUpdatedBy;
        this.lastUpdatedDate = source.lastUpdatedDate;
    }

    @Override
    public Account createNewInstance() {
        Account newInstance = new Account();
        newInstance.update(this);
        return newInstance;
    }
}
