package MainPackage;

//�������� �۾��� �̷������ Ŭ���� (DB����, CRUD ��...)
public class AirportDAO extends DBConnection{

	// �����ͺ��̽� ����
	public void accessDB() {
		DBConnection.getConnection();
	}
	
}
