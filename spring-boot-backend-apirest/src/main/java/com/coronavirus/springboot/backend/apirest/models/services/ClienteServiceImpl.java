package com.coronavirus.springboot.backend.apirest.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coronavirus.springboot.backend.apirest.models.dao.IClienteDao;
import com.coronavirus.springboot.backend.apirest.models.entity.Cliente;

@Service // componente de servicio se guarda en el contenedor de spring
public class ClienteServiceImpl implements IClienteService {

	@Autowired //permite inyectar una interface
	private IClienteDao clienteDao;
	
	@Override
	@Transactional(readOnly = true) //permite trabajar con transacciones; los metodos de JPA repository son transaccionables asi que podria omitirse
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return clienteDao.findById(id).orElse(null);  //Optional da varios metodos para manejar el contenido
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienteDao.deleteById(id);
		
	}

}
