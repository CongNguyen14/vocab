package kits.learnvocab.dto;

import java.io.Serializable;

public class Connect_wordDto implements Serializable{
	private int id;
	private int name_vn_id;
	private int name_eng_id;
	private int name_kor_id;
	private int topic_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName_vn_id() {
		return name_vn_id;
	}
	public void setName_vn_id(int name_vn_id) {
		this.name_vn_id = name_vn_id;
	}
	public int getName_eng_id() {
		return name_eng_id;
	}
	public void setName_eng_id(int name_eng_id) {
		this.name_eng_id = name_eng_id;
	}
	public int getName_kor_id() {
		return name_kor_id;
	}
	public void setName_kor_id(int name_kor_id) {
		this.name_kor_id = name_kor_id;
	}
	public int getTopic_id() {
		return topic_id;
	}
	public void setTopic_id(int topic_id) {
		this.topic_id = topic_id;
	}
	public Connect_wordDto(int id, int name_vn_id, int name_eng_id, int name_kor_id, int topic_id) {
		super();
		this.id = id;
		this.name_vn_id = name_vn_id;
		this.name_eng_id = name_eng_id;
		this.name_kor_id = name_kor_id;
		this.topic_id = topic_id;
	}
	public Connect_wordDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
