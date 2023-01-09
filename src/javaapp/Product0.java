package javaapp;

public class Product0 {

	private String careAddr;
	private String careNm;
	private String careTel;

	public Product0(String careNm, String careAddr, String careTel) {

		this.careNm = careNm;
		this.careAddr = careAddr;
		this.careTel = careTel;

	}

	public String getcareNm() {
		return careNm;
	}
	public String getcareAddr() {
		return careAddr;
	}
	public String getcareTel() {
		return careTel;
	}
}
