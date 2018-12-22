import DAO.AddressDAO;
import DAO.CommentDAO;
import DAO.UserDAO;
import DAO.UserInfoDAO;
import po.Address;
import po.Comment;
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
//            UserInfoDAO uiDAO=new UserInfoDAO();
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
//            测试AddressDAO
//            AddressDAO aDAO=new AddressDAO();
//            Address a=new Address("1","address","receiver","123");
//            aDAO.insert(a);
//            Address b=new Address();
//            b.setAddressId("63db99b18fd049968b5979d898da0c36");
//            aDAO.delete(b);
//            a=aDAO.get("4d611f4106734c5e820fe42f8311a804");
//            a.setAddress("addressAddress");
//            aDAO.update(a);
//            aDAO.delete("4d611f4106734c5e820fe42f8311a804");
//            Address b=new Address();
//            b.setAddressId("34dd1abf6d9c42119bd562ab0cc84326");
//            aDAO.delete(b);
//            aDAO.insert(a);
//            aDAO.insert(a);
//            System.out.println(aDAO.searchByAddress("dd"));
//            System.out.println(aDAO.searchByReceiver("ce"));
//            System.out.println(aDAO.searchByTel("123"));
//            System.out.println(aDAO.searchByUserId("2"));
//            测试CommentDAO
            CommentDAO cDAO=new CommentDAO();
//            cDAO.insert(new Comment("1","123","commentcomment",'3'));
//            cDAO.delete(new Comment("4acd83770e0e4c8f9ae6f017db04b380","1","123","commentcomment",'3'));
//            cDAO.update(new Comment("d39d1f181aa34115bc8ad3485b186f9a","1","123","CommComment",'3'));
//            System.out.println(cDAO.get(new Comment("d39d1f181aa34115bc8ad3485b186f9a","1","123","CommComment",'3')));
//            Comment c=new Comment();
//            c.setCommentId("d39d1f181aa34115bc8ad3485b186f9a");
//            System.out.println(cDAO.get("d39d1f181aa34115bc8ad3485b186f9a"));
//            System.out.println(cDAO.deleteById("d39d1f181aa34115bc8ad3485b186f9a"));
//            System.out.println(cDAO.deleteByUser("1"));
//            System.out.println(cDAO.searchByUserId("1"));
//            System.out.println(cDAO.searchByContent("mm"));
            System.out.println(cDAO.searchBypId("123"));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
