package com.qk.community.mapper;

import com.qk.community.dto.QuestionDTO;
import com.qk.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {
    @Insert("insert into question (title, description, gmt_create, gmt_modified,creator,tag) values (#{title}, #{description},#{gmtCreate},#{gmtModified},#{creator},#{tag})")
    void create(Question question);

    @Select("select * from question limit ${size} offset ${offsize};")
    List<Question> list(Integer offsize, Integer size);

    @Select("select * from question where creator = ${id} limit ${size} offset ${offsize};")
    List<Question> listByCreator(Integer id, Integer offsize, Integer size);

    @Select("select count(1) from question")
    Integer count();

    @Select("select count(1) from question where creator = ${userId}")
    Integer countByUserId(Integer userId);

    @Select("select * from question where id = ${id}")
    Question getById(Integer id);
}