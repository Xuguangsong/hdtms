package com.evergrande.hdtms.web.teacher;

import com.evergrande.hdtms.common.Idkey;
import com.evergrande.hdtms.model.teacher.Task;
import com.evergrande.hdtms.model.teacher.TaskUsing;
import com.evergrande.hdtms.service.impl.teacher.TaskService;
import com.evergrande.hdtms.web.utils.AjaxResultPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("api/task_center/client/")
public class TaskAssigned {
    @Autowired
    private TaskService taskService;

    private static Logger logger = LoggerFactory.getLogger(SelectTaskController.class);

    @ResponseBody
    @RequestMapping("op_task_assigned")
    public AjaxResultPo TaskAssigned(String tTaskId, String tTutorId,String tName,String StuName,String tStartDate) throws ParseException {
        logger.info("进入控制器：op_add_task"+tTaskId+tName+tTutorId+StuName+tStartDate);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        TaskUsing record = new TaskUsing();
        record.settTaskId(tTaskId);
        record.settTutorId(tTutorId);
        record.settName(tName);
        record.settStuId("vw14344t42b");
        record.settStartDate(sdf.parse(tStartDate));
        int res = taskService.insertUsing(record);
        logger.info("msg : "+ res);
        return new AjaxResultPo(true, res);
    }
}
