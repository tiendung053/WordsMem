package model;

import lombok.Data;

import java.util.Date;

@Data
public class BaseDTO {
    protected Long id;
    protected Integer status;
    protected String createBy;
    protected Date createdDate;
    protected String lastUpdatedBy;
    protected Date lastUpdatedDate;
}
