package com.library.paging;

import com.library.sort.Sorter;

public class Paging implements Pageable {
	
	private Integer page;
	private Integer maxPageItem;
	private Sorter sorter;
	
	public Paging(Integer page, Integer maxPageItem, Sorter sorter) {
		this.page = page;
		this.maxPageItem = maxPageItem;
		this.sorter = sorter;
	}
	
	@Override
	public Integer getPage() {
		return this.page;
	}

	@Override
	public Integer getOffset() {
		if (this.maxPageItem != null && this.page != null) {
			return (this.page - 1) * this.maxPageItem;
		}
		return null;
	}

	@Override
	public Integer getLimit() {
		return this.maxPageItem;
	}

	@Override
	public Sorter getSorter() {
		if(sorter != null) {
			return this.sorter;
		}
		return null;
	}

}
