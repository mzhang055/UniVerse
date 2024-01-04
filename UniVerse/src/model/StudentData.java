/*
 * Michelle Zhang
 * This class is responsible for representing data related to the 
 * student, including personal, academic, and user info
 * It also stores the user's bookmark history and survey history
 */

package model;

public class StudentData {

	// create fields for student's data
	// personal data
	private String firstName;
	private String lastName;
	private String unit;
	private String address;
	private String city;
	private String postalCode;
	private String province;
	private String country;
	private String longitude;
	private String latitude;

	// academic data
	private String course1;
	private String grade1;
	private String course2;
	private String grade2;
	private String course3;
	private String grade3;
	private String course4;
	private String grade4;
	private String course5;
	private String grade5;;
	private String course6;
	private String grade6;;
	private String course7;
	private String grade7;;
	private String course8;
	private String grade8;
	private String courseCode;
	private String grade;

	// survey data
	private String choice1;
	private String choice2;
	private String choice3;

	// map bookmarked data
	private String bookmark1;
	private String bookmark2;
	private String bookmark3;
	private String bookmark4;
	private String bookmark5;

	// login credentials
	public String username;
	private String password;

	// setters and getters
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getCourse1() {
		return course1;
	}

	public void setCourse1(String course1) {
		this.course1 = course1;
	}

	public String getGrade1() {
		return grade1;
	}

	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}

	public String getCourse2() {
		return course2;
	}

	public void setCourse2(String course2) {
		this.course2 = course2;
	}

	public String getGrade2() {
		return grade2;
	}

	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}

	public String getCourse3() {
		return course3;
	}

	public void setCourse3(String course3) {
		this.course3 = course3;
	}

	public String getGrade3() {
		return grade3;
	}

	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}

	public String getCourse4() {
		return course4;
	}

	public void setCourse4(String course4) {
		this.course4 = course4;
	}

	public String getGrade4() {
		return grade4;
	}

	public void setGrade4(String grade4) {
		this.grade4 = grade4;
	}

	public String getCourse5() {
		return course5;
	}

	public void setCourse5(String course5) {
		this.course5 = course5;
	}

	public String getGrade5() {
		return grade5;
	}

	public void setGrade5(String grade5) {
		this.grade5 = grade5;
	}

	public String getCourse6() {
		return course6;
	}

	public void setCourse6(String course6) {
		this.course6 = course6;
	}

	public String getGrade6() {
		return grade6;
	}

	public void setGrade6(String grade6) {
		this.grade6 = grade6;
	}

	public String getCourse7() {
		return course7;
	}

	public void setCourse7(String course7) {
		this.course7 = course7;
	}

	public String getGrade7() {
		return grade7;
	}

	public void setGrade7(String grade7) {
		this.grade7 = grade7;
	}

	public String getCourse8() {
		return course8;
	}

	public void setCourse8(String course8) {
		this.course8 = course8;
	}

	public String getGrade8() {
		return grade8;
	}

	public void setGrade8(String grade8) {
		this.grade8 = grade8;
	}

	public String getChoice1() {
		return choice1;
	}

	public void setChoice1(String choice1) {
		this.choice1 = choice1;
	}

	public String getChoice2() {
		return choice2;
	}

	public void setChoice2(String choice2) {
		this.choice2 = choice2;
	}

	public String getChoice3() {
		return choice3;
	}

	public void setChoice3(String choice3) {
		this.choice3 = choice3;
	}

	public String getBookmark1() {
		return bookmark1;
	}

	public void setBookmark1(String bookmark1) {
		this.bookmark1 = bookmark1;
	}

	public String getBookmark2() {
		return bookmark2;
	}

	public void setBookmark2(String bookmark2) {
		this.bookmark2 = bookmark2;
	}

	public String getBookmark3() {
		return bookmark3;
	}

	public void setBookmark3(String bookmark3) {
		this.bookmark3 = bookmark3;
	}

	public String getBookmark4() {
		return bookmark4;
	}

	public void setBookmark4(String bookmark4) {
		this.bookmark4 = bookmark4;
	}

	public String getBookmark5() {
		return bookmark5;
	}

	public void setBookmark5(String bookmark5) {
		this.bookmark5 = bookmark5;
	}

}
