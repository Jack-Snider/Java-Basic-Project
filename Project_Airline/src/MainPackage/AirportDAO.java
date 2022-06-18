package MainPackage;

import java.sql.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//실질적인 작업이 이루어지는 클래스 (DB연동, CRUD 등...)
public class AirportDAO extends DBConnection {
   static Connection conn;

   // 데이터베이스 연결
   static PreparedStatement pstmt = null;
   static ResultSet rs = null;
   static int rs1 = 0;
   static Statement stmt = null;
   static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   static AirportDTO apd;

   public static void accessDB() {
      conn = DBConnection.getConnection();
   }

   public static void tableView() throws SQLException, ClassNotFoundException, IOException {
      accessDB();

      String sql = "SELECT APT_AVL 공항코드, " + "APT_NM 공항명, " + "SUBSTR(APT_NM, 1, LENGTH(APT_NM)-4) \"도착지\""
            + "FROM AIRPORT";
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);

      System.out.println("공항코드        공항명    도착지");
      while (rs.next()) {
         String apt_avl = rs.getString("공항코드");
         ;
         String apt_nm = rs.getString("공항명");
         ;
         String country = rs.getString("도착지");

         System.out.println(apt_avl + "  " + apt_nm + "  " + country);
      }
      AdminView.manageAirport();// 공항 정보관리로 이동

   }

   public static void insert() throws ClassNotFoundException, IOException, SQLException {
      accessDB();
      apd = new AirportDTO();

      System.out.println("공항정보 추가");
      System.out.print("공항코드: ");
      apd.setAptAvl(bf.readLine());// 공항코드
      System.out.print("공항명: ");
      apd.setAptNm(bf.readLine());// 공항명

      String sql = "INSERT INTO AIRPORT (APT_AVL, APT_NM)" + "VALUES(?,?)";

      String apt_avl = apd.getAptAvl();
      String apt_nm = apd.getAptNm() + " 국제공항";
      stmt = conn.createStatement();
      rs = stmt.executeQuery("SELECT APT_AVL FROM AIRPORT WHERE APT_AVL = '" + apt_avl + "'");
      if (rs.next()) {
         System.out.println("중복된 공항코드가 존재함");
         System.out.println("다시");
         System.out.println("-------------------------------");
         insert();
      } else {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, apt_avl);
         pstmt.setString(2, apt_nm);
         rs1 = pstmt.executeUpdate();
         
         if (rs1 != 0) {
            System.out.println("추가완료");
            System.out.println("------------------------------");
            AdminView.menuView();
         } else {
            System.out.println("오류");
            System.out.println("------------------------------");
         }

      }

      // 끝나면 돌아가기
   }
   
   public static void update() throws IOException {
      accessDB();
      String sql = "";
      
      System.out.println("공항 고유번호는 수정불가");
      System.out.println("1. 공항명 수정");
      System.out.println("2. 공항코드 삭제");
      System.out.println("<. 돌아가기");
      String input = bf.readLine();
      if(input == "1") {
//         System.out.print("변경하고자 하는 공항코드를 입력하시오: ");         String 
      
      }
   
   }
}
//AdminView.manageAirport();// 공항 정보관리로 이동