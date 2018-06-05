package Employees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeModel {
	private static Connection getConnection() throws Exception {
		return DriverManager.getConnection("jdbc:sqlserver://localhost;databaseName=ThucTap-Test;user=sa;password=123456");
	}

	public int insert(EmployeeVO emp) throws SQLException {
		Connection c = null;
		PreparedStatement ps = null;
		int cnt = 0;

		try {
			c = this.getConnection();
			ps = c.prepareStatement("insert into employees values(?, ?, ?, ?)");
			int i = 0;

			ps.setInt(++i, emp.getId());
			ps.setNString(++i, emp.getFirstName());
			ps.setNString(++i, emp.getLastName());
			ps.setInt(++i, emp.getAge());

			cnt = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				c.close();
			}
		}
		return cnt;
	}

	public EmployeeVO display(EmployeeVO vo) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmployeeVO emp = null;
		int cnt = 0;
		try {
			con = this.getConnection();
			ps = con.prepareStatement("select * from employees where id = ?");
			ps.setInt(1, vo.getId());
			rs = ps.executeQuery();
			emp = new EmployeeVO();
			while (rs.next()) {
				emp.setId(rs.getInt("id"));
				emp.setFirstName(rs.getString("first"));
				emp.setLastName(rs.getString("last"));
				emp.setAge(rs.getInt("age"));
				cnt++;
			}
			if (cnt > 0)
				return emp;

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (con != null) {
				con.close();
			}
		}
		return null;
	}
}
