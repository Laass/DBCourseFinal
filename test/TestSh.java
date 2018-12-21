import DAO.ordertableDAO;
import DAO.ordertable_productDAO;
import DAO.user_favorite_productDAO;
import DAO.user_wanna_productDAO;
import po.*;

import java.sql.*;
import java.util.List;

public class TestSh
{
    public static void main(String[] args)
    {
        ordertable_productDAO udao = new ordertable_productDAO();
        ordertable_product o =new ordertable_product();
        opPrimaryKey op = new opPrimaryKey();
        op.setOrderid("1");
        op.setPid("123");
        o.setProNum(3);
        o.setKey(op);
        List<ordertable_product> list = null;
        try {
            udao.insert(o);
            ordertable_product ufp2 = new  ordertable_product();
            ufp2 = udao.get(o.getKey());
            System.out.println(ufp2.getProNum());
            ufp2.setProNum(5);
            try {
                udao.update(ufp2);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list = udao.search("1",null,5);
            udao.delete(ufp2.getProNum());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0).getProNum());
    }
}
