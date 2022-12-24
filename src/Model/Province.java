package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Province implements Serializable {
	private int provinceCode;
	private String provinceName;
	
	public Province() {
		
	}
	public Province(int provinceCode, String provinceName) {
		this.provinceCode = provinceCode;
		this.provinceName = provinceName;
	}
	public int getProvinceCode() {
		return provinceCode;
	}
	public void setProvinceCode(int provinceCode) {
		this.provinceCode = provinceCode;
	}
	public String getProvinceName() {
		return provinceName;
	}
	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	@Override
	public String toString() {
		return "Province [provinceCode=" + provinceCode + ", provinceName=" + provinceName + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(provinceCode, provinceName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Province other = (Province) obj;
		return provinceCode == other.provinceCode && Objects.equals(provinceName, other.provinceName);
	}
	
	public static  ArrayList<Province> getProvinceList(){
		String [] arr = {
				"--Choose province--",
				"An Giang",
				"Ba Ria – Vung Tau",
				"Bac Lieu",
				"Bac Giang",
				"Bac Kan",
				"Bac Ninh",
				"Ben Tre",
				"Binh Duong",
				"Binh Dinh",
				"Binh Phuoc",
				"Binh Thuan",
				"Ca Mau",
				"Cao Bang",
				"Can Tho",
				"Da Nang",
				"Dak Lak",
				"Dak Nong",
				"Dien Bien",
				"Dong Nai",
				"Dong Thap",
				"Gia Lai",
				"Ha Giang",
				"Ha Nam",
				"Hanoi",
				"Ha Tinh",
				"Hai Duong",
				"Hai Phong",
				"Hau Giang",
				"Hoa Binh",
				"Hung Yen",
				"Khanh Hoa",
				"Kien Giang",
				"Kon Tum",
				"Lai Chau",
				"Lang Son",
				"Lao Cai",
				"Lam Dong",
				"Long An",
				"Nam Dinh",
				"Nghe An",
				"Ninh Binh",
				"Ninh Thuan",
				"Phu Tho",
				"Phu Yen",
				"Quang Binh",
				"Quang Nam",
				"Quang Ngai",
				"Quang Ninh",
				"Quang Tri",
				"Soc Trang",
				"Son La",
				"Tay Ninh",
				"Thai Binh",
				"Thai Nguyen",
				"Thanh Hoa",
				"Ho Chi Minh ",
				"Thua Thien Hue",
				"Tien Giang",
				"Tra Vinh",
				"Tuyen Quang",
				"Vinh Long",
				"Vinh Phuc",
				"Yen Bai"};
		
		ArrayList<Province> listProvince = new ArrayList<Province>();
		int i = 0;
		for (String provinceName : arr) {
			Province p = new Province(i,provinceName);
			listProvince.add(p);
			i++;
		}
		
		return listProvince;
	}
	public static Province getProvinceByCode(int hometown) {
		// TODO Auto-generated method stub
		return Province.getProvinceList().get(hometown);
	}
	
}
