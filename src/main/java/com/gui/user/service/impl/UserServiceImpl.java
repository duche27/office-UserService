package com.gui.user.service.impl;

import com.gui.user.VO.Department;
import com.gui.user.VO.ResponseTemplateVO;
import com.gui.user.exceptions.UserNotFoundException;
import com.gui.user.model.User;
import com.gui.user.repository.UserRepository;
import com.gui.user.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {

    private static final String DEPARTMENT_API_URL = "http://department-service/departments/";

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserServiceImpl(UserRepository userRepository, RestTemplate restTemplate) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public User saveUser(User user) {

        log.info("Saving user: {}", user);

        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {

        log.info("Retrieving userId: {}", id);

        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("El departamento con id " + id + " no existe"));
    }

    @Override
    public ResponseTemplateVO getUserWithDepartment(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("El usuario con id " + userId + " no existe"));

        Department department = restTemplate.getForObject(DEPARTMENT_API_URL + user.getDepartmentId(), Department.class);

        return ResponseTemplateVO.builder().user(user).department(department).build();
    }
}
