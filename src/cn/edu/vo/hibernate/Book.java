package cn.edu.vo.hibernate;
// Generated 2017-3-14 11:40:33 by Hibernate Tools 3.5.0.Final

import java.math.BigDecimal;
import java.util.Date;

/**
 * Book generated by hbm2java
 */
public class Book implements java.io.Serializable {

	private String id;
	private String bookName;
	private String category;
	private String keyword;
	private String description;
	private Date createTime;
//	private String userId;
	private User user;
	private BigDecimal price;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

//	public String getUserId() {
//		return this.userId;
//	}
//
//	public void setUserId(String userId) {
//		this.userId = userId;
//	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
