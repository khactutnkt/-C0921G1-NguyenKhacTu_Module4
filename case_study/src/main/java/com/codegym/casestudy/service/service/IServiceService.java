package com.codegym.casestudy.service.service;

import com.codegym.casestudy.model.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IServiceService {

    void save(Service service);

    Page<Service> findAllService(Pageable pageable);
}
