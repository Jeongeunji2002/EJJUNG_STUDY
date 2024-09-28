package test.objectio;

// 회원정보 저장용 객체 클래스 : VO, DTO, DO, Entity, Bean
// 1. 반드시 직렬화할 것 => java.io.Serializable 인터페이스 상속받으면 됨
// 2. 모든 필드는 private
// 3. 기본생성자와 매개변수 있는 생성자 작성할 것
// 4. 모든 필드에 대한 setters and getters 작성할 것
// 5. toString(), equals(), clone(), hashCode() 오버라이딩은 선택사항
public class Member implements java.io.Serializable {
	
	// Field
	private String name;
	private int age;
	private char gender;
	private String email;
	private String phone;
	private double point;

	public Member(String string, int i, char c, String string2, String string3, double d) {
		// TODO Auto-generated constructor stub
	}
	// Constructor
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public double getPoint() {
		return point;
	}
	public void setPoint(double point) {
		this.point = point;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", gender=" + gender + ", email=" + email + ", phone=" + phone
				+ ", point=" + point + "]";
	}
	
	
}
