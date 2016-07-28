package dmc.tm.service;

import static java.util.stream.Collectors.toList;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dmc.tm.dao.DayDao;
import dmc.tm.entity.Day;
import dmc.tm.exception.EntityNotFoundException;
import dmc.tm.vo.DayVo;

@Service
final class DayServiceImpl implements DayService {

	private final DayDao dao;

	@Autowired
	DayServiceImpl(DayDao repository) {
		this.dao = repository;
	}

	@Override
	public DayVo create(DayVo vo) {
		Date date = new Date();
		vo.setCreated(date);
		vo.setStart(date);
		vo.setEnd(date);

		Day entity = voToEntity(null, vo);

		entity = dao.save(entity);

		return convertToVo(entity);
	}

	@Override
	public DayVo update(DayVo vo) {
		Day entity = findDayById(vo.getId());
		entity = dao.save(entity);

		return convertToVo(entity);
	}

	@Override
	public DayVo delete(String id) {
		Day deleted = findDayById(id);
		dao.delete(deleted);

		return convertToVo(deleted);
	}

	@Override
	public List<DayVo> findAll() {
		List<Day> DayEntries = dao.findAll();

		return convertToVos(DayEntries);
	}

	@Override
	public List<DayVo> find(String idUser, Date start, Date end) {
		List<Day> entities = dao.find(idUser, start, end);

		return convertToVos(entities);
	}

	public Day voToEntity(Day entity, DayVo vo) {
		if (entity == null) {
			entity = new Day();
		}

		entity.setId(vo.getId());
		entity.setIdUser(vo.getIdUser());
		entity.setStart(vo.getStart());
		entity.setEnd(vo.getEnd());
		entity.setTitle(vo.getTitle());
		entity.setDescription(vo.getDescription());
		entity.setCreated(vo.getCreated());

		return entity;
	}

	private List<DayVo> convertToVos(List<Day> models) {
		return models.stream().map(this::convertToVo).collect(toList());
	}

	@Override
	public DayVo findById(String id) {
		Day entity = findDayById(id);

		return convertToVo(entity);
	}

	private Day findDayById(String id) {
		Optional<Day> result = dao.findOne(id);
		return result.orElseThrow(() -> new EntityNotFoundException(id));

	}

	private DayVo convertToVo(Day entity) {
		DayVo vo = new DayVo();

		vo.setId(entity.getId());
		vo.setIdUser(entity.getIdUser());
		vo.setStart(entity.getStart());
		vo.setEnd(entity.getEnd());
		vo.setTitle(entity.getTitle());
		vo.setDescription(entity.getDescription());
		vo.setCreated(entity.getCreated());

		return vo;
	}

}
