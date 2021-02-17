package com.prac.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageModel {

	int total;
    int page;
    int count;
    int pageIdx;
    int limit;
    int totalPage;
	
}