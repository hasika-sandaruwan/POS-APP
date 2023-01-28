package lk.ise.pos.bo.custom.impl;

import lk.ise.pos.bo.custom.ItemBo;
import lk.ise.pos.dto.ItemDto;

import java.util.List;

public class ItemBoImpl implements ItemBo {
    @Override
    public boolean saveItem(ItemDto dto) {
        return false;
    }

    @Override
    public boolean updateItem(ItemDto dto) {
        return false;
    }

    @Override
    public ItemDto findItem(String id) {
        return null;
    }

    @Override
    public boolean deleteItem(String id) {
        return false;
    }

    @Override
    public List<ItemDto> findAllItems(String id) {
        return null;
    }
}
