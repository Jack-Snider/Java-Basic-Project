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

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); // Scanner의 기능

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
