package MainPackage;

// Referenced Link : https://flatsun.tistory.com/385

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

//�������� �۾��� �̷������ Ŭ���� (DB����, CRUD ��...)
public class MemberDAO extends DBConnection{
	
	static String user_name = "";
	static String user_id = "";
	static boolean adminLog = false;  // �����ڰ� �α��� �ߴ��� Ȯ��
	/*
	 * 
	 * -���(Functions)-
	 * 1. ȸ������(SignIn)
	 * 2. �α���(LogIn) , �α׾ƿ�(Logout)
	 * 3. ȸ��Ż��(delAccount)
	 * 4. ���ų��� Ȯ��(checkReserve)
	 * 5. ���ų��� ����(updateReserve)
	 * 6. ����������(updateInfo)
	 * 7. �װ��Ǽ���(pickFlight)
	 * 8. �װ��ǰ���(payFlight)
	 * 
	 */
	
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static Connection conn;
	static boolean isLogined = false; // <- login status
	MemberDTO memDTO;
	
	// ���� DB�� ����.
	public static void accessDB() {
		conn = DBConnection.getConnection();
	}
	
	// ȸ��Ż�� - Delete Account
	public void delAccount() {
		
		// logined check first
		
		
	}
	
	// �α���
	public static boolean logIn(String id, String pw) {
		// This method returns true for login success
		
		
		
		String query = "SELECT * FROM MEMBER WHERE MEM_ID = " + " '" + id 
									+ "' " + " AND " + "MEM_PW = " + " '" + pw + "'";
		
		
		try {
			
			Statement stmt = conn.createStatement();
			//stmt.executeQuery(query);
			ResultSet rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				// ����ڰ� �Է��� ���̵�� ����� �����ͺ��̽����� ��ġ�ϴ°� ����
				user_name = rs.getString("MEM_NM");
				user_id = rs.getString("MEM_ID");
				isLogined = true;
				
			}else {
				System.out.println("���̵�/��й�ȣ�� ��ġ���� �ʰų� ���Ե� ȸ���� �ƴմϴ�.");
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return isLogined;
	}
	
	
	// ȸ������
	public static void signIn() {
		/*
		 * ����� ȸ������ �޼ҵ�
		 * ����ڰ� �Է��ؾ� �� ����
		 * 1. ȸ�����̵� (�ߺ��˻� �ǽ�)
		 * 2. ��й�ȣ
		 * 3. ��й�ȣ Ȯ�� (Ʋ���� ó������ ���ư�) -> ����
		 * 4. �ֹι�ȣ (��, �� �����ؼ� ���������� �ڸ�����)
		 * 5. �̸�
		 * 
		 * 
		 * 
		 * ȸ�� ���̺� : MEMBER
		 * 
		 * MEM_ID (NOT NULL)
		 * MEM_PW (NOT NULL)
		 * MEM_RGON1 (NOT NULL)
		 * MEM_RGON2 (NOT NULL)
		 * MEM_NM (NOT NULL)
		 * MEM_TEL (NOT NULL)
		 * MEM_ADD (NULL AVAIBLE)
		 * MEM_PP (NULL AVAIABLE)
		 * MEM_DEPM (NULL AVAIBLE)
		 * MEM_ENAME (NOT NULL)
		 * 
		 * 
		 * 
		 */
		try {
			
			Statement stmt = conn.createStatement();
			
			
			System.out.println("�޴��� ���ư��� : m , �ڷΰ��� : < ");
			while(true) { // while starts
				System.out.print("����� ���̵� �Է� : "); // ���̵� �Է�
				String mem_id = bf.readLine();
				
				// ���̺��� ���� ��������� �ʾ����Ƿ� ���� ���鿹��, ������ �ٸ� DB���� �׽�Ʈ��.
				ResultSet rs = stmt.executeQuery("SELECT * FROM MEMBER WHERE MEM_ID = " + "\'" + mem_id + "\'");
				
				//�Էµ� ���̵�� ��ȸ�� �ȴٸ�(rs�� ���� ���ִٸ�)
				if(rs.next()) {
					System.out.println("�ش� ���̵�� �̹� �����ϴ� ���̵��Դϴ�.");
					continue;
				}else {					
					
/*
 * MEM_ID (NOT NULL)
		 * MEM_PW (NOT NULL)
		 * MEM_RGON1 (NOT NULL)
		 * MEM_RGON2 (NOT NULL)
		 * MEM_NM (NOT NULL)
		 * MEM_TEL (NOT NULL)
		 * MEM_ADD (NULL AVAIBLE)
		 * MEM_PP (NULL AVAIABLE)
		 * MEM_DEPM (NULL AVAIBLE)
		 * MEM_ENAME (NOT NULL)
 * 
 * 
 */
					
					System.out.print("��й�ȣ �Է� : "); // ��й�ȣ �Է� (MEM_PW)
					String mem_pw = bf.readLine();
					System.out.print("�ֹι�ȣ(���ڸ�) : "); // �ֹι�ȣ ���ڸ� �Է� (MEM_RGON1)
					String mem_regon1 = bf.readLine();
					System.out.print("�ֹι�ȣ(���ڸ�) : "); // �ֹι�ȣ ���ڸ� �Է�(MEM_RGON2)
					String mem_regon2 = bf.readLine();
					System.out.print("�̸� �Է� : "); // �̸��Է� (MEM_NM)
					String mem_nm = bf.readLine();
					System.out.print("��ȭ��ȣ �Է� : "); // ��ȭ��ȣ �Է� (MEM_TEL)
					String mem_tel = bf.readLine();
					System.out.print("�ּ� : "); // �ּ��Է� (MEM_ADD)
					String mem_add =  bf.readLine();
					System.out.print("���ǹ�ȣ : "); // MEM_PP
					String mem_pp = bf.readLine();
					System.out.print("�����ݾ� : "); // MEM_DEPM
					String mem_depm = bf.readLine();
					System.out.print("�������� : "); // MEM_ENAME
					String mem_ename = bf.readLine(); 
					
					
					
					/*
					 * Insert������ �����ͺ��̽��� ������� �� while�� break
					 * 
					 */
					
					
					String sign_query = "INSERT INTO MEMBER(MEM_ID, MEM_PW,"
							+ "MEM_RGON1, MEM_RGON2, MEM_NM, MEM_TEL, MEM_ADD,"
							+ "MEM_PP, MEM_DEPM, MEM_ENAME) "
							+ " VALUES(" + "'" + mem_id + "' , " +
							"'" + mem_pw + "' , " +
							"'" + mem_regon1 + "' , " +
							"'" + mem_regon2 + "' , " + 
							"'" + mem_nm + "' , " + 
							"'" + mem_tel + "' , " + 
							"'" + mem_add + "' , " + 
							"'" + mem_pp + "' , " + 
							"'" + mem_depm + "' ," + 
							"'" + mem_ename + "')";
							
					System.out.println(sign_query);
					stmt.executeQuery(sign_query);
					View.menuView();
					 
					
				}
				
				
				
				
				
							
				
			} // while ends
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// ȸ��Ż��
	public static void deleteAccount() { //ȸ��Ż�� ����
		
		String query = "DELETE FROM MEMBER WHERE MEM_ID = " + "'" + user_id + "'";
	
		
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeQuery(query);
			user_name = "";	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	} // ȸ��Ż�� ��
	
	//ȸ������ ����
	public static void update() { // ȸ���������� ����
		
		/*
		 * ȸ�� �����ΰ� ������ �� �ִ� �׸�
		 * 1. ��й�ȣ
		 * 2. �̸�
		 * 3. �����̸�
		 * 4. ��ȭ��ȣ
		 * 5. �ּ�
		 * 6. ���ǹ�ȣ
		 */
		
		// ȸ���� ������ ���� �������. (�ڽ��� ������ ���鼭 ������ �����ϰ� ������ ������ �� �ְ�)
		try {
			
			String query = "SELECT * FROM MEMBER WHERE MEM_ID = " + "'" + user_id + "'";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				String mem_id = rs.getString("MEM_ID");
				String mem_pw = rs.getString("MEM_PW");
				String mem_rgon1 = rs.getString("MEM_RGON1");
				String mem_rgon2 = rs.getString("MEM_RGON2");
				String mem_nm = rs.getString("MEM_NM");
				String mem_ename = rs.getString("MEM_ENAME");
				String mem_tel = rs.getString("MEM_TEL");
				String mem_add = rs.getString("MEM_ADD");
				String mem_pp = rs.getString("MEM_PP");
				String mem_depm = rs.getString("MEM_DEPM");
				
				
				System.out.println("�����ϰ� ������ �׸� ���� ���� ��ɾ �Է��Ͽ� �����Ͻø� �˴ϴ�.");
				
				System.out.println("           ������������������" + mem_nm + "���� ȸ������ ������������������");
				System.out.println("          ��" + "��\t\t\t��\t\t\t��: " + mem_id);
				System.out.println("[pw]  ��" + "��\t\t��\t\t��\t\tȣ : " + mem_pw);
				System.out.println("			��" + "�ֹε�Ϲ�ȣ(���ڸ�)(�����Ұ�) : " + mem_rgon1);
				System.out.println("		    ��" + "�ֹε�Ϲ�ȣ(���ڸ�)(�����Ұ�) : " + mem_rgon2);
				System.out.println("[enm]�� " + "��\t\t��\t\t��\t\t�� : " + mem_ename);
				System.out.println("[tel]   �� " + "��\t\tȭ\t\t��\t\tȣ : " + mem_tel);
				System.out.println("[add] �� " + "��\t\t\t\t\t\t�� : " + mem_add);
				System.out.println("[pp]   �� " + "��\t\t��\t\t��\t\tȣ : " + mem_pp);
				System.out.println("           ��" + "��\t\t��\t\t��\t\t�� : " + mem_depm);
				System.out.println("            ������������������������������������������������������������");
			}
			
			System.out.print(user_name + " >> ");
			String input = bf.readLine();
			
			
			String qry = "";
			
			if(input.equalsIgnoreCase("pw")) { // ��й�ȣ ���� ����
				
				System.out.println("������ ��й�ȣ�� �Է�!");
				System.out.print(user_name + " >> ");
				String pw_change = bf.readLine();
				
				qry = "UPDATE MEMBER SET MEM_PW = " + "'" + pw_change + "'" + " WHERE MEM_ID = "
							+ "'" + user_id + "'";
				
				stmt.executeQuery(qry);
				System.out.println();
				System.out.println("��������������������������������������");
				System.out.println("����й�ȣ�� ���������� ����Ǿ����ϴ�!   ��");
				System.out.println("��������������������������������������");
				View.menuView();
				
				
			}else if(input.equalsIgnoreCase("enm")) { // �������� ���� ����
				
				System.out.println("������ ������ �Է�!");
				System.out.print(user_name + " >> ");
				String ename_change = bf.readLine();
				
				qry = "UPDATE MEMBER SET MEM_ENAME = " + "'" + ename_change + "'" + " WHERE MEM_ID = "
							+ "'" + user_id + "'";
				
				
				stmt.executeQuery(qry);
				System.out.println();
				System.out.println("��������������������������������������");
				System.out.println("������������ ���������� ����Ǿ����ϴ�!  ��");
				System.out.println("��������������������������������������");
				View.menuView();
				
			}else if(input.equalsIgnoreCase("tel")) { // ��ȭ��ȣ ���� ����
				
				System.out.println("������ ��ȭ��ȣ �Է�!");
				System.out.print(user_name + " >> ");
				String tel_change = bf.readLine();
				
				qry = "UPDATE MEMBER SET MEM_TEL = " + "'" + tel_change + "'" + " WHERE MEM_ID = "
							+ "'" + user_id + "'";
				
				
				stmt.executeQuery(qry);
				System.out.println();
				System.out.println("��������������������������������������");
				System.out.println("����ȭ��ȣ�� ���������� ����Ǿ����ϴ�!  ��");
				System.out.println("��������������������������������������");
				View.menuView();
				
			}else if(input.equalsIgnoreCase("add")) {// �ּ� ���� ����
				
				System.out.println("������ �ּ� �Է�!");
				System.out.print(user_name + " >> ");
				String add_change = bf.readLine();
				
				qry = "UPDATE MEMBER SET MEM_ADD = " + "'" + add_change + "'" + " WHERE MEM_ID = "
							+ "'" + user_id + "'";
				
				
				stmt.executeQuery(qry);
				System.out.println();
				System.out.println("��������������������������������������");
				System.out.println("���ּҰ� ���������� ����Ǿ����ϴ�!         ��");
				System.out.println("��������������������������������������");
				View.menuView();
				
			}else if(input.equalsIgnoreCase("pp")) { // ���ǹ�ȣ ���� ����
				
				System.out.println("���ο� �Է�!");
				System.out.print(user_name + " >> ");
				String pp_change = bf.readLine();
				
				qry = "UPDATE MEMBER SET MEM_ENAME = " + "'" + pp_change + "'" + " WHERE MEM_ID = "
							+ "'" + user_id + "'";
				
				
				stmt.executeQuery(qry);
				System.out.println();
				System.out.println("��������������������������������������");
				System.out.println("�����ǹ�ȣ�� ���������� ����Ǿ����ϴ�!  ��");
				System.out.println("��������������������������������������");
				View.menuView();
			}else {
				
				System.out.println("                           ������ ");
				System.out.println("                         ��        ��");
				System.out.println("                         ��        ��");
				System.out.println("                         ��        ��");
				System.out.println("                         ��        ��");
				System.out.println("��������   ������            ������ ��������");
				System.out.println("��          ��         ��       ��        ��           ��");
				System.out.println("��������������������������������������");
				System.out.println("���ùٸ��� ���� �Է������Դϴ�. (- -)     ��");
				System.out.println("��������������������������������������");
				View.menuView();
				
			}
			
			
		}catch(Exception e) {
			
		}
		
		
	}// ȸ���������� ��
	
	
}
