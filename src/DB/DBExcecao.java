package DB;

public class DBExcecao extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DBExcecao(String msg) {
		super(msg);
	}
}
