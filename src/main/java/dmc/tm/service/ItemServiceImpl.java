package dmc.tm.service;

import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dmc.tm.dao.ItemDao;
import dmc.tm.entity.Item;
import dmc.tm.exception.EntityNotFoundException;
import dmc.tm.utils.DateUtils;
import dmc.tm.vo.ItemVo;

@Service
final class ItemServiceImpl implements ItemService {

	private final ItemDao dao;

	@Autowired
	ItemServiceImpl(ItemDao repository) {
		this.dao = repository;
	}

	@Override
	public ItemVo create(ItemVo vo) {
		Date date = new Date();
		vo.setCreated(date);

		Item entity = voToEntity(null, vo);

		entity = dao.save(entity);

		return convertToVo(entity);
	}

	@Override
	public ItemVo update(ItemVo vo) {
		Item entity = findEntityById(vo.getId());
		entity = voToEntity(entity, vo);
		entity = dao.save(entity);

		return convertToVo(entity);
	}

	@Override
	public ItemVo delete(String id) {
		Item entity = findEntityById(id);
		dao.delete(entity);

		return convertToVo(entity);
	}

	@Override
	public List<ItemVo> findAll() {
		List<Item> entities = dao.findAll();

		return convertToVos(entities);
	}

	@Override
	public List<ItemVo> find(String idUser, Date start, Date end) {
		List<Item> entities = dao.find(idUser, start, end);

		return convertToVos(entities);
	}

	public Item voToEntity(Item entity, ItemVo vo) {
		if (entity == null) {
			entity = new Item();
		}

		entity.setId(vo.getId());
		entity.setIdUser(vo.getIdUser());

		Date start = vo.getStart();
		Date end = vo.getEnd();

		entity.setStart(start);
		entity.setEnd(end);
		entity.setDiff(DateUtils.getDiff(start, end));

		entity.setTitle(vo.getTitle());
		entity.setDescription(vo.getDescription());
		entity.setCreated(vo.getCreated());

		return entity;
	}

	private List<ItemVo> convertToVos(List<Item> models) {
		return models.stream().map(this::convertToVo).collect(toList());
	}

	@Override
	public ItemVo findById(String id) {
		Item entity = findEntityById(id);

		return convertToVo(entity);
	}

	private Item findEntityById(String id) {
		Optional<Item> result = dao.findOne(id);
		return result.orElseThrow(() -> new EntityNotFoundException(id));

	}

	private ItemVo convertToVo(Item entity) {
		ItemVo vo = new ItemVo();

		vo.setId(entity.getId());
		vo.setIdUser(entity.getIdUser());
		vo.setStart(entity.getStart());
		vo.setEnd(entity.getEnd());
		vo.setStartDay(DateUtils.dateToStr(DateUtils.setZeroTimePart((entity.getStart()))));
		vo.setEndDay(DateUtils.dateToStr(entity.getEnd()));
		vo.setTitle(entity.getTitle());
		vo.setDescription(entity.getDescription());
		vo.setCreated(entity.getCreated());

		return vo;
	}

}
