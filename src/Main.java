import java.sql.*;


public class Main {

//    private static ResultSet rs=null;
//    private static Connection conn=null;
//    private static PreparedStatement ps=null;

     public void connect(){
     }
    public static void main(String[] args) {
         ResultSet rs=null;
         Connection conn=null;
         PreparedStatement ps=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/test?userSSL=true&"
                    +"characterEncoding=utf-8&user=root&password=admin");
            System.out.println("连接成功!");
            String sql="select*from user_table";
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString(1)+rs.getString(2)+rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("连接失败!");
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }



    }


}
