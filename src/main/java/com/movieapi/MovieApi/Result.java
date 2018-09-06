package com.movieapi.MovieApi;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Result {

	
	//private int count; 
	@JsonProperty("page")
	private String page;
	 @JsonProperty("total_Results")
	private Integer totalResults;
	 @JsonProperty("total_Pages")
	private Integer totalPages;
	 @JsonProperty("results")
	private ArrayList<Movie>results;
	public Result() {
		super(); 
		// TODO Auto-generated constructor stub
	}
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public Integer getTotalResults() {
		return totalResults;
	}
	public void setTotalResults(Integer totalResults) {
		this.totalResults = totalResults;
	}
	public Integer getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}
	public ArrayList<Movie> getResults() {
		return results;
	}
	public void setResults(ArrayList<Movie> results) {
		this.results = results;
	}
	@Override
	public String toString() {
		return "Result [page=" + page + ", totalResults=" + totalResults + ", totalPages=" + totalPages + ", results="
				+ results + "]";
	}
	
	
	
	
}
