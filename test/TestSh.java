import DAO.UserDAO;
import DAO.UserInfoDAO;
import po.User;
import po.UserInfo;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;


public class TestSh
{
    public static void main(String[] args)
    {
        try
        {
//            Connection conn=new DAOBase().getConn();
//            Statement st=conn.createStatement();
//            ResultSet rs=st.executeQuery("SELECT * FROM user");
//            while(rs.next())
//            {
//                System.out.println(rs.getString(1)+rs.getString(2));
//            }
//            测试UserDAO部分
//            UserDAO uDAO=new UserDAO();
//            User u=new User("2","123","2222","4444");
//            uDAO.update(u);
//            uDAO.insert(u);
//            uDAO.delete(u);
//            System.out.println(uDAO.get(u));
//            System.out.println(uDAO.get(u.getUserId()));
//            System.out.println(uDAO.getByPhone("2222"));
//            System.out.println(uDAO.getByEmail("2222"));
//            System.out.println(uDAO.searchByUserId("aa"));
//            System.out.println(uDAO.searchByEmail("bb"));
//            System.out.println(uDAO.delete("2aa2"));
//            测试UserInfoDAO部分
            UserInfoDAO uiDAO=new UserInfoDAO();
//            for(int i=1;i<2;i++)
//            {
//                UserInfo ui=new UserInfo();
//                ui.setUserId(Integer.toString(i));
//                ui.setNickName("1nickname");
//                ui.setProtrait("no portrait");
//                ui.setSex('M');
//                ui.setBirthday(new Timestamp(new Date().getTime()));
//                ui.setIDNum("9999");
//                uiDAO.insert(ui);
//            }
//            uiDAO.delete(ui);
//            System.out.println(uiDAO.get(ui));
//            ui.setIDNum("923923982398");
//            uiDAO.update(ui);
//            uiDAO.delete(ui.getUserId());
//            System.out.println(uiDAO.searchByUserNick("nickname"));
//            System.out.println(uiDAO.searchByUserId("aa"));
//            System.out.println(uiDAO.searchBySex('m'));
//            System.out.println(uiDAO.searchBySex('f'));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
