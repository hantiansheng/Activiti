package com.peppa.activiti.app.controller.task;

import com.peppa.activiti.app.controller.BaseController;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther: hantiansheng
 * @date: 2019/11/6
 * @description:
 */
@RestController
@RequestMapping("/task")
public class TaskTestController extends BaseController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskTestController.class);

    private static final String PROCESS_DEFINITION_KEY = "task_test";

    @PostMapping("/deploy")
    public void deploy() {
        Deployment deploy = repositoryService.createDeployment()
                .addClasspathResource("processes/task_test.bpmn20.xml")
                .deploy();
        LOGGER.info("Number of deploy id : {}", deploy.getId());
    }


    @PostMapping("/start")
    public void start() {
        Map<String, Object> variables = new HashMap<>();
        variables.put("startValue", 22222);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_DEFINITION_KEY, variables);

        LOGGER.info("Number of processInstanceId : {}", processInstance.getProcessInstanceId());
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
