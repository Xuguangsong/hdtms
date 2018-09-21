package com.evergrande.hdtms.mapper.basis;

import com.evergrande.hdtms.model.basis.projectReviewLog;

public interface projectReviewLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(projectReviewLog record);

    int insertSelective(projectReviewLog record);

    projectReviewLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(projectReviewLog record);

    int updateByPrimaryKey(projectReviewLog record);
}