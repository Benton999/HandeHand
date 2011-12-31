package com.handehand.app.dao;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * A backing bean for the main hotel search form. Encapsulates the criteria
 * needed to perform a hotel search.
 */
@XmlRootElement
public class SearchCriteria implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlAttribute
	public double getMaximumPrice() {
		return maximumPrice;
	}

	public void setMaximumPrice(double maximumPrice) {
		this.maximumPrice = maximumPrice;
	}

	private double maximumPrice;

	/**
	 * The user-provided search criteria for finding Hotels.
	 */
	private String searchString;

	/**
	 * The maximum page size of the Hotel result list
	 */
	private int pageSize;

	/**
	 * The current page of the Hotel result list.
	 */
	private int page;

	@XmlAttribute
	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	@XmlAttribute
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@XmlAttribute
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
}
