package hola;

public class Saludo {

	private final Long id;
	private final String contenido;

	public Saludo(Long id, String contenido) {
		super();
		this.id = id;
		this.contenido = contenido;
	}

	public Long getId() {
		return id;
	}

	public String getContenido() {
		return contenido;
	}
}
