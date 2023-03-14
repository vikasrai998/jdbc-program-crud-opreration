
import java.sql.*;
import java.util.Scanner;
// Data Insert Into xamm Server
public class InsertUpdateDelete {

 private static void InsertData() {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter User Name");
    String User_Name = sc.nextLine();
    System.out.println("Enter User Password");
    String User_Password = sc.nextLine();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull", "root", "");
            //String sql =" INSERT INTO `user_login`(?,?)";
          String sql = "INSERT INTO `user_login`(`UserName`, `UserPassword`) VALUES ('"+User_Name+"','"+User_Password+"')";
          PreparedStatement pstm = (PreparedStatement) con.prepareStatement(sql);
          pstm.executeUpdate();
          System.out.println("Data Insert ");
        
     con.close();
    }
    catch (Exception e) {
        System.out.println(e);
    }
    ShowData();

 }
 private static void ShowData(){
    try {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull", "root", "");
        String qry= " SELECT * FROM `user_login`";
        PreparedStatement pstm = (PreparedStatement)con.prepareStatement(qry);
        ResultSet rs = pstm.executeQuery();
         while(rs.next()){
            System.out.println(rs.getInt("Login_id")+ " \t-\t "+ rs.getString("UserName")+" \t-\t "+rs.getString("UserPassword"));
         }
         con.close();
    }
    catch (Exception e) {
        System.out.println(e);
    }

 }


  static void DeleteData(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Name you want to delete");
    String UserName_serch = sc.nextLine();

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull", "root", "");
        String sql ="DELETE FROM `user_login` WHERE UserName='"+UserName_serch+"'";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.executeUpdate();
        con.close();
        System.out.println("Data Deleted" +UserName_serch);

    }catch(Exception e){
        System.out.println(e);
    }
    ShowData();
  }
  static void UpdateData(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter Name you want to User_ID");
    int UserID= sc.nextInt();


    System.out.println("Enter Name you want to Update");
    String UserName_serch = sc.nextLine();

    System.out.println("Enter User Nmae");
    String Update_nm = sc.nextLine();
    System.out.println("Enter Password");
    String Update_ps= sc.nextLine();

    try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student?zeroDateTimeBehavior=convertToNull", "root", "");
        String sql ="UPDATE `user_login` SET`UserName`='"+Update_nm+"',`UserPassword`='"+Update_ps+"' WHERE `Login_id`='"+UserID+"' OR `UserName`='"+UserName_serch+"'";
        PreparedStatement pstm = con.prepareStatement(sql);
        pstm.executeUpdate();
        con.close();

    }catch(Exception e){
        System.out.println(e);
    }
    ShowData();
  }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //ShowData();
        //InsertData();
        //DeleteData();
       //UpdateData();
       //ShowData()R
       System.out.println("INSERT  : I");
       System.out.println("DELETE  : D");
       System.out.println("UPDATE  : U");
       System.out.println("SHOW    : S");
       System.out.println("Exit : E");

     
       

    for(char i='A';i<'Z';i++){
    System.out.println("Welcome To Main Menu ");
    char ch=sc.next().charAt(0);
     char ch1 =Character.toUpperCase(ch);
       switch (ch1) {
        case 'I':
         InsertData();  
         System.out.println(" Data Insert ");
            break;
            case 'D':
              DeleteData();   
              System.out.println(" Data Delete ");
               break;
               case 'U':
                   UpdateData();   
                   System.out.println(" Data Update ");
                  break;
                  case 'S':
                   ShowData();   
                     break;
                     case 'E':
                     System.exit(0);
       
        default:
        System.out.println("Enter Valide Charater in given");
            break;
       }
   
    }

    }

}
