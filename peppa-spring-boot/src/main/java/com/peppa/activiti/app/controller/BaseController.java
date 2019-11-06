package com.peppa.activiti.app.controller;

import org.activiti.engine.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther: hantiansheng
 * @date: 2019/11/6
 * @description:
 */
public class BaseController {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected IdentityService identityService;

    @Autowired
    protected RepositoryService repositoryService;

    @Autowired
    protected ProcessEngine processEngine;

    @Autowired
    protected HistoryService historyService;
}
