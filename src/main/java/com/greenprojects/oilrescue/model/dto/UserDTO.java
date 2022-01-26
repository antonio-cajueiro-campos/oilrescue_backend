package com.greenprojects.oilrescue.model.dto;

import com.greenprojects.oilrescue.model.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    Long id;
    String name;
    String email;
    String username;
    String password;
    String type;
    String role;
}
