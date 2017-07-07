package com.zhangmingshuai;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.spi.resource.Singleton;
import com.sun.xml.bind.v2.schemagen.xmlschema.List;
/**
 * 
 * CreateDate：2017-4-20下午01:53:08
 * Location：HIT
 * Author: Zhang Mingshuai
 * TODO
 * return
 */

@Path("books")
@Singleton

public class BooksResource {

	private HashMap<Integer, Book> myBook;
	public BooksResource(){		//构造时，便向本来是空的书库中添加一本书
		myBook = new HashMap<Integer, Book>();
		Book oneBook = new Book();
		oneBook.setId(1);
		oneBook.setauthor("奥巴马");
		oneBook.setName("美国历史");
		myBook.put(1, oneBook);
	}

	@GET
	@Path("all")
	@Produces("application/xml")
	public ArrayList<Book> getBooks() {		//获取全部书籍信息
		Set<Integer> keyIntegers = myBook.keySet();
		ArrayList<Book> result = new ArrayList<Book>();
		for(Integer k:keyIntegers){
			result.add(myBook.get(k));
		}
		return result;
	}
	
	@GET
	@Path("test")
	@Produces("application/json")
	public String test() {		//获取全部书籍信息
		return "hello";
	}

	@GET
	@Path("{id}")
	@Produces("application/xml")
	public Book getOneBook(@PathParam("id") int id) {	//以xml格式返回指定id对应的书籍信息
		return myBook.get(id);
	}


	@GET
	@Path("add")
	@Produces("application/json")
	public JSONObject addBooks(@QueryParam("id") String id,	//以json格式返回我要添加的书籍的信息（通过queryParam进行添加）
			@QueryParam("name") String name, @QueryParam("author") String author) {
		Book aBook = new Book();
		aBook.setId(Integer.valueOf(id));
		aBook.setName(name);
		aBook.setauthor(author);
		myBook.put(Integer.valueOf(id), aBook);
		JSONObject back = new JSONObject();
		try {
			back.put("id:", id);
			back.put("book_name:", name);
			back.put("author_name:", author);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return back;
	}

}