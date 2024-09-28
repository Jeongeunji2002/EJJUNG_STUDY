package common;

import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JCBCTemplate {
	// db.properties 파일을 읽어와서 값을 적용
	// 싱글톤 디자인 패턴 사용함 => 모든 메소드에 static 적용함(static 메모리에 할당함)
	// static (정적) 메모리 : 프로그램 실행시 딱 한번 자동 기록함, 프로그램 구동내내 한개만 존재함, 공유목적
	// static 메소드 내에는 this 참조변수가 없음
	// 싱클톤에서는 생성자 필요 없음 => 동적 메모리에 할당할 것이 없고 정ㅇ적과 동적 간의 주소 참조 없음

	// static 메소드 내에서는 this 참조를 못하므로, 별도의 파일읽기용 내부클래스 작성해서 사용하도록 함
	//내부(Inner, Nested	) 클래스는 외부클래스가 멤버로 보면 됨 => static 사용할 수 있음
	//static 메소드 내에서 멤버(필드, 내부클래스)를 사용하려면, 같은 static 이어야 함
	private static class ReadProperties{
		private Properties prop;
		
		public ReadProperties() {
			prop = new Properties();
			
			try {
				//서버 엔진을 통해서 파일을 읽어야 하므로, 바로 FileReader 로 파일을 읽을 수 없음
				//웹은 서버 클라이언트 방식의 네트워크 사용함
				//네트워크 입출력은 바이트 스트림만 사용할 수 있음
				//대상 파일을 바이트스크림(InputStream)으로 읽어서, 택스트 파일이므로 Reader 로 바뀜
				prop.load(new InputStreamReader(this.getClass().getResourceAsStream("db.properties")));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public Properties getProp() {
			return prop;
		}
	}	//내부클래스
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Properties prop = new ReadProperties().getProp();
			
			Class.forName(prop.getProperty("driver"));
			conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"), prop.getProperty("password"));
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	 public static void close(ResultSet rset) {
	      try {
	         if(rset != null && rset.isClosed()) {
	            rset.close();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(Statement stmt) {
	      try {
	         if(stmt != null && stmt.isClosed()) {
	            stmt.close();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void close(Connection conn) {
	      try {
	         if(conn != null && conn.isClosed()) {
	            conn.close();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void commit(Connection conn) {
	      try {
	         if(conn != null && conn.isClosed()) {
	            conn.commit();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	   
	   public static void rollback(Connection conn) {
	      try {
	         if(conn != null && conn.isClosed()) {
	            conn.rollback();
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }
	}
