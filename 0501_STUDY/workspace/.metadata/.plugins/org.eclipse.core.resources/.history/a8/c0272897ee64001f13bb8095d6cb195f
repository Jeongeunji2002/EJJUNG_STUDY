package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDBConnect {
	public TestDBConnect() {
	}

	public void oracleConnect() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			// 1.오라클 jdbc 드라이브 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2.db 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "c##jdbc", "jdbc");
			System.out.println(conn);

			// 3.문장(Statement)객체 만들기
			stmt = conn.createStatement();

			// 4.SQL 전송하고 결과받기
			String query = "select * from employee"; // executeQuery : ResultSet 사용
			// dml(insert, update, delete) 문
			rset = stmt.executeQuery(query);
			System.out.println(rset);

			// 5. 받은 결과 처리하기
			while (rset.next()) { // 데이터가 기록된 행이 있다면 true 반환됨
				//rset이 참조하는 행의 각 컬럼값을 추출함 : get자료형("컬럼명"), get자료형(컬럼순번)
				System.out.println(rset.getString("EMP_ID")
									   +" | "+rset.getString(2)
									   +" | "+rset.getString(3)
									   +" | "+rset.getString(4)
									   +" | "+rset.getString(5)
									   +" | "+rset.getDate(6)
									   +" | "+rset.getString(7)
									   +" | "+rset.getInt(8)
									   +" | "+rset.getDouble(9)
									   +" | "+rset.getString(10)
									   +" | "+rset.getString(11)
									   +" | "+rset.getString(12));
			}
		} catch (ClassNotFoundException | SQLException e) {
			//ClassNotFoundException-드라이브 패키지명, 클래스명 오타, ojdbc8.jar 추가하지 않았을 때
			//SQLException-url, user, password 오타, 쿼리문 잘못 작성 시, get자료형() 사용시 컬럼명 오타, 컬럼자료형과 일치하지 않을 때
			e.printStackTrace();
		} finally {
			try {
				// 6.반드시 닫기
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		new TestDBConnect().oracleConnect();
	}

}
