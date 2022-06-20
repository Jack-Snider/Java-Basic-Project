package MainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 관리자 계정으로 들어왔을 때 관리자가 볼 화면 + 관리자의 기능 
public class AdminView extends DBConnection {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static void menuView() throws IOException, SQLException, ClassNotFoundException { // 관리자로 로그인 했을때 처음 보는 화면

		System.out.println("관리자모드");
		System.out.println(" Command words");
		System.out.println("1: 회원정보 관리(회원정보 수정, 회원 삭제기능도 함께(탈퇴)");
		System.out.println("2: 항공사정보 관리(항공사 추가,삭제,정보수정)");
		System.out.println("3: 공항정보 관리(공항 추가, 삭제, 정보수정)");

		System.out.println("4: 항공 생성 및 수정");
		System.out.println("5: 티켓 생성 및 수정");
		System.out.println();
		System.out.print("관리자모드>> ");

		String input = bf.readLine();

		if (input.equalsIgnoreCase("1")) {// 회원정보관리

		} else if (input.equalsIgnoreCase("2")) {// 항공사정보관리
			showAirline();

		} else if (input.equalsIgnoreCase("3")) {// 공항정보관리
			
		} else if (input.equalsIgnoreCase("4")) {// 항공권관리

		} else if (input.equalsIgnoreCase("5")) {// 티켓관리

		}
	}	
	
	
	public static void MoogonTV() { // 관리자로 로그인 했을때 처음 보는 화면
		
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

	public static void showAirline() throws IOException, ClassNotFoundException, SQLException {

		System.out.println("1.항공사 조회");
		System.out.println("2.항공사 추가");
		System.out.println("3.항공사 정보수정");
		System.out.println("<.돌아가기");
		System.out.println("--------------");
		String input = bf.readLine();
		if (input.equalsIgnoreCase("1")) {// 항공사 조회
			AirlineDAO.tableView();

		} else if (input.equalsIgnoreCase("2")) {// 항공사 추가
			AirlineDAO.insert();
			showAirline();

		} else if (input.equalsIgnoreCase("3")) {// 항공사 정보수정
			AirlineDAO.update();
			showAirline();
		} else if (input.equalsIgnoreCase("<")) {
			System.out.println("돌아감");
			menuView();
		} else {
			System.out.println("잘못 입력하였습니다. 다시 입력하시오.");
			showAirline();
		}
	}

	// 여기부터

}
