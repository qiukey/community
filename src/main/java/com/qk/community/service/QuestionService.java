package com.qk.community.service;

import com.qk.community.dto.PaginationDTO;
import com.qk.community.dto.QuestionDTO;
import com.qk.community.mapper.QuestionMapper;
import com.qk.community.mapper.UserMapper;
import com.qk.community.model.Question;
import com.qk.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO list(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.count();
        Integer totalPage;
        totalPage = totalCount%size == 0 ? totalCount/size : totalCount/size +1;

        if (page<1) {page = 1;}
        if (page>totalPage) {page = totalPage;}
        paginationDTO.setPagination(totalPage, page, size);

        //size*(page-1)
        Integer offsize = size*(page-1);
        List<Question> questions = questionMapper.list(offsize, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);


        return paginationDTO;
    }

    public PaginationDTO list(Integer id, Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalCount = questionMapper.countByUserId(id);
        Integer totalPage;
        totalPage = totalCount%size == 0 ? totalCount/size : totalCount/size +1;

        if (page<1) {page = 1;}
        if (page>totalPage) {page = totalPage;}

        paginationDTO.setPagination(totalPage, page, size);
        //size*(page-1)
        Integer offsize = size*(page-1);
        List<Question> questions = questionMapper.listByCreator(id, offsize, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Question question : questions) {
            User user = userMapper.findById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);


        return paginationDTO;
    }

    public QuestionDTO getById(Integer id) {
        QuestionDTO questionDTO = new QuestionDTO();
        Question question = questionMapper.getById(id);
        BeanUtils.copyProperties(question, questionDTO);
        User user = userMapper.findById(question.getCreator());
        questionDTO.setUser(user);

        return questionDTO;
    }
}
