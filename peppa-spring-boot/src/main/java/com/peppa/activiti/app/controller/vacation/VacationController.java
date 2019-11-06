package com.peppa.activiti.app.controller.vacation;

import com.peppa.activiti.app.controller.BaseController;
import com.peppa.activiti.app.domain.Apply;
import org.activiti.engine.*;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @auther: hantiansheng
 * @date: 2019/11/4
 * @description:
 */
@RestController
@RequestMapping("/vacation")
public class VacationController extends BaseController {


    @PostMapping("/apply")
//    @Transactional(rollbackFor = Exception.class)
    public boolean applyVacation(@RequestBody Apply apply) {
        //启动流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("vacation");
        //获取启动的流程信息
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();

        taskService.setAssignee(task.getId(), "admin");

        HashMap<String, Object> args = new HashMap<>();
        args.put("reason", apply.getReason());
        args.put("cavNum", apply.getCavNum());
        args.put("startDay", apply.getStartDay());
        args.put("cancelApply", apply.getCancelApply());
        taskService.complete(task.getId(), args);
        return true;
    }
}
