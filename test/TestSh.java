import DAO.user_favorite_productDAO;
import DAO.user_wanna_productDAO;
import po.upPrimaryKey;
import po.user_favorite_product;
import po.user_wanna_product;

import java.sql.*;
import java.util.List;

public class TestSh
{
    public static void main(String[] args)
    {
        user_favorite_productDAO udao = new user_favorite_productDAO();
        upPrimaryKey up = new upPrimaryKey();
        user_favorite_product ufp = new  user_favorite_product();
        up.setProductid("123");
        up.setUserid("1");
        ufp.setKey(up);
        List<user_favorite_product> list = null;
        try {
            udao.insert(ufp);
            user_favorite_product ufp2 = new  user_favorite_product();
            ufp2 = udao.get(up);
            System.out.println(ufp2.getKey().getUserid());
            list = udao.search("1",null);
            udao.delete(up);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
