package DAO;

import po.upPrimaryKey;
import po.user_favorite_product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//没有updaye函数
public class user_favorite_productDAO extends DAOBase implements DAOBaseOperate<Object> {
    public Boolean insert(Object o) throws SQLException { return false;}
    public Boolean delete(Object o) throws SQLException{ return false;}
    public Boolean update(Object o) throws SQLException{ return false;}
    public Object get(Object o) throws SQLException{ return null;}

    public Boolean insert(user_favorite_product ufp) throws SQLException{
        Boolean flag = false;
        Connection conn = null;
        Statement st = null;
        try {
            conn = super.getConn();
            st = conn.createStatement();
            String sql = "insert into user_favorite_product values("+
                    "\'"+ufp.getKey().getUserid()+"\',"+
                    "\'"+ufp.getKey().getProductid()+"\'"+
                    ")";
            st.executeUpdate(sql);
            flag = true;
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeConn(conn,st);
            return flag;
        }
    }

    public Boolean delete(upPrimaryKey up) throws SQLException{
        Boolean flag = false;
        Connection conn = null;
        Statement st = null;
        try {
            conn= super.getConn();
            st = conn.createStatement();
            String sql = "delete from user_favorite_product "+
                    "where userid="+up.getUserid()+" and pid="+up.getProductid();
            st.executeUpdate(sql);
            System.out.println("删除执行成功");
            flag = true;
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeConn(conn,st);
            return flag;
        }
    }

    public user_favorite_product get(upPrimaryKey up) throws SQLException{
        user_favorite_product umpt = new user_favorite_product();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn= super.getConn();
            st = conn.createStatement();
            String sql = "select * from user_favorite_product where userid="
                    +up.getUserid()+" and pid="
                    +up.getProductid();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                umpt.setKey(up);
            }

        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeConn(conn,st,rs);
            return  umpt;
        }
    }

    /*
     * UID和pid没有填null
     * pnum没有填-1
     */
    public List<user_favorite_product> search(String uid, String pid) throws SQLException{
        if(uid==null&&pid==null){
            return null;
        }
        List<user_favorite_product> list = new ArrayList<user_favorite_product>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn= super.getConn();
            st = conn.createStatement();
            String sql = "select * from user_favorite_product where ";
            String and = " and ";
            if(uid!=null){
                sql = sql + "userid="+uid+and;
            }
            if(pid!=null){
                sql = sql + "pid="+pid+and;
            }
            sql = sql.substring(0,sql.length()-and.length());
            System.out.println(sql);
            rs = st.executeQuery(sql);
            while(rs.next()) {
                user_favorite_product umpt = new user_favorite_product();
                upPrimaryKey up = new upPrimaryKey();
                up.setUserid(rs.getString("userid"));
                up.setProductid(rs.getString("pid"));
                umpt.setKey(up);
                list.add(umpt);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeConn(conn,st,rs);
            if(list.size()>0) return  list;
            else return null;
        }
    }
}
