package demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Aplicacion {

	private static final Logger log = LoggerFactory.getLogger(Aplicacion.class);

	public static void main(String[] args) {
		SpringApplication.run(Aplicacion.class, args);
	}

	@Bean
	public CommandLineRunner demo(ClienteRepositorio repositorio) {
		return (args) -> {
			// añade unos cuantos clientes
			repositorio.save(new Cliente("Luis", "Muñoz"));
			repositorio.save(new Cliente("Rafa", "Nadal"));
			repositorio.save(new Cliente("Javier", "Fernández"));
			repositorio.save(new Cliente("Fernando", "Alonso"));
			repositorio.save(new Cliente("David", "Muñoz"));

			// obtiene todos los clientes
			log.info("Clientes obtenidos con findAll():");
			log.info("-------------------------------");
			for (Cliente cliente : repositorio.findAll()) {
				log.info(cliente.toString());
			}
			log.info("");

			// obtiene un cliente por ID
			Cliente cliente = repositorio.findOne(1L);
			log.info("Cliente obtenido con findOne(1L):");
			log.info("--------------------------------");
			log.info(cliente.toString());
			log.info("");

			// obtiene todos los clientes por apellidos
			log.info("Cliente obtenido con findByApellido('Muñoz'):");
			log.info("--------------------------------------------");
			for (Cliente bauer : repositorio.findByApellido("Muñoz")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}
