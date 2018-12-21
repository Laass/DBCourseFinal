import DAO.user_wanna_productDAO;
import po.user_wanna_product;
import po.uwpPrimaryKey;

import java.sql.*;
import java.util.List;

public class TestSh
{
    public static void main(String[] args)
    {
        user_wanna_productDAO udao = new user_wanna_productDAO();
        List<user_wanna_product> list = null;
        try {
            list = udao.search("1","123",-1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
