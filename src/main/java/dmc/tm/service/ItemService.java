package dmc.tm.service;

import java.util.Date;
import java.util.List;

import dmc.tm.vo.ItemVo;

public interface ItemService {

	ItemVo create(ItemVo vo);

	ItemVo delete(String id);

	List<ItemVo> findAll();

	ItemVo findById(String id);

	ItemVo update(ItemVo vo);

	List<ItemVo> find(String idUser, Date start, Date end);

}
