package com.yuntravel.dao;

import org.apache.ibatis.annotations.Param;

public interface TypesMapper {

    String getNameById(@Param("typeId") int typeId);
    int getId(@Param("expen") Float expen);
}
