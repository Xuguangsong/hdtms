package com.evergrande.hdtms.web.teacher;

import com.evergrande.hdtms.model.teacher.Task;
import com.evergrande.hdtms.model.teacher.modelPO.SearchTaskConditionPO;
import com.evergrande.hdtms.service.impl.teacher.TaskService;
import com.evergrande.hdtms.web.utils.AjaxResultPo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("api/task_center/client/")
public class SelectTaskController {
    @Autowired
    private TaskService taskService;

    private static Logger logger = LoggerFactory.getLogger(SelectTaskController.class);
    /**
     * @author yangxu
     * @return success message 所有任务的信息
     */
    @ResponseBody
    @RequestMapping("op_task_built")
    public AjaxResultPo getAllTask(){
        logger.info("进入控制器：getAllTask");
        List<Task> taskList = taskService.getAllTask();
        logger.info("total num : "+taskList.size());
        return new AjaxResultPo(true, taskList);
    }

    @ResponseBody
    @RequestMapping("op_task_built_condition")
    public AjaxResultPo getTaskByCondition(SearchTaskConditionPO searchTaskConditionPO){
        logger.info("进入控制器：getTaskByCondition");
        logger.info("searchTaskConditionPO : "+searchTaskConditionPO);
        List<Task> taskList = taskService.getTaskByCondition(searchTaskConditionPO);
        return new AjaxResultPo(true, taskList);
    }

}
