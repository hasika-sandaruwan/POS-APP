package lk.ise.pos.bo.custom;

import lk.ise.pos.bo.SuperBo;
import lk.ise.pos.dto.ItemDto;

import java.util.List;

public interface ItemBo extends SuperBo {
    public boolean saveItem(ItemDto dto) throws Exception;
    public boolean updateItem(ItemDto dto) throws Exception;
    public ItemDto findItem(String id) throws Exception;
    public boolean deleteItem(String id) throws Exception;
    public List<ItemDto> findAllItems(String id) throws Exception;
}
