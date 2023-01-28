package lk.ise.pos.bo;

import lk.ise.pos.bo.custom.impl.CustomerBoImpl;
import lk.ise.pos.bo.custom.impl.ItemBoImpl;
import lk.ise.pos.bo.custom.impl.UserBoImpl;
import lk.ise.pos.dao.custom.impl.CustomerDaoImpl;
import lk.ise.pos.dao.custom.impl.ItemDaoImpl;
import lk.ise.pos.dao.custom.impl.UserDaoImpl;
import lk.ise.pos.enums.BoType;
import lk.ise.pos.enums.DaoType;

public class BoFactory {
    private static BoFactory boFactory;
    private BoFactory(){}
    public static BoFactory getInstance(){
        return boFactory==null?(boFactory= new BoFactory()):boFactory;
    }
    public <T> T getBo(BoType type){
        switch (type){
            case CUSTOMER:
                return (T) new CustomerBoImpl();
            case USER:
                return (T) new UserBoImpl();
            case ITEM:
                return (T) new ItemBoImpl();
            default:
                return null;
        }
    }
}
