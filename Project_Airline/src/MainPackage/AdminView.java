package MainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// 관리자 계정으로 들어왔을 때 관리자가 볼 화면 + 관리자의 기능 
public class AdminView extends DBConnection {

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
	public static void menuView() throws IOException, SQLException, ClassNotFoundException { // 관리자로 로그인 했을때 처음 보는 화면

		//moogonTV();
		System.out.println("관리자모드");
		System.out.println(" Command words");
		System.out.println("1: 회원정보 관리(회원정보 수정, 회원 삭제기능도 함께(탈퇴)");
		System.out.println("2: 항공사정보 관리(항공사 추가,삭제,정보수정)");
		System.out.println("3: 공항정보 관리(공항 추가, 삭제, 정보수정)");

		System.out.println("4: 항공 생성 및 수정");
		System.out.println("5: 티켓 생성 및 수정");
		System.out.println();
		System.out.print("ADMIN >> ");

		String input = bf.readLine();

		if (input.equalsIgnoreCase("1")) {// 회원정보관리
			manageMember();
		} else if (input.equalsIgnoreCase("2")) {// 항공사정보관리
			showAirline();

		} else if (input.equalsIgnoreCase("3")) {// 공항정보관리
			manageAirport();
		} else if (input.equalsIgnoreCase("4")) {// 항공권관리
			manageFlight();
		} else if (input.equalsIgnoreCase("5")) {// 티켓관리
			manageTicket();
		}
	}	
	
	
	public static void moogonTV() { // 관리자로 로그인 했을때 처음 보는 화면
		
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
		
		
		System.out.println("┌────관리자 모드로 진입하였습니다. ────┐");
		
//		System.out.println("┌────── Accessed to as Administrator ───────┐");
//		System.out.println("│	show me the money : 모든 회원에게 1,000,000원 지급");
//		System.out.println("│	");
//		System.out.println("│	");
//		System.out.println("│	");
//		System.out.println("└────── ─────────────── ───────┘");
		
		
		
		
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

//----------------------------------------------------------------------------------------
	
	
	
	
//----------------------------------------------------------------------------------------	
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
//----------------------------------------------------------------------------------------

	// 회원정보 관리
	public static void manageMember() {
		
	}
	
	// 공항정보 관리
	public static void manageAirport() {
		
	}
	
	// 항공권 관리
	public static void manageFlight() {
		
		/*
		 * FLIGHT NO 생성, 
		 * 
		 * 
		 */
			
		try {
			
			Connection conn = DBConnection.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs;
			
			
			System.out.print("AIR_CODE(항공사 코드) : ");
			String air_code = bf.readLine();
			System.out.print("APT_AVL(도착지 코드) : ");
			String apt_avl = bf.readLine();
			System.out.print("FLIGHT_DEPA(출발시간) : ");
			String flight_depa = bf.readLine();
			System.out.print("FLIGHT_DEPT(도착시간) : ");
			String flight_dept = bf.readLine();
			
			String idx = "";
			while(true) {
				System.out.print("IDX(인덱스) : ");
				idx = bf.readLine();
				String indexCheck = "SELECT * FROM FLIGHT WHERE IDX = " + idx + "";
				rs = stmt.executeQuery(indexCheck);
				if(rs.next()) {
					System.out.println("해당 인덱스는 이미 존재합니다. 다시 입력해주세요.");
					continue;
				}else {
					System.out.println("유효한 인덱스입니다.");
					break;
				}
			}
			
			
			String tmp_flight_depa = flight_depa;
			String tmp = "";
			for(int i = 0; i < tmp_flight_depa.length(); i++) {
				if(tmp_flight_depa.charAt(i) == '-') {
					tmp += "";
				}else {
					tmp += tmp_flight_depa.charAt(i);
				}
			}
			tmp_flight_depa = tmp;
			
			
			
			String tmp_flight_dept = flight_dept;
			tmp = "";
			for(int i = 0; i < tmp_flight_dept.length(); i++) {
				if(tmp_flight_dept.charAt(i) == ':') {
					tmp += "";
				}else {
					tmp += tmp_flight_dept.charAt(i);
				}
			}
			tmp_flight_dept = tmp;
			
			String flight_no = air_code + apt_avl + 
					tmp_flight_depa + tmp_flight_dept;
			
			String insert = "INSERT INTO FLIGHT(FLIGHT_NO, "
					+ "AIR_CODE, APT_AVL, FLIGHT_DEPA, FLIGHT_DEPT, "
					+ "FLIGHT_DEP, IDX) VALUES('" + flight_no + "' , '" + air_code + "' , '" + apt_avl + "' , '"
					+ flight_depa + "' , '" + flight_dept + "' , '" + "ICN' , " + idx + ")";
			
			
			rs = stmt.executeQuery(insert);
			if(rs.next()) {
				System.out.println("정상적으로 등록 되었습니다.");
			}else {
				System.out.println("등록이 정상적으로 이루어지지 않았습니다.");
			}
			
			
			
		}catch(Exception e) {
			
		}
		
		
		
		
		
	}
	
	
	// 티켓관리
	public static void manageTicket() {
		
	}
	
}

