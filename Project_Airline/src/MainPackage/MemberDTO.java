package MainPackage;

public class MemberDTO {
	
	String mem_id; //ȸ���ƾƵ� 
	String mem_pw; //��й�ȣ
	String mem_rgon1; //�ֹι�ȣ ���ڸ�
	String mem_rgon2; //�ֹι�ȣ ���ڸ�
	String mem_nm; //����
	String mem_tel; //��ȭ��ȣ
	String mem_add; //�ּ�
	String mem_pp; //���ǹ�ȣ
	int mem_depm; //�����ݾ�
	
	
	MemberDTO(){}
	
	MemberDTO(String regon){
		
		String tmp = "";
		String tmp2 = "";
		
		boolean stat = false;
		for(int i = 0; i < tmp.length(); i++) {
			if(tmp.charAt(i) != '-') {
				// ���ڸ� ����
				tmp += tmp.charAt(i);
				stat = true;
			}
			
			if(stat) {
				// ���ڸ� ����
				tmp2 += tmp.charAt(i);
			}
			
		}
		
		this.mem_rgon1 = tmp;
		this.mem_rgon2 = tmp2;

		
		
		
		
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pw() {
		return mem_pw;
	}
	public void setMem_pw(String mem_pw) {
		this.mem_pw = mem_pw;
	}
	public String getMem_rgon1() {
		return mem_rgon1;
	}
	public void setMem_rgon1(String mem_rgon1) {
		this.mem_rgon1 = mem_rgon1;
	}
	public String getMem_rgon2() {
		return mem_rgon2;
	}
	public void setMem_rgon2(String mem_rgon2) {
		this.mem_rgon2 = mem_rgon2;
	}
	public String getMem_nm() {
		return mem_nm;
	}
	public void setMem_nm(String mem_nm) {
		this.mem_nm = mem_nm;
	}
	public String getMem_tel() {
		return mem_tel;
	}
	public void setMem_tel(String mem_tel) {
		this.mem_tel = mem_tel;
	}
	public String getMem_add() {
		return mem_add;
	}
	public void setMem_add(String mem_add) {
		this.mem_add = mem_add;
	}
	public String getMem_pp() {
		return mem_pp;
	}
	public void setMem_pp(String mem_pp) {
		this.mem_pp = mem_pp;
	}
	public int getMem_depm() {
		return mem_depm;
	}
	public void setMem_depm(int mem_depm) {
		this.mem_depm = mem_depm;
	}
	
	
	
}
