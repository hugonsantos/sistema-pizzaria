package DB;

public class DbIntegridadeExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DbIntegridadeExcecao(String msg) {
		super(msg);
	}
}
