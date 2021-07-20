package com.yuntravel.service;

import org.springframework.stereotype.Service;

@Service
public interface TypeService {

    String getNameById(int id);

    int getId(Float expen);

}
