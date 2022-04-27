package com.gui.user.service;

import com.gui.user.VO.ResponseTemplateVO;
import com.gui.user.model.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {
    User saveUser(User department);

    User getUser(Long id);

    ResponseTemplateVO getUserWithDepartment(Long userId);
}
