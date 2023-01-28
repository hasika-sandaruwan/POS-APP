package lk.ise.pos.bo.custom;

import lk.ise.pos.bo.SuperBo;

public interface UserBo extends SuperBo {
    public void initializeUsers();
    public UserDto findUser(String username);
}
