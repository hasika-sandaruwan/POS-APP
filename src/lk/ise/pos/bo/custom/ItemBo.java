package lk.ise.pos.bo.custom;

import lk.ise.pos.bo.SuperBo;

import java.util.List;

public interface ItemBo extends SuperBo {
    public boolean saveItem(ItemDto dto);
    public boolean updateItem(ItemDto dto);
    public ItemDto findItem(String id);
    public boolean deleteItem(String id);
    public List<ItemDto> findAllItems(String id);
}
