package com.raul.demoopenapi.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class ApiPager<T> {
    private int pageNumber;
    private int size;
    private int lastPage;
    private List<T> content;

    public ApiPager(int pageNumber, int size, int lastPage, List<T> content) {
        this.pageNumber = pageNumber;
        this.size = size;
        this.lastPage = lastPage;
        this.content = content;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getLastPage() {
        return lastPage;
    }

    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }
}
