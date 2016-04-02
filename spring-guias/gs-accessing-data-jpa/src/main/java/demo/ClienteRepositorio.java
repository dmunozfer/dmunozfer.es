package demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepositorio extends CrudRepository<Cliente, Long> {

	List<Cliente> findByApellido(String apellido);
}
