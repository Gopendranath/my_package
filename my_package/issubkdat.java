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
//import static my_package.issubkdat.updatebook;

/**
 *
 * @author anubhav_pc
 */
public class issubkdat {
     Connection con ;
     PreparedStatement pst;
     
    public static boolean checkBook(String bookid){
        Connection con ;
        PreparedStatement pst ;
	boolean status=false;
	try{
		con = DriverManager.getConnection("jdbc:mysql://localhost/libraryproject", "root", "");
                pst = con.prepareStatement("select * from bookdetails where bookid=?");
		
		pst.setString(1,bookid);
	    ResultSet rs=pst.executeQuery();
		status=rs.next();
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}


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
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
                        JOptionPane.showMessageDialog(null,"quantity details fetched");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update bookdetails set quantity=?,issued=? where bookid=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setString(3,bookid);
		
		status=ps2.executeUpdate();
		}
		//con.close();
	}catch(Exception e){System.out.println(e);
        JOptionPane.showMessageDialog(null,"book not available for issue");}
	return status;
        
}



        public static int save(String userid,String bookid,String duedate){
            Connection con ;
            PreparedStatement pst;
	int status=0;
	try{
    con = DriverManager.getConnection("jdbc:mysql://localhost/libraryproject", "root", "");
		
		
		status=updatebook(bookid);//updating quantity and issue
		
		if(status>0){
             pst=con.prepareStatement("insert into issuedetails(userid,bookid,duedate,status) values(?,?,?,?)");
		pst.setString(1,userid);
		pst.setString(2,bookid);
		//pst.setString(3,issuedate);
                pst.setString(3,duedate);
                pst.setString(4,"pending");
		status=pst.executeUpdate();
		}
		
		//con.close();
	}catch(Exception e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,e);
        }
	return status;
}
}


    