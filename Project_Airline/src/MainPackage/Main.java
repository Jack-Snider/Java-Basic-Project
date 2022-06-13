package MainPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		
		MemberDAO mem = new MemberDAO();
		
		mem.accessDB();
		//mem.signIn();
		
		if(mem.logIn("b001","1000")) {
			System.out.println("로그인 성공!");
		}else {
			System.out.println("로그인 실패 ㅜㅜ");
		}
		
		
	}

}
