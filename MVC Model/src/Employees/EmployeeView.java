package Employees;
import java.util.Scanner;

public class EmployeeView {
	private EmployeeVO vo;
	private EmployeeController controller;
	Scanner s;

	public EmployeeView() {
		controller = new EmployeeController();
		vo = new EmployeeVO();
		s = new Scanner(System.in);
	}

	public void createEmployee() {
		System.out.print("Enter employee's id: ");
		vo.setId(s.nextInt());

		// clear buffer
		s.nextLine();

		System.out.print("Enter employee's first name: ");
		vo.setFirstName(s.nextLine());

		System.out.print("Enter employee's last name: ");
		vo.setLastName(s.nextLine());

		System.out.print("Enter employee's age: ");
		vo.setAge(s.nextInt());

		int cnt = controller.insertEmployee(vo);
		if (cnt != 0) {
			System.out.println("Insert successfully!");
		} else {
			System.out.println("Cannot insert!");
		}
	}

	public void printEmployeeDetails() {
		System.out.print("Enter employee's id to search: ");
		int id = s.nextInt();
		vo.setId(id);

		EmployeeVO emp = controller.displayEmployee(vo);
		if (emp != null) {
			System.out.println(emp);
		} else {
			System.out.println("Not found!");
		}
	}

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int choice;
		EmployeeView view = new EmployeeView();

		do {
			System.out.println(" 1. Create employee");
			System.out.println(" 2. Display employee base on id");
			System.out.println(" 3. Exit");

			System.out.print("Please enter the choice: ");
			choice = s.nextInt();

			// clear buffer
			s.nextLine();

			switch (choice) {
			case 1:
				view.createEmployee();
				break;
			case 2:
				view.printEmployeeDetails();
				break;
			}
		} while (choice != 3);
	}
}
