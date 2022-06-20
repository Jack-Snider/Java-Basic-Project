package MainPackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

//실질적인 작업이 이루어지는 클래스 (DB연동, CRUD 등...)
public class TicketDAO extends DBConnection{
   static Connection conn;
   static Statement stmt;
   static PreparedStatement pstmt;
   static ResultSet rs;
   static int rs1;
   
   ArrayList<String> ticList = new ArrayList<String>(); // 티켓 목록을 저장할 변수
   static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   // 데이터베이스 연결
   public static void accessDB() {
      conn = DBConnection.getConnection();
   }
   


   // 항공편 조회
   public void showList() {
      
   }
   
   // 구매한 모든 티켓 보여줌
   public void showTicketList() {
      /*
       * 티켓 목록을 보여주고 그 중에서 하나를 선택해서
       * 디테일하게 보여줌
       * 
       * 
       * 
       */
   }
   
   // 구매한 하나의 티켓을 보여줌

   public static void tableView() throws SQLException {
      accessDB();
      String sql = "SELECT * FROM TICKET";
      //티켓을 관리자가 볼때: 항공편번호로 티켓이 몇장이 있는지
      //항공편 - 도착지 - 총몇장 - 남은 장수;
      //항공사 + 공항코드 + 출발일자 +출발시간 + 001~099 티켓좌석은 설정 가능한걸로.
      //항공권은 항공편번호 - 출발지 - 도착지 -출발일자 - 출발시간 - 탑승구(출발 )
      stmt = conn.createStatement();
      //뭘 보여줘? 티켓을 보여달라고 하면 뭘 보여줘? 항공편 - 도착지 - 총 몇장 - 남은 장수;
      
      //티켓번호 항공편번호, 도착지공항명(공항테이블), 
      
      rs = stmt.executeQuery(sql);
      System.out.println();
      String tk_tno, air_code, flight_no;
      String tk_bp ="";
      String tk_pr = "";
      String cart_no ="";
      while(rs.next()) {
         tk_tno = rs.getString("TK_TNO");
         
      }
      
   }


   public static void insert() throws IOException, SQLException {
      accessDB();
//      티켓번호 - 항공편번호 - 매입가 - 판매가 -
      System.out.println("--티켓 생성--");
      System.out.print("해당 항공편의 인덱스를 입력하시오: ");
      String idx = bf.readLine();
      String sql = "SELECT FLIGHT_NO, AIR_CODE FROM FLIGHT WHERE IDX = '"+ idx +"'"; 
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      String flight_no = rs.getString("FLIGHT_NO");
      String air_code   = rs.getString("AIR_CODE");
      if(rs.next()) {
         System.out.print("탑승구를 설정하시오: A~Z");
         String apt_gate = bf.readLine();
         
         String sql1 = "INSERT INTO AIRPORT (APT_GATE) "
                   + "VALUES(?) "
                   + "WHERE APT_AVL = (SELECT APT_AVL FROM FLIGHT"
                   +                "WHERE IDX = ?)";
         pstmt = conn.prepareStatement(sql1);
         pstmt.setString(1, apt_gate);
         pstmt.setString(2, idx);//String?int?
         rs1 = pstmt.executeUpdate();
         
         if(rs1 != 0) {
            System.out.print("티켓 한장당 가격을 설정하시오: ");
            int tk_bp = bf.read();
            float tk_pr = (float) (tk_bp * (1.1));
            System.out.print("총 좌석을 설정하시오: ");
            int tno = bf.read();
            
            String tk_tno;
            String sql2 = "INSERT INTO TICKET (TK_TNO, AIR_CODE, FLIGHT_NO, TK_BP, TK_PR) "
                  + "VALUES(?,?,?,?,?)";
            
            for(int i = 1; i <= tno; i++) {
               if(i< 10) {
                  tk_tno = flight_no +"00" +i;
                  
               }else if(i<100) {
                  tk_tno = flight_no +"0" +i;
                  
               }else {
                  tk_tno = flight_no + i;   
               }
               
               pstmt = conn.prepareStatement(sql2);
               pstmt.setString(1, tk_tno);
               pstmt.setString(2, air_code);
               pstmt.setString(3, flight_no);
               pstmt.setInt(4, tk_bp);
               pstmt.setFloat(5, tk_pr);
               rs1 = pstmt.executeUpdate();
               if(rs1 != 0 ) {
                  continue;
               }else {
                  System.out.println("오류티켓 생성");
                  
               }
               
            }
            System.out.println("생성완료");
            System.out.println("---------------------------------");
            
         }else {
            System.out.println("오류");
         }
         
      }else {
         System.out.println("없는 항공편입니다. ");
         System.out.println("항공편을 다시 확인해주세요. ");
         System.out.println("-----------------------------");
         insert();
      }
      
      
      
      
   }



   public static void update() throws IOException {
      System.out.println("티켓의 가격을 수정하시겠습니까?: YES or NO ");
      String input = bf.readLine();
      if(input.equalsIgnoreCase("yes")) {
         
      }else if(input.equalsIgnoreCase("no")) {
         System.out.println("티켓을 삭제하시겠습니다. ");
      }else {
         System.out.println("잘못 입력하였습니다.");
         System.out.println("다시");
         System.out.println("--------------------------");
         update();
         
         
      }
      
      
   }


   
   
}