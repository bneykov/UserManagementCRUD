package com.personal.userManagement_app.services;

import com.personal.userManagement_app.model.dto.UserCreateDTO;
import com.personal.userManagement_app.model.dto.UserUpdateDTO;
import com.personal.userManagement_app.model.entity.UserEntity;
import com.personal.userManagement_app.repositories.UserRepository;
import com.personal.userManagement_app.utils.errors.UserNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public UserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    public UserEntity findById(Long id) {
        return this.userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public List<UserEntity> getUsers() {
        return this.userRepository.findAll();
    }

    public void createUser(UserCreateDTO createDTO) {


        UserEntity user = this.modelMapper.map(createDTO, UserEntity.class);
        this.userRepository.save(user);

    }

    public List<UserEntity> findAllSortedByLastNameAndDateOfBirth() {
       return this.userRepository.findAll(Sort.by(Sort.Direction.ASC, "lastName")
                                .and(Sort.by(Sort.Direction.ASC, "dateOfBirth")));
    }
    public List<UserEntity> searchAllSortedByLastNameAndDateOfBirth(String keyword) {
        Sort sortByLastNameAndDateOfBirth = Sort.by(Sort.Direction.ASC, "lastName")
                .and(Sort.by(Sort.Direction.ASC, "dateOfBirth"));
        return this.userRepository.searchUsers(keyword, sortByLastNameAndDateOfBirth);
    }


    public void update(UserUpdateDTO updateDTO) {
        UserEntity user = this.modelMapper.map(updateDTO, UserEntity.class);
        this.userRepository.save(user);
    }

    public void delete(Long id) {
        this.userRepository.deleteById(id);
    }
}
