import DAO.*;
import po.*;

import java.sql.*;
import java.util.List;

public class TestSh
{
    public static void main(String[] args)
    {
        storeDAO udao = new storeDAO();
        store s =new store();
        s.setStoreid("2");
        s.setOwnerinfo("lyq");
        s.setAddress("home");
        List<store> list = null;
        try {
            udao.insert(s);
            store ufp2 = new  store();
            ufp2 = udao.get(s.getStoreid());
            System.out.println(ufp2.getOwnerinfo());
            try {
                udao.update(ufp2.getStoreid(),"lyq2","secret-base");
            } catch (Exception e) {
                e.printStackTrace();
            }
            list = udao.search(ufp2.getStoreid(),null,null);
            udao.delete(ufp2.getStoreid());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(list.get(0).getOwnerinfo());
    }
}
