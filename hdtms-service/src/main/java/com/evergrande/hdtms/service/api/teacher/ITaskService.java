package com.evergrande.hdtms.service.api.teacher;

import com.evergrande.hdtms.model.teacher.Task;
import com.evergrande.hdtms.model.teacher.TaskUsing;
import com.evergrande.hdtms.model.teacher.modelPO.SearchTaskConditionPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface ITaskService {
    /**
     * @author yangxu
     * @return 所有任务列表
     */
    public List<Task> getAllTask();

    /**
     * @author yangxu
     * @return 按条件查询任务
     */
    List<Task> getTaskByCondition(SearchTaskConditionPO searchTaskConditionPO);

    int insert(Task record);

    int insertUsing(TaskUsing record);

    Task selectBytTaskId(String tTaskId);
}
