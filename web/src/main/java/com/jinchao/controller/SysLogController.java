package com.jinchao.controller;

import com.jinchao.dao.ISysLogDao;
import com.jinchao.domain.SysLog;
import com.jinchao.service.ISysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private ISysLogService iSysLogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<SysLog> sysLogList = iSysLogService.findAll();
        modelAndView.addObject("sysLogs",sysLogList);
        modelAndView.setViewName("syslog-list");
        return modelAndView;
    }
}
