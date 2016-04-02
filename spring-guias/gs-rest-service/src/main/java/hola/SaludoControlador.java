package hola;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoControlador {

	private static final String plantilla = "¡Hola, %s!";
	private final AtomicLong contador = new AtomicLong();

	@RequestMapping("/saludo")
	public Saludo saludo(@RequestParam(value = "nombre", defaultValue = "Mundo") String nombre) {
		return new Saludo(contador.incrementAndGet(), String.format(plantilla, nombre));
	}
}
