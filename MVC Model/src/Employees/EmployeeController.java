package Employees;
import java.sql.SQLException;

public class EmployeeController {
	private EmployeeModel model;

	public EmployeeController() {
		model = new EmployeeModel();
	}

	public int insertEmployee(EmployeeVO vo) {
		int cnt = 0;
		try {
			cnt = model.insert(vo);
		} catch (SQLException ex) {
			System.err.println("Error: " + ex.toString());
		}
		return cnt;
	}

	public EmployeeVO displayEmployee(EmployeeVO emp) {
		EmployeeVO vo = null;
		try {
			vo = model.display(emp);
		} catch (SQLException ex) {
			System.err.println("Error: " + ex.toString());
		}
		return vo;
	}
}
