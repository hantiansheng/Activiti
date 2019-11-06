package com.peppa.activiti.app.delegate;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.Expression;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @auther: hantiansheng
 * @date: 2019/11/6
 * @description:
 */
public class ToUpperCaseFieldInjected implements JavaDelegate {
    private Expression text;

    @Override
    public void execute(DelegateExecution execution) {
        execution.setVariable("var", ((String)text.getValue(execution)).toUpperCase());
    }
}
