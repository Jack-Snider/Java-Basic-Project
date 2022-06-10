package MainPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) {
		
		
		MemberDAO mem = new MemberDAO();
		mem.getConnection();
		
		
		
	}

}
