package PTMusang;

import java.util.*;

public class Karyawan {
	private String name, gender, position, kodeKaryawan;
	private double gaji;
	
	public Karyawan(String name, String gender, String position, String kodeKaryawan, double gaji) {
		this.name = name;
		this.gender = gender;
		this.position = position;
		this.kodeKaryawan = kodeKaryawan;
		this.gaji = gaji;
	}
	
	public double getGaji() {
		return gaji;
	}

	public void setGaji(double gaji) {
		this.gaji = gaji;
	}

	public String getKodeKaryawan() {
		return kodeKaryawan;
	}

	public void setKodeKaryawan(String kodeKaryawan) {
		this.kodeKaryawan = kodeKaryawan;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
}
