package kr.co.domain;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

public class TestDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tnum;
	private String id;
	private String did;
	private String title;
	private String content;
	private Date writeday;
	private String name;
	private String dname;
	
	public TestDTO() {
		// TODO Auto-generated constructor stub
	}

	public TestDTO(int tnum, String id, String did, String title, String content, Date writeday, String name,
			String dname) {
		super();
		this.tnum = tnum;
		this.id = id;
		this.did = did;
		this.title = title;
		this.content = content;
		this.writeday = writeday;
		this.name = name;
		this.dname = dname;
	}

	public int getTnum() {
		return tnum;
	}

	public void setTnum(int tnum) {
		this.tnum = tnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getWriteday() {
		return writeday;
	}

	public void setWriteday(Date writeday) {
		this.writeday = writeday;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + tnum;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestDTO other = (TestDTO) obj;
		if (tnum != other.tnum)
			return false;
		return true;
	}
	
	
	
}
