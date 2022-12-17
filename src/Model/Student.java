package Model;

import java.util.Date;
import java.util.Objects;

public class Student {
	private int code;
	private String name;
	private String homeTown;
	private Date dateOfBirth;
	private boolean gender;
	private float score1;
	private float score2;
	private float score3;
	
	public Student() {
	}
	public Student(int code, String name, String homeTown, Date dateOfBirth, boolean gender, float score1, float score2, float score3) {
		this.code = code;
		this.name = name;
		this.homeTown = homeTown;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHomeTown() {
		return homeTown;
	}
	public void setHomeTown(String homeTown) {
		this.homeTown = homeTown;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public float getScore1() {
		return score1;
	}
	public void setScore1(float score1) {
		this.score1 = score1;
	}
	public float getScore2() {
		return score2;
	}
	public void setScore2(float score2) {
		this.score2 = score2;
	}
	public float getScore3() {
		return score3;
	}
	public void setScore3(float score3) {
		this.score3 = score3;
	}
	@Override
	public String toString() {
		return "Student [code=" + code + ", name=" + name + ", homeTown=" + homeTown + ", dateOfBirth=" + dateOfBirth
				+ ", gender=" + gender + ", score1=" + score1 + ", score2=" + score2 + ", score3=" + score3 + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(code, dateOfBirth, gender, homeTown, name, score1, score2, score3);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return code == other.code && Objects.equals(dateOfBirth, other.dateOfBirth) && gender == other.gender
				&& Objects.equals(homeTown, other.homeTown) && Objects.equals(name, other.name)
				&& Float.floatToIntBits(score1) == Float.floatToIntBits(other.score1)
				&& Float.floatToIntBits(score2) == Float.floatToIntBits(other.score2)
				&& Float.floatToIntBits(score3) == Float.floatToIntBits(other.score3);
	}
	
}
