package com.peppa.activiti.app.listener.task;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

/**
 * @auther: hantiansheng
 * @date: 2019/11/6
 * @description:
 */
public class SetAssignWhenComplete implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.setAssignee("test123");
    }
}
