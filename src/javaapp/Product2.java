package javaapp;

public class Product2 {
	private String image;
	private String age;
	private String kindCd;
	private String sexCd;
	private String happenDt;
	private String happenPlace;
	private String careNm;

	public Product2(String image, String age, String kindCd, String sexCd, String happenDt, String happenPlace,
			String careNm) {
		this.image = image;
		this.age = age;
		this.kindCd = kindCd;
		this.sexCd = sexCd;
		this.happenDt = happenDt;
		this.happenPlace = happenPlace;
		this.careNm = careNm;
	}
	public String getage() {
		return age;
	}
	public String getcareNm() {
		return careNm;
	}
	public String gethappenDt() {
		return happenDt;
	}
	public String gethappenPlace() {
		return happenPlace;
	}
	public String getkindCd() {
		return kindCd;
	}
	public String getMyImage() {
		return image;
	}
	public String getsexCd() {
		return sexCd;
	}
}
