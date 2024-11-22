package com.raul.demoopenapi.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PageableToApiPagerConverter {


    public static <T> ApiPager<T> fromPage(Page<T> page){
        Pageable pageable = page.getPageable();
        int lastPage = page.getTotalPages() + 1;
        int currentPage = pageable.getPageNumber() + 1;
        int pageSize =  page.getSize();
        List<T> content = page.getContent();
        return new ApiPager<>(currentPage, pageSize, lastPage,content);
    }
}
