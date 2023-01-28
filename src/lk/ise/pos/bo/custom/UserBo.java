package lk.ise.pos.bo.custom;

public interface UserBo {
    public void initializeUsers();
    public UserDto findUser(String username);
}
