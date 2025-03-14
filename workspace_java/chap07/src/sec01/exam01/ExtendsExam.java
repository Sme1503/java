package sec01.exam01;

public class ExtendsExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Child child = new Child();
		System.out.println();
		
		child.printName();
		System.out.println();
		
		String cName = child.getName();
		System.out.println();

		System.out.println("cName: " + cName);
		System.out.println();

		System.out.println("child.name: " + child.name);
		System.out.println();

		System.out.println("pName: " + child.parentName());
		System.out.println();
		
		Child c2 = new Child("새로운 이름");
		String pName2 = c2.parentName();
		System.out.println(pName2);			// "새로운 이름"
		System.out.println();
	}

}
