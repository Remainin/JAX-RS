/**
 * 
 */
package com.zhangmingshuai;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * CreateDate：2017-4-20上午11:06:45 Location：HIT Author: Zhang Mingshuai TODO
 * return
 */

@XmlRootElement
public class Book {
	private int id;
	private String name;
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getauthor() {
		return author;
	}

	public void setauthor(String author) {
		this.author = author;
	}

}
