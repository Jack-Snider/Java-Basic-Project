package MainPackage;

import java.util.ArrayList;

//�������� �۾��� �̷������ Ŭ���� (DB����, CRUD ��...)
public class TicketDAO extends DBConnection{

	
	ArrayList<String> ticList = new ArrayList<String>(); // Ƽ�� ����� ������ ����
	
	// �����ͺ��̽� ����
	public void accessDB() {
		DBConnection.getConnection();
	}
	
	// ������ ��� Ƽ�� ������
	public void showTicketList() {
		/*
		 * Ƽ�� ����� �����ְ� �� �߿��� �ϳ��� �����ؼ�
		 * �������ϰ� ������
		 * 
		 * 
		 * 
		 */
	}
	
	// ������ �ϳ��� Ƽ���� ������
	public void showDetailTicket() {
		// ������ �������� ǥ��
	}
	
	
	
}
