package model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountDTO extends BaseDTO {
    private String username;
    private String password;
    private String phoneNumber;
    private String email;
    private String accessToken;
}
