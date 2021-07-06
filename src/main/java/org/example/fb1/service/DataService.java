package org.example.fb1.service;

import org.example.fb1.model.Data;
import org.example.fb1.repository.DataRepository;
import org.springframework.stereotype.Service;

@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataService(DataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    public void postData(String content) {
        Data data = new Data();
        data.setContent(content);
        dataRepository.save(data);
    }

}
