package MainPackage;

//�������� �۾��� �̷������ Ŭ���� (DB����, CRUD ��...)
public class TicketDAO extends DBConnection{

	// �����ͺ��̽� ����
	public void accessDB() {
		DBConnection.getConnection();
	}
	
}
