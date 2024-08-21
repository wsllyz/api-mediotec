package br.com.mediotec.apisenac.service;

import br.com.mediotec.apisenac.dto.UserDTO;
import br.com.mediotec.apisenac.entity.UserEntity;
import br.com.mediotec.apisenac.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> findAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        return userEntities.stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        return userEntity.map(UserDTO::new).orElse(null);
    }

    public void create(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        userRepository.save(userEntity);
    }

    public UserDTO update(UserDTO userDTO) {
        UserEntity userEntity = new UserEntity(userDTO);
        return new UserDTO(userRepository.save(userEntity));
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
