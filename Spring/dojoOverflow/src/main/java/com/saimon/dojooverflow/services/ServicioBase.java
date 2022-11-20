package com.saimon.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saimon.dojooverflow.repositories.RepositorioBase;

@Service
public abstract class ServicioBase<T> {
	private final RepositorioBase<T> repositorioBase;
	
	public ServicioBase(RepositorioBase<T> repositorioBase) {
		this.repositorioBase = repositorioBase;
	}
	
	public List<T> listado(){
		return repositorioBase.findAll();
	}
	
	public T buscarPorID(Long id) {
		Optional<T> optional = repositorioBase.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
	
	public T guardar(T o) {
		return repositorioBase.save(o);
	}
}
