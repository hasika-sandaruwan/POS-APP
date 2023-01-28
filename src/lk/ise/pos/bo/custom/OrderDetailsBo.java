package lk.ise.pos.bo.custom;

import lk.ise.pos.dto.OrderDetailsDto;
import lk.ise.pos.entity.OrderDetails;

public interface OrderDetailsBo {
    public boolean saveOrderDetail(OrderDetailsDto dto) throws Exception;
}
