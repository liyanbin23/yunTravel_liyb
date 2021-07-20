package com.yuntravel.dao;

import com.yuntravel.po.Grade;

public interface SightsGradeMapper {

    int addGrade(Grade grade);

    int getMaxGradeId();

    Float getAvgGradeBySightsId();

}
