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

//		System.out.println();
//		System.out.println();
//		System.out.println("ZZ                                  ZZZZZZZZZ         ZZ                 ZZ       ZZZZZZZZZZ    ");
//		System.out.println("ZZ                              ZZ                  ZZ         ZZ              ZZ        ZZ                       ");
//		System.out.println("ZZ                            ZZ                     ZZ          ZZ          ZZ          ZZ                       ");
//		System.out.println("ZZ                             ZZ                    ZZ             ZZ      ZZ           ZZZZZZZZZZ     ");
//		System.out.println("ZZ                              ZZ                   ZZ                ZZ  ZZ            ZZ                        ");
//		System.out.println("ZZZZZZZZZZZZ         ZZZZZZZZZZ                      ZZ               ZZZZZZZZZZ     ");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
		
		
		System.out.println("┌────관리자 모드로 진입하였습니다. ────┐");
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
		} else if(input.equalsIgnoreCase("logout")) { // 로그아웃
			MenuBar.startView();
			MenuBar.menuView();
		}
	}	
	
	
	public static void moogonTV() { // 관리자로 로그인 했을때 처음 보는 화면
		
		
		
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
	public static void manageMember() throws ClassNotFoundException, SQLException{
		String choiceMenu;
		try {
			System.out.println("┌────회원관리────┐");
			System.out.println("│ edit (회원정보 수정)");
			System.out.println("∑ delete  (회원 삭제)");
			System.out.println();
			System.out.print("ADMIN >> ");
			choiceMenu = bf.readLine();
			if (choiceMenu.equalsIgnoreCase("EDIT")){
				editMemberInfo();
			}else if(choiceMenu.equalsIgnoreCase("DELETE")) {
				deleteMember();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("잘못된 경로입니다. 메인으로 이동합니다.");
			
		}
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
		 * 항공편 수정인지 생성인지 선택
		 *  
		 */
			
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		System.out.println("┌──────────┐");
		System.out.println("│create (항공 생성)");
		System.out.println("│delete (항공 삭제)");
		System.out.println("└──────────┘");
		System.out.print("Admin >> ");
		try {
			
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			
			String input = bf.readLine();
			
			if(input.equalsIgnoreCase("create")) {
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
					menuView();
				}else {
					System.out.println("등록이 정상적으로 이루어지지 않았습니다.");
				}
			}
			
			
			
			else if(input.equalsIgnoreCase("delete")) {
			
				/*
				 * 항공편 수정은 
				 * 
				 * 
				 */

				String sql = "DELETE FROM FLIGHT WHERE IDX = ";
				try {
					System.out.print("삭제할 항공의 인덱스 입력 : ");
					String del = bf.readLine();
					
					sql += del;
					
					conn = DBConnection.getConnection();
					stmt = conn.createStatement();
					stmt.executeQuery(sql);
					System.out.println("정상적으로 삭제 되었습니다. ");
					menuView();
					
				}catch(SQLException sqle) {
					System.out.println("SQL ERROR : " + sqle);
				}catch(Exception e) {
					System.out.println("UNKNOWN ERROR : " + e);
				}
				
				
				
				
			}
			
		}catch(SQLException sqle) {
			System.out.println("SQL ERROR : " + sqle);
		}catch(Exception e) {
			System.out.println("UNKNOWN ERROR : " + e);
		}
		
		
	
			
			
			
			
		
			
			
			
		
		
		
		
		
		
	}
	
	
	// 티켓관리
	public static void manageTicket() throws IOException, ClassNotFoundException, SQLException {
	      System.out.println("-----티켓관리 페이지-----");
	      System.out.println("1. 티켓 조회");
	      System.out.println("2. 티켓 생성");
	      System.out.println("3. 티켓 수정 및 삭제");
	      System.out.println("<. 뒤로가기");
	      System.out.println("-----------------------------------");
	      
	      String input = bf.readLine();
	      if(input.equalsIgnoreCase("1")) {
	         TicketDAO.tableView();
	         manageTicket();
	      }else if(input.equalsIgnoreCase("2")) {
	         TicketDAO.insert();
	         manageTicket();
	      }else if(input.equalsIgnoreCase("3")) {
	         TicketDAO.update();
	         manageTicket();
	      }else if(input.equalsIgnoreCase("<")) {
	         System.out.println("뒤로 돌아감.");
	         System.out.println("--------------------------------");
	         System.out.println();
	         menuView();
	         
	      }else {
	         System.out.println("잘못 입력하셨습니다. ");
	         System.out.println("다시");
	         System.out.println("---------------------------");
	         manageTicket();
	      }
	      
	   }
	
	
	
	public static void editMemberInfo() throws ClassNotFoundException, IOException, SQLException {
		
	      System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	      System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･회원 관리 메뉴✧ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	      System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	      
	      System.out.print("정보를 수정할 회원의 아이디를 입력하세요 >> ");
	      
	      try {
	    	  Connection conn = DBConnection.getConnection();
	    	  Statement stmt = conn.createStatement();
	    	  ResultSet rs;
	    	  
	    	  
	    	  String input = bf.readLine();
	    	  String selectMem="select * "
	    	  				 + "from member "
	    	  				 + "where mem_id= '"+input+"'";
	    	  
	    	  rs=stmt.executeQuery(selectMem);
	    	  if(rs.next()) {
	    		  String mem_id=rs.getString("MEM_ID");
	    		  String mem_pw=rs.getString("MEM_PW");
	    		  String mem_rgon1=rs.getString("MEM_RGON1");
	    		  String mem_rgon2=rs.getString("MEM_RGON2");
	    		  String mem_nm=rs.getString("MEM_NM");
	    		  String mem_ename=rs.getString("MEM_ENAME");
	    		  String mem_tel=rs.getString("MEM_TEL");
	    		  String mem_add=rs.getString("MEM_ADD");
	    		  String mem_pp=rs.getString("MEM_PP");
	    		  String mem_depm=rs.getString("MEM_DEPM");
	    		  
	    		  System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	    		  System.out.println("조회한 회원 "+mem_nm+"님의 정보");
	    		  System.out.println("MEM_ID: "+mem_id);
	    		  System.out.println("MEM_PW: "+mem_pw);
	    		  System.out.println("MEM_RGON1: "+mem_rgon1);
	    		  System.out.println("MEM_RGON2: "+mem_rgon2);
	    		  System.out.println("MEM_NM: "+mem_nm);
	    		  System.out.println("MEM_ENAME: "+mem_ename);
	    		  System.out.println("MEM_TEL: "+mem_tel);
	    		  System.out.println("MEM_ADD: "+mem_add);
	    		  System.out.println("MEM_PP: "+mem_pp);
	    		  System.out.println("MEM_DEPM: "+mem_depm);
	    		  System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	    		  System.out.println();
	    		  System.out.println("수정할 항목을 입력해주세요.");
	    		  System.out.print(">>");
	    		  try {
	    			  String column=bf.readLine();
	    			  if(column.equalsIgnoreCase("mem_id")
	    					  ||column.equalsIgnoreCase("mem_pw")
	    					  ||column.equalsIgnoreCase("mem_rgon1")
	    					  ||column.equalsIgnoreCase("mem_rgon2")
	    					  ||column.equalsIgnoreCase("mem_nm")
	    					  ||column.equalsIgnoreCase("mem_ename")
	    					  ||column.equalsIgnoreCase("mem_tel")
	    					  ||column.equalsIgnoreCase("mem_add")
	    					  ||column.equalsIgnoreCase("mem_pp")
	    					  ||column.equalsIgnoreCase("mem_depm")) {
	    				  System.out.println("수정할 정보를 입력해주세요.");
	    				  System.out.print(">>");
	    				  String data=bf.readLine();
	    				  String sql="UPDATE MEMBER "
	    						  + "SET "+column+" = '"+data+"'"
	    						  + "WHERE MEM_ID='"+input+"'";
	    				  stmt.executeQuery(sql);
	    				  System.out.println("회원 정보 변경이 정상적으로 완료되었습니다.");
	    				  System.out.println("다른 회원의 정보 관리는  'member',");
	    				  System.out.println("관리자 메인은 'main'을 입력하세요.");
	    				  
	    				  String backTo=bf.readLine();
	    				  while(true) {
	    					  
	    					  if(backTo.equalsIgnoreCase("member")) {
	    						  System.out.println("회원 관리로 이동합니다.");
	    						  manageMember();
	    					  }else if(backTo.equalsIgnoreCase("main")) {
	    						  System.out.println("관리자 메인으로 이동합니다.");
	    						  menuView();
	    					  }else {
	    						  System.out.println("잘못된 명령어입니다. 다시 입력해주세요.");
	    						  backTo=bf.readLine();
	    					  }
	    				  }
	    				  
	    			  }else {
	    				  System.out.println("수정할 항목의 입력이 바르지 않습니다.");
	    				  System.out.println("회원 정보 변경을 계속하려면 'member',");
	    				  System.out.println("관리자 메인은 'main'을 입력하세요.");
	    				  System.out.print(">>");
	    				  
	    				  String backTo=bf.readLine();
	    				  while(true) {
	    					  if(backTo.equalsIgnoreCase("member")) {
	    						  System.out.println("회원 관리로 이동합니다.");
	    						  manageMember();
	    					  }else if(backTo.equalsIgnoreCase("main")) {
	    						  System.out.println("관리자 메인으로 이동합니다.");
	    						  menuView();
	    					  }else {
	    						  System.out.println("잘못된 명령어입니다. 다시 입력해주세요.");
	    						  backTo=bf.readLine();
	    					  }
	    					  
	    				  }
	    			  }
		    	  }catch (Exception e) {
					System.out.println("회원 정보 수정 중 오류 발생으로 관리자 메인으로 이동합니다.");
					menuView();
					e.printStackTrace();
		    	  }
	    	  }else {
	        	System.out.println("입력한 아이디의 회원이 존재하지 않습니다.");	  
	        	System.out.println("정보를 확인하고 다시 시도하십시오.");
	        	manageMember();
	    	  }
				
			}catch (Exception e) {
				System.out.println("오류 발생으로 관리자 메인으로 이동합니다.");
				AdminView.manageMember();
				e.printStackTrace();
				
			}
		}
		public static void deleteMember() throws ClassNotFoundException, SQLException{
			
		System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	    System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･회원 삭제 메뉴✧ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	    System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	    
	    System.out.print("정보를 삭제할 회원의 아이디를 입력하세요 >> ");

	    try {
	  	  Connection conn = DBConnection.getConnection();
	  	  Statement stmt = conn.createStatement();
	  	  ResultSet rs;
	  	  
	  	  
	  	  String input = bf.readLine();
	  	  String selectMem="select * "
	  	  				 + "from member "
	  	  				 + "where mem_id= '"+input+"'";
	  	  
	  	  rs=stmt.executeQuery(selectMem);
	  	  if(rs.next()) {
	  		  String mem_id=rs.getString("MEM_ID");
	  		  String mem_pw=rs.getString("MEM_PW");
	  		  String mem_rgon1=rs.getString("MEM_RGON1");
	  		  String mem_rgon2=rs.getString("MEM_RGON2");
	  		  String mem_nm=rs.getString("MEM_NM");
	  		  String mem_ename=rs.getString("MEM_ENAME");
	  		  String mem_tel=rs.getString("MEM_TEL");
	  		  String mem_add=rs.getString("MEM_ADD");
	  		  String mem_pp=rs.getString("MEM_PP");
	  		  String mem_depm=rs.getString("MEM_DEPM");
	  		  
	  		  System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	  		  System.out.println("조회한 회원 "+mem_nm+"님의 정보");
	  		  System.out.println("MEM_ID: "+mem_id);
	  		  System.out.println("MEM_PW: "+mem_pw);
	  		  System.out.println("MEM_RGON1: "+mem_rgon1);
	  		  System.out.println("MEM_RGON2: "+mem_rgon2);
	  		  System.out.println("MEM_NM: "+mem_nm);
	  		  System.out.println("MEM_ENAME: "+mem_ename);
	  		  System.out.println("MEM_TEL: "+mem_tel);
	  		  System.out.println("MEM_ADD: "+mem_add);
	  		  System.out.println("MEM_PP: "+mem_pp);
	  		  System.out.println("MEM_DEPM: "+mem_depm);
	  		  System.out.println("･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ:･ﾟ ･ﾟ*･ﾟ･ﾟ*･ﾟ: ･ﾟ:*･ﾟ ･ﾟ*･ﾟ ･ﾟ:*");
	  		  System.out.println();
	  		  System.out.println("삭제할 회원이 맞다면 'DELETE'를,");
	  		  System.out.println("아니라면 'BACK'을 입력하세요.");
	  		  System.out.print(">>");
	  		  try {
	  			  String select=bf.readLine();
	  			  if(select.equalsIgnoreCase("DELETE")) {
	  				  String sql="DELETE "
	  						   + "FROM MEMBER "
	  						   + "WHERE MEM_ID='"+input+"'";
	  				  stmt.executeQuery(sql);
	  				  System.out.println("회원 정보 삭제가 정상적으로 완료되었습니다.");
	  				  System.out.println("다른 회원의 정보 수정은  'EDIT',");
	  				  System.out.println("다른 회원의 정보 삭제는  'DELETE',");
	  				  System.out.println("관리자 메인은 'MAIN'을 입력하세요.");
	  				  
	  				  String backTo=bf.readLine();
	  
	  					  if(backTo.equalsIgnoreCase("EDIT")) {
	  						  System.out.println("회원 관리로 이동합니다.");
	  						  editMemberInfo();
	  					  }else if(backTo.equalsIgnoreCase("DELETE")) {
	  						  System.out.println("관리자 메인으로 이동합니다.");
	  						  deleteMember();
	  					  }else if(backTo.equalsIgnoreCase("MAIN")) {
	  						  System.out.println("관리자 메인으로 이동합니다.");
	  						  menuView();
	  					  }else {
	  						  System.out.println("잘못된 명령어입니다. 다시 입력해주세요.");
	  						  backTo=bf.readLine();
	  					  }
	  				  }
	  				  
	  			  else {
	  				  System.out.println("입력한 내용이 바르지 않습니다.");
	  				  System.out.println("회원 정보 삭제를 계속하려면 'DELETE',");
	  				  System.out.println("관리자 메인은 'main'을 입력하세요.");
	  				  System.out.print(">>");
	  				  
	  				  String backTo=bf.readLine();
	  				 
	  					  if(backTo.equalsIgnoreCase("DELETE")) {
	  						  System.out.println("회원 삭제로 이동합니다.");
	  						  deleteMember();
	  					  }else if(backTo.equalsIgnoreCase("main")) {
	  						  System.out.println("관리자 메인으로 이동합니다.");
	  						  menuView();
	  					  }else {
	  						  System.out.println("잘못된 명령어입니다. 다시 입력해주세요.");
	  						  backTo=bf.readLine();
	  					  }
	  					  
	  				  }
	  			  }
		    	  catch (Exception e) {
					System.out.println("회원 정보 삭제 중 오류 발생으로 관리자 메인으로 이동합니다.");
					menuView();
					e.printStackTrace();
		    	  }
	  	  }else {
	      	System.out.println("입력한 아이디의 회원이 존재하지 않습니다.");	  
	      	System.out.println("정보를 확인하고 다시 시도하십시오.");
	      	manageMember();
	  	  }
				
			}catch (Exception e) {
				System.out.println("오류 발생으로 관리자 메인으로 이동합니다.");
				AdminView.manageMember();
				e.printStackTrace();
				
			}
		}
	
	
	
	
	
}

