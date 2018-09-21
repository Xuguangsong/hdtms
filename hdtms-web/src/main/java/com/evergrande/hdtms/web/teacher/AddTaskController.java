package com.evergrande.hdtms.web.teacher;

import com.alibaba.fastjson.JSONObject;
import com.evergrande.hdtms.common.Idkey;
import com.evergrande.hdtms.model.teacher.Task;
import com.evergrande.hdtms.service.impl.teacher.TaskService;
import com.evergrande.hdtms.web.utils.AjaxResultPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//import net.sf.json.JSONObject;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("api/task_center/client/")
public class AddTaskController {
    @Autowired
    private TaskService taskService;

    private static Logger logger = LoggerFactory.getLogger(SelectTaskController.class);

    @ResponseBody
    @RequestMapping("op_add_task")
    public AjaxResultPo addTask(String tName, Integer  tTime, String tContent){
        logger.info("进入控制器：op_add_task"+tName+tTime+tContent);
        Task record=new Task();
        record.settTaskId(Idkey.uuid());
        record.settTutorId(Idkey.uuid());
        record.settState(1);
        record.settName(tName);
        record.settTime(tTime);
        record.settContent(tContent);
        record.settCreater("121");
        record.settCreateTime(new Date());
        record.settOperateDate(new Date());
        record.settOperator("121");
        taskService.insert(record);
        return new AjaxResultPo(true);
    }
}
