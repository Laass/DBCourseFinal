import DAO.DAOBase;
import DAO.UserDAO;
import po.User;

import java.sql.*;

public class TestSh
{
    public static void main(String[] args)
    {
        try
        {
            Connection conn=new DAOBase().getConn();
            Statement st=conn.createStatement();
//            ResultSet rs=st.executeQuery("SELECT * FROM user");
//            while(rs.next())
//            {
//                System.out.println(rs.getString(1)+rs.getString(2));
//            }
            UserDAO uDAO=new UserDAO();
            User u=new User("2","123","2222","4444");
//            uDAO.update(u);
//            uDAO.insert(u);
//            uDAO.delete(u);
//            System.out.println(uDAO.get(u));
//            System.out.println(uDAO.get(u.getUserId()));
//            System.out.println(uDAO.getByPhone("2222"));
//            System.out.println(uDAO.getByEmail("2222"));
//            System.out.println(uDAO.searchByUserId("aa"));
//            System.out.println(uDAO.searchByEmail("bb"));
            System.out.println(uDAO.delete("2aa2"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
