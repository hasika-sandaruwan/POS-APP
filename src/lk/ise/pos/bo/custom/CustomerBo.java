package lk.ise.pos.bo.custom;

import lk.ise.pos.bo.SuperBo;

import java.util.List;

public interface CustomerBo extends SuperBo {
    public boolean saveCustomer(CustomerDto dto);
    public boolean updateCustomer(CustomerDto dto);
    public CustomerDto findCustomer(String id);
    public boolean deleteCustomer(String id);
    public List<CustomerDto> findAllCustomers(String id);
}
