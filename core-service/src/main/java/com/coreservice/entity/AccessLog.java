package com.coreservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "ADM_ACCESS_LOG")
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AccessLog extends BaseEntity {
    @Column(name = "DEVICE")
    private String device;

    @Column(name = "BROWSER")
    private String browser;

    @Column(name = "IP")
    private String ip;

    @Column(name = "HOSTNAME")
    private String hostname;

    @Column(name = "URL")
    private String url;

    @Column(name = "LOGIN_TIME")
    private Date loginTime;

    @Column(name = "LOGOUT_TIME")
    private Date logoutTime;

    @Column(name = "ADM_ACCOUNT_ID")
    private Integer accountId;

    @Column(name = "ADM_ACCOUNT_NAME")
    private String username;

    @Column(name = "TOKEN")
    private String token;
}
