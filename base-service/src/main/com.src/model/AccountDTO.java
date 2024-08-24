package model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class AccountDTO extends BaseDTO {
    @NotBlank(message = "Tên đăng nhập không được để trống")
    private String username;
    @NotBlank(message = "Mật khẩu không được để trống")
    private String password;
    private String phoneNumber;
    private String email;
    private String accessToken;
}
