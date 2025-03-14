package sec01.exam01;

public class Child extends Parent {
	
	void printName() {
		System.out.println("name: " + name);
		System.out.println("this.name: " + this.name);
		String pName = getName();
		System.out.println("pName: " + pName);
	}
	
	// 상속을 받았을 때의 기본 생성자
	Child() {
//		super();	// 부모의 기본 생성자, 부모의 기본 생성자가 있을 때 생략 가능
		super(1);	// 전달인자를 맞춰줘야 한다, 생략 불가능
//		this(2);	// super(), this() 모두 첫줄에 적어야 하므로 같이 사용 불가
		System.out.println("Child 생성자 실행");
	}
	
	Child(int a) {
		super(1);
	}
	
	Child(String name) {
		super(name);
	}
	
	// shadow : 전달인자가 필드를 가리는 현상 
	void setName(String name) {
		this.name = name;
	}
	
	int age;
	
	// over shadow : 자식의 필드가 부모의 필드를 가리는 현상
	String name = "Child의 name";
	
	String parentName() {
		String name = null;				// 지역변수
		String cName = this.name;		// 내 필드
		String pName = super.name;		// 부모 필드
		
		return super.name;
	}
	
}

