package com.prac.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageModel {

	private int total
				, page
				, count
				, pageIdx
				, limit
				, totalPage;
}