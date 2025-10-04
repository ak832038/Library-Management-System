package org.gfg.Library_Management_Minor.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.gfg.Library_Management_Minor.model.User;
import org.gfg.Library_Management_Minor.model.UserStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserRequest {

    private String userName;

    private String email;

    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNo;

    private String address;

    public User toUser() {
        return User.builder()
                .name(this.userName)
                .email(this.email)
                .phoneNo(this.phoneNo)
                .address(this.address)
                .userStatus(UserStatus.ACTIVE)
                .build();
    }
}
