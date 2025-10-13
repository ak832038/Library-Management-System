package org.gfg.Library_Management_Minor.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class TxnRequest {

    @NotBlank(message = "User phone number cannot be blank")
    private String userPhoneNo;

    @NotBlank(message = "Book number cannot be blank")
    private String bookNo;
}
