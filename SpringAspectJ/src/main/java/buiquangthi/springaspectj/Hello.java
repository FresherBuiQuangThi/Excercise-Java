package buiquangthi.springaspectj;

public class Hello {
	public void method1() {
		System.out.println("=================================");
		System.out.println("Chạy hàm 01");
	}

	public String method2() {
		System.out.println("=================================");
		System.out.println("Chạy hàm 02");
		return "hello";
	}

	public void method3() {
		System.out.println("=================================");
		System.out.println("Chạy hàm 03");
		throw new IllegalArgumentException();
	}
}
