package com.tunix70.crudv4.controller;

import com.tunix70.crudv4.model.Writer;
import com.tunix70.crudv4.repository.DAO.WriterDAOImpl;
import com.tunix70.crudv4.repository.WriterRepository;



import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository = new WriterDAOImpl();

    public List<Writer> getAll(){
        return writerRepository.getAll();
    }
    public Writer getById(Long id){
        return writerRepository.getById(id);
    }
    public Writer save(Writer writer){
        return writerRepository.save(writer);
    }
    public Writer update(Writer writer){
        return writerRepository.update(writer);
    }
    public void deleteById(Long id){
        writerRepository.deleteById(id);
    }
}
