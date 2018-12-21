import DAO.ordertableDAO;
import DAO.user_favorite_productDAO;
import DAO.user_wanna_productDAO;
import po.ordertable;
import po.upPrimaryKey;
import po.user_favorite_product;
import po.user_wanna_product;

import java.sql.*;
import java.util.List;

public class TestSh
{
    public static void main(String[] args)
    {
        ordertableDAO udao = new ordertableDAO();
        ordertable o =new ordertable();
        o.setOrderid("1");
        o.setEstablishtime();
        o.setAddressid("1");
        List<ordertable> list = null;
        try {
            udao.insert(o);
            ordertable ufp2 = new  ordertable();
            ufp2 = udao.get(o.getOrderid());
            System.out.println(ufp2.getEstablishtime());
            try {
                udao.update(ufp2.getOrderid(),null,ufp2.getAddressid());
            } catch (Exception e) {
                e.printStackTrace();
            }
            list = udao.search("1",null,null);
            udao.delete(ufp2.getOrderid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
