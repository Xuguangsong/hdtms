package com.evergrande.hdtms.service.impl.teacher;

import com.evergrande.hdtms.mapper.teacher.TaskMapper;
import com.evergrande.hdtms.mapper.teacher.TaskUsingMapper;
import com.evergrande.hdtms.model.teacher.Task;
import com.evergrande.hdtms.model.teacher.TaskExample;
import com.evergrande.hdtms.model.teacher.TaskUsing;
import com.evergrande.hdtms.model.teacher.modelPO.SearchTaskConditionPO;
import com.evergrande.hdtms.service.api.teacher.ITaskService;
import com.evergrande.hdtms.common.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Service
public class TaskService implements ITaskService {

    @Resource
    TaskMapper taskMapper;
    @Resource
    TaskUsingMapper taskUsingMapper;

    private static Logger logger = LoggerFactory.getLogger(TaskService.class);

    /**
     * @author yangxu
     * @return 所有任务信息（我创建的任务）
     */
    @Override
    public List<Task> getAllTask() {
        logger.debug("进入service");
        return taskMapper.selectByExample(null);
    }

    /**
     * @author yangxu
     * @param searchTaskConditionPO
     * @return 带条件查询的任务信息
     */
    @Override
    public List<Task> getTaskByCondition(SearchTaskConditionPO searchTaskConditionPO) {
        logger.info("进入service getTaskByCondition");
        TaskExample taskExample = new TaskExample();
        TaskExample.Criteria criteria = taskExample.createCriteria();
        criteria.andTNameLike("%"+searchTaskConditionPO.getTaskName()+"%");
        try {
            if (!"".equals(searchTaskConditionPO.getStartDate()) && !"".equals(searchTaskConditionPO.getEndDate())){
                criteria.andTCreateTimeBetween(DateUtil.strToUtlDate(searchTaskConditionPO.getStartDate(),'-'),DateUtil.strToUtlDate(searchTaskConditionPO.getEndDate(),'-'));
            }else if(!"".equals(searchTaskConditionPO.getStartDate())){
                criteria.andTCreateTimeGreaterThan(DateUtil.strToUtlDate(searchTaskConditionPO.getStartDate(),'-'));
            }else if(!"".equals(searchTaskConditionPO.getEndDate())){
                criteria.andTCreateTimeLessThan(DateUtil.strToUtlDate(searchTaskConditionPO.getEndDate(),'-'));
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        String [] state = searchTaskConditionPO.getStateStr().split(",");
        List<Integer> lis = new ArrayList<Integer>();
        for (String str : state){
            lis.add(Integer.parseInt(str));
        }
        criteria.andTStateIn(lis);
        return taskMapper.selectByExample(taskExample);
    }

    @Override
    public int insert(Task record) {
        return taskMapper.insert(record);
    }

    @Override
    public int insertUsing(TaskUsing record) {
        return taskUsingMapper.insert(record);
    }

    @Override
    public Task selectBytTaskId(String tTaskId) {
        return taskMapper.selectBytTaskId(tTaskId);
    }

}
