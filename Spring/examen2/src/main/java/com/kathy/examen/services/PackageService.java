package com.kathy.examen.services;

import org.springframework.stereotype.Service;

import com.kathy.examen.models.Pack;
import com.kathy.examen.repositories.PackageRepository;

@Service
public class PackageService extends BaseService<Pack>{
    private final PackageRepository packageRepository;

    public PackageService(PackageRepository packageRepository){
        super(packageRepository);
        this.packageRepository = packageRepository;
    }

    public Pack findPackage(String name) {
		return packageRepository.findByNameContaining(name);
	}

}
