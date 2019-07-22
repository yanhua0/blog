package org.url.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.url.entity.Myblog;
import org.url.service.MyblogService;
import org.url.title.GetHtmlTitle;

import java.util.Date;
import java.util.List;


@Controller
@RequestMapping(value = "/")
public class MyBlogController {
    @Autowired
    private MyblogService myblogService;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String findAll(Model model)
    {
          List<Myblog> myblog=myblogService.findAll();
          model.addAttribute("myblog",myblog);
          return "list";
    }
    @RequestMapping(value = "/del",method = RequestMethod.GET)
    public String delete(Myblog myblog)
    {
        Myblog myblog1=myblogService.findById(myblog.getId());
        if(myblog1!=null)
        {
            myblogService.delete(myblog);
            return "redirect:/";
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/find",method = RequestMethod.GET)
    public String findByTitle(Myblog myblog,Model model)
    {
        List<Myblog> list=myblogService.findByTitle(myblog);
        model.addAttribute("ser",myblog.getTitle());
        model.addAttribute("myblog",list);
        return "list";
    }
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    @ResponseBody
    public Myblog save(Myblog myblog,Model model)
    {
        Myblog m=myblogService.findByURL(myblog);
        if(m==null)
        {
            String t=GetHtmlTitle.GetHtmlTitle(myblog.getUrl());
            myblog.setTitle(t);
            myblog.setCreateTime(new Date());
            myblogService.save(myblog);
            return m;
        }
       return m;
        }
}
