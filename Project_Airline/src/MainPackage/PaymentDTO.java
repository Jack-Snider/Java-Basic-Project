package MainPackage;

public class PaymentDTO {

	String pay_num; //������ȣ
	String pay_mid; //ȸ�����̵�
	int pay_amt; //�����ݾ�
	int pay_tno; //Ƽ�Ϲ�ȣ
	String pay_date; //��������
	boolean hasPayed; // ��������

	public String getPay_num() {
		return pay_num;
	}

	public void setPay_num(String pay_num) {
		this.pay_num = pay_num;
	}

	public String getPay_mid() {
		return pay_mid;
	}

	public void setPay_mid(String pay_mid) {
		this.pay_mid = pay_mid;
	}

	public int getPay_amt() {
		return pay_amt;
	}

	public void setPay_amt(int pay_amt) {
		this.pay_amt = pay_amt;
	}

	public int getPay_tno() {
		return pay_tno;
	}

	public void setPay_tno(int pay_tno) {
		this.pay_tno = pay_tno;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	public boolean hasPayed() {
		return hasPayed;
	}

	public void setHasPayed(boolean hasPayed) {
		this.hasPayed = hasPayed;
	}


	
	
	
}
