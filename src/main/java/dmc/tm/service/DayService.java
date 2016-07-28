package dmc.tm.service;

import java.util.Date;
import java.util.List;

import dmc.tm.vo.DayVo;

public interface DayService {

	DayVo create(DayVo vo);

	DayVo delete(String id);

	List<DayVo> findAll();

	DayVo findById(String id);

	DayVo update(DayVo vo);

	List<DayVo> find(String idUser, Date start, Date end);

}
