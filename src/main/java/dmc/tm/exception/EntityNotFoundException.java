package dmc.tm.exception;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EntityNotFoundException(String id) {
		super(String.format("Entity not found with id: <%s>", id));
	}

}
