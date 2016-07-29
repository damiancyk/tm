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
import dmc.tm.service.ItemService;
import dmc.tm.utils.DateUtils;
import dmc.tm.vo.ItemVo;

@RestController
@RequestMapping("/api/day")
final class ItemRest {

	private final ItemService service;

	@Autowired
	ItemRest(ItemService service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	ItemVo create(@RequestBody @Valid ItemVo vo) {
		return service.create(vo);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	ItemVo delete(@PathVariable("id") String id) {
		return service.delete(id);
	}

	@RequestMapping(method = RequestMethod.GET)
	List<ItemVo> findAll() {
		return service.findAll();
	}

	@RequestMapping(value = "/{idUser}/{start}/{end}", method = RequestMethod.GET)
	List<ItemVo> find(@PathVariable("idUser") String idUser, @PathVariable("start") Long start,
			@PathVariable("end") Long end) {
		return service.find(idUser, DateUtils.getDate(start), DateUtils.getDate(end));
	}

	@RequestMapping(value = "{id}", method = RequestMethod.GET)
	ItemVo findById(@PathVariable("id") String id) {
		return service.findById(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	ItemVo update(@RequestBody @Valid ItemVo vo) {
		return service.update(vo);
	}

	@ExceptionHandler
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public void handleTodoNotFound(EntityNotFoundException ex) {
	}

}
