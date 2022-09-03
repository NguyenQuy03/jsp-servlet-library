package com.library.model;

public class BookModel extends AbstractModel<BookModel> {
	
	private String title;
	private String thumbnail;
	private String shortDescription;
	private String author;
	private String linkDownload;
	private Long categoryId;
	private String categoryCode;
	
	public String getTitle() {
		return title;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getLinkDownload() {
		return linkDownload;
	}
	public void setLinkDownload(String linkDownload) {
		this.linkDownload = linkDownload;
	}
}
