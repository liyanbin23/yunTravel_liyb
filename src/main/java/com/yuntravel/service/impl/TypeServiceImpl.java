package com.yuntravel.service.impl;


import com.yuntravel.dao.TypesMapper;
import com.yuntravel.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypesMapper typesMapper;

    public TypesMapper getTypesMapper() {
        return typesMapper;
    }

    public void setTypesMapper(TypesMapper typesMapper) {
        this.typesMapper = typesMapper;
    }

    @Override
    public String getNameById(int id) {
        return typesMapper.getNameById(id);
    }

    @Override
    public int getId(Float expen) {
        return typesMapper.getId(expen);
    }
}
