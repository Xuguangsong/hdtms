package com.evergrande.hdtms.mapper.teacher;

import java.util.List;

import com.evergrande.hdtms.model.teacher.TaskUsing;
import com.evergrande.hdtms.model.teacher.TaskUsingExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Component
public interface TaskUsingMapper {
    int countByExample(TaskUsingExample example);

    int deleteByExample(TaskUsingExample example);

    int deleteByPrimaryKey(Integer tPkId);

    int insert(TaskUsing record);

    int insertSelective(TaskUsing record);

    List<TaskUsing> selectByExample(TaskUsingExample example);

    TaskUsing selectByPrimaryKey(Integer tPkId);

    int updateByExampleSelective(@Param("record") TaskUsing record, @Param("example") TaskUsingExample example);

    int updateByExample(@Param("record") TaskUsing record, @Param("example") TaskUsingExample example);

    int updateByPrimaryKeySelective(TaskUsing record);

    int updateByPrimaryKey(TaskUsing record);
}