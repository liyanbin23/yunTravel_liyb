package com.yuntravel.service;

import com.yuntravel.po.Grade;

public interface SightsGradeService {

    int addGrade(Grade grade);

    int getMaxGradeId();

    Float getAvgGradeBySightsId();


}
