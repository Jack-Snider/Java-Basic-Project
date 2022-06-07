package Project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Member extends Control {

	/*
	 * 명령어 메소드
	 * 
	 * regist() : 회원가입 delete() : 회원탈퇴 login() : 로그인 logout() : 로그아웃 findAccount() :
	 * 아이디 찾기 findPassword() : 비밀번호 찾기 book() : 예약 bookcnl() : 예약취소
	 */

	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

	public static void regist() {
		// 회원가입

		Connection conn = null;// DB연결된 상태(세션)을 담은 객체
		PreparedStatement pstm = null; // SQL문을 나타내는 객체
		ResultSet rs = null; // 쿼리문을 날린것에 대한 반환 값을 담을 객체
		String quary = "SELECT MEM_ID FROM MEMBER";

		try {

			System.out.print("아이디 입력 : ");
			String id = "q001";

			// SQL 문장을 만들고 만약 문장이 질의어(SELECT문)라면
			// 그 결과를 담은 ResultSet 객체를 준비한 후 실행시킨다.

			conn = Control.getConnection();
			pstm = conn.prepareStatement(quary);
			rs = pstm.executeQuery();
			// 커밋을 해야된다 ㅅㅍ!
			
			
			while (rs.next()) {
				
				System.out.println(rs.getString("MEM_ID"));

				if (id.equals(id)) {
					System.out.println("이미 존재하는 아이디입니다.");
					break;
				} else {
					System.out.println("사용 가능한 아이디입니다.");
				}

			}

		} catch (SQLException sqle) {
			System.out.println("SELECT문에서 예외 발생");
			sqle.printStackTrace();

		} finally {
			// DB 연결을 종료한다
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	public static void delete() {
		// 회원탈퇴
	}

	public static void login() {
		// 로그인
	}

	public static void logout() {
		// 로그아웃
	}

	public static void findAccount() {
		// 아이디 찾기
	}

	public static void findPassword() {
		// 비밀번호 찾기
	}

	public static void book() {
		// 예약
	}

	public static void bookcnl() {
		// 예약취소
	}

	// 내부 기능
	public void id_duplicateCheck(String id) {

		String query = "SELECT 매개변수id FROM MEMBER";

		// DB에 query 날려서 null값인지 확인

	}

}
