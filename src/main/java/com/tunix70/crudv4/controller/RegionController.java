package com.tunix70.crudv4.controller;

import com.tunix70.crudv4.model.Region;
import com.tunix70.crudv4.repository.Impl.RegionRepoImpl;
import com.tunix70.crudv4.repository.RegionRepository;


import java.util.List;

public class RegionController {
    private final RegionRepository regionRepository = new RegionRepoImpl();

    public List<Region> getAll(){
        return regionRepository.getAll();
    }
    public Region getById(Long id){
        return regionRepository.getById(id);
    }
    public Region save(Region region){
        return regionRepository.save(region);
    }
    public Region update(Region region){
        return regionRepository.update(region);
    }
    public void deleteById(Long id){
        regionRepository.deleteById(id);
    }
}


