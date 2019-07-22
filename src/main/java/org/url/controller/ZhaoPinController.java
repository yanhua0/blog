package org.url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.url.entity.ZhaoPin;
import org.url.service.ZhaoPinService;
import org.url.title.GetHtmlTitle;

import java.util.Date;
import java.util.List;

@Controller
public class ZhaoPinController {
    @Autowired
    private ZhaoPinService zhaoPinService;
    @RequestMapping(value = "/zp",method = RequestMethod.GET)
    public String findAll1(Model model)
    {
        List<ZhaoPin> myblog=zhaoPinService.findAll();
        model.addAttribute("myblog",myblog);
        return "zp";
    }
    @RequestMapping(value = "/del1",method = RequestMethod.GET)
    public String delete1(ZhaoPin zhaoPin)
    {
        ZhaoPin zhaoPin1=zhaoPinService.findById(zhaoPin.getId());
        if(zhaoPin1!=null)
        {
            zhaoPinService.delete(zhaoPin);
            return "redirect:/zp";
        }
        return "redirect:/zp";
    }
    @RequestMapping(value = "/find1",method = RequestMethod.GET)
    public String findByTitle1(ZhaoPin zhaoPin,Model model)
    {
        List<ZhaoPin> list=zhaoPinService.findByTitle(zhaoPin);
        model.addAttribute("ser",zhaoPin.getTitle());
        model.addAttribute("myblog",list);
        return "zp";
    }
    @RequestMapping(value = "/save1",method = RequestMethod.GET)
    @ResponseBody
    public ZhaoPin save1(ZhaoPin zhaoPin,Model model)
    {
        ZhaoPin zhaoPin1=zhaoPinService.findByURL(zhaoPin);
        if(zhaoPin1==null)
        {
            String t= GetHtmlTitle.GetHtmlTitle(zhaoPin.getUrl());
            zhaoPin.setTitle(t);
            zhaoPin.setCreateTime(new Date());
            zhaoPinService.save(zhaoPin);
            return zhaoPin1;
        }
        return zhaoPin1;
    }
}
