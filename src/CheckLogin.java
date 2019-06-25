
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CheckLogin  extends UnicastRemoteObject implements  LoginInterface
{
    public CheckLogin()throws RemoteException
    {
    }
public boolean check(String userId,String password)throws RemoteException
{
   
    try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            PreparedStatement   st=connection.prepareStatement("select * from securitytableid where id=? and pass=?");
            st.setString(1,userId);
            st.setString(2,password);
             ResultSet rs=st.executeQuery();
            if(rs.next())    
                return true;
            else
    return false;

        }
    catch(Exception ex)
    {
        return false;
    }
    
}
}    
//if(userId.equals("abc") && password.equals("abc123"))    
//    return true;
//else
//    return false;



