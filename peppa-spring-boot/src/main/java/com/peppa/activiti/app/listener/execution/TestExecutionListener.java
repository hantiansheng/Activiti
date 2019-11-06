package com.peppa.activiti.app.listener.execution;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateHelper;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.Expression;
import org.springframework.stereotype.Component;

/**
 * @auther: hantiansheng
 * @date: 2019/11/6
 * @description:
 */
@Component("testExecutionListener")
public class TestExecutionListener implements ExecutionListener {
    @Override
    public void notify(DelegateExecution execution) {
        Expression inputExpression = DelegateHelper.getFieldExpression(execution, "input");
        Number input = (Number) inputExpression.getValue(execution);

        int result = input.intValue() * 100;

        Expression resultVarExpression = DelegateHelper.getFieldExpression(execution, "resultVar");
        execution.setVariable(resultVarExpression.getValue(execution).toString(), result);
    }
}
