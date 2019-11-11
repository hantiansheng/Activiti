package com.peppa.activiti.app.controller.common;

import com.peppa.activiti.app.controller.BaseController;
import com.peppa.activiti.app.controller.task.TaskTestController;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: hantiansheng
 * @date: 2019/11/9
 * @description:
 */
@RestController
@RequestMapping("/common")
public class CommonController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonController.class);

    private static final String PROCESS_DEFINITION_KEY = "parallel_gateway";

    @PostMapping("/deploy/{deploymentId}")
    public String deploy(@PathVariable(name = "deploymentId") String deploymentId) {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("processes/" + deploymentId + ".bpmn20.xml")
                .deploy();
        LOGGER.info("Number of deploy id : {}", deploy.getId());
        return deploy.getId();
    }


    @PostMapping("/start")
    public String start() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("startValue", 22222);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);

        LOGGER.info("Number of processInstanceId : {}", processInstance.getProcessInstanceId());
        return processInstance.getProcessInstanceId();
    }

    @PostMapping("/completeUserTaskOne")
    public void completeUserTaskOne() {
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .list();
        for (Task task : tasks) {
            LOGGER.info("Task available: {}", task.getName());
            if ("user task one".equals(task.getName())) {
                taskService.complete(task.getId());
                LOGGER.info("user task one completed ,task id : {}", task.getId());
            }
        }
    }



    @PostMapping("/completeUserTaskTwo")
    public void completeUserTaskTwo() {
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_DEFINITION_KEY)
                .list();
        for (Task task : tasks) {
            LOGGER.info("Task available: {}", task.getName());
            if ("user task two".equals(task.getName())) {
                taskService.complete(task.getId());
                LOGGER.info("user task two completed ,task id : {}", task.getId());
            }
        }
    }
}
