package lk.ise.pos.bo.custom.impl;

import lk.ise.pos.bo.custom.OrderBo;
import lk.ise.pos.dao.DaoFactory;
import lk.ise.pos.dao.custom.OrderDao;
import lk.ise.pos.dto.OrderDto;
import lk.ise.pos.entity.Order;
import lk.ise.pos.enums.DaoType;

public class OrderBoImpl implements OrderBo {
   private OrderDao orderDao= DaoFactory.getInstance().getDao(DaoType.ORDER);
    @Override
    public boolean saveOrder(OrderDto dto) throws Exception {
        return orderDao.save(
                new Order(
                        dto.getOrderId(), dto.getCustomer(),
                        dto.getDate(), dto.getTotal()
                )
        );
    }
}
