package lk.ise.pos.bo.custom;

import java.util.List;

public interface ItemBo {
    public boolean saveItem(ItemDto dto);
    public boolean updateItem(ItemDto dto);
    public ItemDto findItem(String id);
    public boolean deleteItem(String id);
    public List<ItemDto> findAllItems(String id);
}
