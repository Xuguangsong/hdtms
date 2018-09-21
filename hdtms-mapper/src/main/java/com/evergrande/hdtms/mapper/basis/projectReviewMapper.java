package com.evergrande.hdtms.mapper.basis;


import com.evergrande.hdtms.model.basis.projectReview;

public interface projectReviewMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(projectReview record);

    int insertSelective(projectReview record);

    projectReview selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(projectReview record);

    int updateByPrimaryKey(projectReview record);
}