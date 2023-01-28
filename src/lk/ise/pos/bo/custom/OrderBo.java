package lk.ise.pos.bo.custom;

import lk.ise.pos.bo.SuperBo;
import lk.ise.pos.dto.OrderDto;

import java.sql.SQLException;

public interface OrderBo extends SuperBo {
    public boolean saveOrder(OrderDto dto) throws Exception;
    public String generateOrderId() throws SQLException, ClassNotFoundException;
}
