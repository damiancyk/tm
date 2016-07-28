package dmc.tm.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dmc.tm.exception.EntityNotFoundException;
import dmc.tm.service.DayService;
import dmc.tm.utils.DateUtils;
import dmc.tm.vo.DayVo;

@RestController
@RequestMapping("/api/day")
final class DayRest {

	private final DayService service;

	@Autowired
	DayRest(DayService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	DayVo create(@RequestBody @Valid DayVo todoEntry) {
		DayVo vo = service.create(todoEntry);
		return vo;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	DayVo delete(@PathVariable("id") String id) {
		DayVo vo = service.delete(id);
		return vo;
	}

	@RequestMapping(method = RequestMethod.GET)
	List<DayVo> findAll() {
		List<DayVo> vos = service.findAll();
		return vos;
	}

	@RequestMapping(value = "/{idUser}/{start}/{end}", method = RequestMethod.GET)
	List<DayVo> find(@PathVariable("idUser") String idUser, @PathVariable("start") Long start,
			@PathVariable("end") Long end) {

		List<DayVo> vos = service.find(idUser, DateUtils.getDate(start), DateUtils.getDate(end));
		return vos;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	DayVo findById(@PathVariable("id") String id) {
		DayVo vo = service.findById(id);
		return vo;
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	DayVo update(@RequestBody @Valid DayVo todoEntry) {
		DayVo vo = service.update(todoEntry);
		return vo;
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleTodoNotFound(EntityNotFoundException ex) {
	}

}
