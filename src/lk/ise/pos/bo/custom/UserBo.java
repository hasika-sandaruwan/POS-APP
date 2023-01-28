package lk.ise.pos.bo.custom;

import lk.ise.pos.bo.SuperBo;
import lk.ise.pos.dto.UserDto;

public interface UserBo extends SuperBo {
    public void initializeUsers();
    public UserDto findUser(String username);
}
