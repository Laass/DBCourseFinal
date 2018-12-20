import DAO.DAOBase;

import java.sql.*;

public class TestSh
{
    public static void main(String[] args)
    {
        try
        {
            Connection conn=new DAOBase().getConn();
            Statement st=conn.createStatement();
            ResultSet rs=st.executeQuery("SELECT * FROM user");
            while(rs.next())
            {
                System.out.println(rs.getString(1)+rs.getString(2));
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
