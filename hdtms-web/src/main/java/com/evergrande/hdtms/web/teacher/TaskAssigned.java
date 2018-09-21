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
import java.util.Calendar;
import java.util.Date;

@Controller
@RequestMapping("api/task_center/client/")
public class TaskAssigned {
    @Autowired
    private TaskService taskService;

    private static Logger logger = LoggerFactory.getLogger(SelectTaskController.class);

    @ResponseBody
    @RequestMapping("op_task_assigned")
    public AjaxResultPo TaskAssigned(String tTaskId, String tStuId,String tStartDate) throws ParseException {
        logger.info("进入控制器：op_task_assigned"+tTaskId+tStuId+tStartDate);
        TaskUsing taskUsing = TtoTU(tTaskId, tStuId,tStartDate);
        taskService.insertUsing(taskUsing);
        return new AjaxResultPo(true);
    }
    public TaskUsing TtoTU(String tTaskId, String tStuId,String tStartDate ) throws ParseException {
        SimpleDateFormat format  = new SimpleDateFormat("yyyy-MM-dd");
        TaskUsing record = new TaskUsing();
        Task task = taskService.selectBytTaskId(tTaskId);
        record.settTaskId(tTaskId);
        record.settTutorId(task.gettTutorId());
        record.settStuId(tStuId);
        record.settName(task.gettName());
        record.settCategory(task.gettCategory());
        record.settContent(task.gettContent());
        record.settProgress(0);
        record.settTime(task.gettTime());
        Date TStartDate = format.parse(tStartDate);
        record.settStartDate(TStartDate);
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.DATE, task.gettTime());// num为增加的天数，可以改变的
        TStartDate = ca.getTime();
        record.settExpirationDate(TStartDate);
        record.settCreater(task.gettCreater());
        record.settCreateTime(new Date());
        record.settOperator(task.gettCreater());
        record.settOperateDate(new Date());
        return  record;
    }
}
