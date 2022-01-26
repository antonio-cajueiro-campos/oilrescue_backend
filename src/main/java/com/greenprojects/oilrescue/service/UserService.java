package com.greenprojects.oilrescue.service;

import com.greenprojects.oilrescue.model.dto.UserDTO;
import com.greenprojects.oilrescue.model.entity.UserEntity;
import com.greenprojects.oilrescue.model.exception.EmailAlreadyTakenException;
import com.greenprojects.oilrescue.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userOpt = userRepository.findByUsername(username);

        if (!userOpt.isPresent()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        UserEntity user = userOpt.get();
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    public UserEntity saveUser(UserDTO userDTO) throws EmailAlreadyTakenException {

        if (!this.userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            UserEntity user = modelMapper.map(userDTO, UserEntity.class);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return this.userRepository.save(user);
        }

        throw new EmailAlreadyTakenException("Email já utilizado por outro usuário");
    }

    public UserEntity getUser(Long id) {
        Optional<UserEntity> userOpt = this.userRepository.findById(id);

        if (!userOpt.isPresent()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return userOpt.get();
    }

    public UserEntity updateUser(UserDTO user) {

        return new UserEntity();
    }

    public boolean deleteUser(String id) {

        return true;
    }
}
