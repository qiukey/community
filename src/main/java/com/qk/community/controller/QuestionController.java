package com.qk.community.controller;

import com.qk.community.dto.QuestionDTO;
import com.qk.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class QuestionController {
    @Autowired
    private QuestionService questionService;
    @GetMapping("/question/{qid}")
    public String question(@PathVariable(name = "qid", value = "") Integer qid,
                           Model model) {
        QuestionDTO questionDTO = questionService.getById(qid);
        model.addAttribute("question", questionDTO);
        return "question";
    }
}
