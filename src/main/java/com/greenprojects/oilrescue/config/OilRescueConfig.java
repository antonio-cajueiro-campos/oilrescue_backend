package com.greenprojects.oilrescue.config;

import com.greenprojects.oilrescue.model.dto.UserDTO;
import com.greenprojects.oilrescue.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static com.greenprojects.oilrescue.model.enums.Roles.ROLE_ADMIN;
import static com.greenprojects.oilrescue.model.enums.Roles.ROLE_USER;

@Configuration
public class OilRescueConfig {

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            UserDTO user1 = new UserDTO().builder()
                    .username("kime").password("123")
                    .email("kime").role(ROLE_USER.toString())
                    .name("Antonio1").build();
            UserDTO user2 = new UserDTO().builder()
                    .username("kimee").password("1234")
                    .email("kimee").role(ROLE_ADMIN.toString())
                    .name("Antonio2").build();

            userService.saveUser(user1);
            userService.saveUser(user2);
        };
    }
}
