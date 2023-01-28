package lk.ise.pos.dao.custom.impl;

import lk.ise.pos.dao.CrudUtil;
import lk.ise.pos.dao.custom.ItemDao;
import lk.ise.pos.entity.Item;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean save(Item i) throws Exception {
        return CrudUtil.execute(
                "INSERT INTO item VALUES(?,?,?,?)",
                i.getCode(), i.getDescription(), i.getQtyOnHand(), i.getUnitPrice()
        );
    }

    @Override
    public boolean update(Item i) throws Exception {
        return CrudUtil.execute(
                "UPDATE item SET description=?, qty_on_hand=?, unit_price=? WHERE code=?",
                i.getDescription(), i.getQtyOnHand(), i.getUnitPrice(), i.getCode()
        );
    }

    @Override
    public Item find(String code) throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM item WHERE code=?", code);
        if (set.next()) {
            return new Item(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getDouble(4)
            );
        }
        return null;
    }

    @Override
    public boolean delete(String code) throws Exception {
        return CrudUtil.execute("DELETE FROM item WHERE code=?", code);
    }

    @Override
    public List<Item> findAll() throws Exception {
        ResultSet set = CrudUtil.execute("SELECT * FROM item");
        List<Item> items = new ArrayList<>();
        while (set.next()) {
            items.add(new Item(
                    set.getString(1),
                    set.getString(2),
                    set.getInt(3),
                    set.getDouble(4)
            ));
        }
        return items;
    }
}
