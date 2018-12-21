import DAO.DAOBase;
import DAO.ProductDAO;
import po.Product;
import po.TypeTree;

import java.sql.*;

public class TestSh
{
    public static void main(String[] args)
    {
//        try
//        {
           /* Product pro = new Product(22, "2018女装毛衣", "详情介绍", "e:/", null, "1");
            ProductDAO prodao = new ProductDAO();
            System.out.println(prodao.insert(pro) + "   " + pro.getPid());
            System.out.println(prodao.get("124").getTitle());
            pro.setTitle("更改后的裙子标题");
            prodao.update(pro);
            System.out.println(pro.getTitle());
            System.out.println(prodao.delete(pro));*/
            TypeTree tt = new TypeTree();
            tt = tt.createTree(2,4,"");
            System.out.println(tt.getRangenex() + "   " + tt.getRangepre());
//        }
//        catch (SQLException e)
//        {
//            e.printStackTrace();
//        }

    }
}
