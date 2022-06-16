package MainPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

// 관리자 계정으로 들어왔을 때 관리자가 볼 화면 + 관리자의 기능 
public class AdminView extends DBConnection{

	
	public static void menuView() { // 관리자로 로그인 했을때 처음 보는 화면
		
		System.out.println();
		System.out.println();
		System.out.println("ZZ                                  ZZZZZZZZZ         ZZ                 ZZ       ZZZZZZZZZZ    ");
		System.out.println("ZZ                              ZZ                  ZZ         ZZ              ZZ        ZZ                       ");
		System.out.println("ZZ                            ZZ                     ZZ          ZZ          ZZ          ZZ                       ");
		System.out.println("ZZ                             ZZ                    ZZ             ZZ      ZZ           ZZZZZZZZZZ     ");
		System.out.println("ZZ                              ZZ                   ZZ                ZZ  ZZ            ZZ                        ");
		System.out.println("ZZZZZZZZZZZZ         ZZZZZZZZZZ                      ZZ               ZZZZZZZZZZ     ");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		
		
		System.out.println("┌────── Accessed to as Administrator ───────┐");
		System.out.println("│	show me the money : 모든 회원에게 1,000,000원 지급");
		System.out.println("│	");
		System.out.println("│	");
		System.out.println("│	");
		System.out.println("└────── ─────────────── ───────┘");
		
	}
	
	public static void showAllMember() { // 회원 전체보기
		
		String query = "SELECT * FROM MEMBER";
		
		try {
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				String mem_id = rs.getString("MEM_ID");
				String mem_pw = rs.getString("MEM_PW");
				String mem_rgon1 = rs.getString("MEM_RGON1");
				String mem_rgon2 = rs.getString("MEM_RGON2");
				String mem_nm = rs.getString("MEM_NM");
				String mem_tel = rs.getString("MEM_TEL");
				String mem_add = rs.getString("MEM_ADD");
				String mem_pp = rs.getString("MEM_PP");
				String mem_depm = rs.getString("MEM_DEPM");
				String mem_ename = rs.getString("MEM_ENAME");
				
				
				System.out.println(mem_id + "\t" + mem_pw + "\t" + mem_rgon1 + "\t" + mem_rgon2 + "\t"
						+ mem_nm + "\t" + mem_tel + "\t" + mem_add + "\t" + mem_pp + "\t" + mem_depm + "\t"
						+ mem_ename);
				
			}
			
			
		}catch(Exception e) {
			
		}
		
		
	}
	
	
	
	
	// 여기부터
	
	
	
	
	
	
	
	
	
	
	
	
	
}
