/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my_package;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
/**
 *
 * @author anubhav_pc
 */
public class retubkdat {
    public static int updatebook(String bookid){
            Connection con ;
            PreparedStatement pst ;
        
		int status=0;
		int quantity=0,issued=0;
		try{
                    con = DriverManager.getConnection("jdbc:mysql://localhost/libraryproject", "root", ""); 
                    pst=con.prepareStatement("select quantity,issued from bookdetails where bookid=?");
                    pst.setString(1,bookid);
			ResultSet rs=pst.executeQuery();
                         JOptionPane.showMessageDialog(null,"update e enter kreche");
			//if
                        rs.next();
                                //){
				quantity=rs.getInt("quantity");
				issued=rs.getInt("issued");
                                JOptionPane.showMessageDialog(null,"quantity details fetched");
			//}
                        if(issued>0){
                        PreparedStatement ps2=con.prepareStatement("update books set quantity=?,issued=? where bookid=?");
			ps2.setInt(1,quantity+1);
			ps2.setInt(2,issued-1);
			ps2.setString(3,bookid);
                        
                        status=ps2.executeUpdate();
                        JOptionPane.showMessageDialog(null,"updated the quantity");
			}
			//con.close();
			
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"updation failed");
                }return status;
}
    
	public static int delete(String bookid,int userid){
            Connection con ;
            PreparedStatement pst ;
        
		int status=0;
		try{
                    con = DriverManager.getConnection("jdbc:mysql://localhost/libraryproject", "root", ""); 
                    JOptionPane.showMessageDialog(null,"connection done");
                    status=updatebook(bookid);
                     JOptionPane.showMessageDialog(null,"dlt e cn er por esche");
                    //updating quantity and issue}
                    
                    if(status>0){
			 //pst=con.prepareStatement("delete from issuedetails where bookid=? and userid=?");
                         pst=con.prepareStatement("DELETE FROM issuedetails WHERE userid=? and bookid=? ");
			pst.setInt(1,userid);
			pst.setString(2,bookid);
			status=pst.executeUpdate();
                        JOptionPane.showMessageDialog(null,"dlt done");
			}else {
                        JOptionPane.showMessageDialog(null,"deletion failed if not stisfied");
                    }
                    //con.close();
                }catch(Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null,"deletion failed");
                }
                return status;
}
        
}
