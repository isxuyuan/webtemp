package com.lyt.webtemp;

import java.io.Serializable;

public class Video implements Serializable {

	private String id;
	private String cid;
	private String vname;
	private String description;
	private String imgurl;
	private String imgurlother;
	private String vurl;
	private String vurlback;
	private Double size;
	private Double longtime;
	private Integer count;
	private Integer gevaluate;
	private Integer bevaluate;
	private String author;

	public String getId() {
	
		return id;
	}
	public void setId( String  id) {
		
		this.id = id;
	}
	public String getCid() {
	
		return cid;
	}
	public void setCid( String  cid) {
		
		this.cid = cid;
	}
	public String getVname() {
	
		return vname;
	}
	public void setVname( String  vname) {
		
		this.vname = vname;
	}
	public String getDescription() {
	
		return description;
	}
	public void setDescription( String  description) {
		
		this.description = description;
	}
	public String getImgurl() {
	
		return imgurl;
	}
	public void setImgurl( String  imgurl) {
		
		this.imgurl = imgurl;
	}
	public String getImgurlother() {
	
		return imgurlother;
	}
	public void setImgurlother( String  imgurlother) {
		
		this.imgurlother = imgurlother;
	}
	public String getVurl() {
	
		return vurl;
	}
	public void setVurl( String  vurl) {
		
		this.vurl = vurl;
	}
	public String getVurlback() {
	
		return vurlback;
	}
	public void setVurlback( String  vurlback) {
		
		this.vurlback = vurlback;
	}
	public Double getSize() {
	
		return size;
	}
	public void setSize( Double  size) {
		
		this.size = size;
	}
	public Double getLongtime() {
	
		return longtime;
	}
	public void setLongtime( Double  longtime) {
		
		this.longtime = longtime;
	}
	public Integer getCount() {
	
		return count;
	}
	public void setCount( Integer  count) {
		
		this.count = count;
	}
	public Integer getGevaluate() {
	
		return gevaluate;
	}
	public void setGevaluate( Integer  gevaluate) {
		
		this.gevaluate = gevaluate;
	}
	public Integer getBevaluate() {
	
		return bevaluate;
	}
	public void setBevaluate( Integer  bevaluate) {
		
		this.bevaluate = bevaluate;
	}
	public String getAuthor() {
	
		return author;
	}
	public void setAuthor( String  author) {
		
		this.author = author;
	}
}	