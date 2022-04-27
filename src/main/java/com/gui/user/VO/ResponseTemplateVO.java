package com.gui.user.VO;

import com.gui.user.model.User;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ResponseTemplateVO {

    User user;
    Department department;
}
