import DAO.DAOBase;
import DAO.ProductClassifyDAO;
import DAO.ProductDAO;
import po.Product;
import po.ProductClassify;

import java.sql.*;

public class TestSh
{
    public static void main(String[] args)
    {
        try
        {
            Product pro = new Product(22, "2018女装毛衣", "详情介绍", "e:/", null, "1");
            ProductDAO prodao = new ProductDAO();
            /*System.out.println(prodao.insert(pro) + "   " + pro.getPid());
            System.out.println(prodao.get("124").getTitle());
            pro.setTitle("更改后的裙子标题");
            prodao.update(pro);
            System.out.println(pro.getTitle());
            System.out.println(prodao.delete(pro));*/
            prodao.insert(pro);

            ProductClassifyDAO pcdao = new ProductClassifyDAO();
            ProductClassify pc = new ProductClassify(15,pro.getPid(),null);
            pcdao.insert(pc);
            System.out.println(pcdao.get(pc).getPid());
            System.out.println(pcdao.findProductByType(9).size());
            System.out.println(pcdao.delete(pc));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }

    }
}
