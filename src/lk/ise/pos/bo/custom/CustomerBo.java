package lk.ise.pos.bo.custom;

import java.util.List;

public interface CustomerBo {
    public boolean saveCustomer(CustomerDto dto);
    public boolean updateCustomer(CustomerDto dto);
    public CustomerDto findCustomer(String id);
    public boolean deleteCustomer(String id);
    public List<CustomerDto> findAllCustomers(String id);
}
