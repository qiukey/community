package com.qk.community.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private Integer page;
    private boolean showPrevious;
    private boolean showFirstPage;
    private boolean showNext;
    private boolean showLastPage;
    private List<Integer> pages = new ArrayList<>();
    private Integer totalPage;
    private Integer size;

    public void setPagination(Integer totalPage, Integer page, Integer size) {

        this.size=size;
        this.totalPage = totalPage;
        this.page = page;

        pages.add(page);
        for (int i=1;i<=3;i++) {
            if(page-i>0) {
                pages.add(0, page-i);
            }
            if (page+i <= totalPage){
                pages.add(page+i);
            }
        }

        //是否展示上一页
        showPrevious = page == 1 ? false : true;
        //是否展示下一页
        showNext = page == totalPage ? false : true;
        //是否展示第一页
        showFirstPage = pages.contains(1) ? false : true;
        //是否展示最后一页
        showLastPage = pages.contains(totalPage) ? false : true;
    }
}
