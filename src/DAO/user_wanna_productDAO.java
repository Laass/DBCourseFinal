package DAO;

import po.user_wanna_product;
import po.upPrimaryKey;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class user_wanna_productDAO extends DAOBase implements DAOBaseOperate<Object>{

    public Boolean insert(Object o) throws SQLException{ return false;}
    public Boolean delete(Object o) throws SQLException{ return false;}
    public Boolean update(Object o) throws SQLException{ return false;}
    public Object get(Object o) throws SQLException{ return null;}

    public Boolean insert(user_wanna_product uwp) throws SQLException{
        Boolean flag = false;
        Connection conn = null;
        Statement st = null;
        try {
            conn = super.getConn();
            st = conn.createStatement();
            String sql = "insert into user_wanna_product values("+
                    "\'"+uwp.getKey().getUserid()+"\',"+
                    "\'"+uwp.getKey().getProductid()+"\',"+
                    "\'"+uwp.getProNum()+"\'"+
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
            String sql = "delete from user_wanna_product "+
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

    public Boolean update(user_wanna_product uwp) throws Exception{
        Boolean flag = false;
        Connection conn = null;
        Statement st = null;
        try {
            conn = super.getConn();
            st = conn.createStatement();
            String sql = "update user_wanna_product set "+
                    "proNum="+uwp.getProNum()+
                    " where userid="+uwp.getKey().getUserid()+" and pid="+uwp.getKey().getProductid();
            st.executeUpdate(sql);
            System.out.println("更新执行成功");
            flag = true;
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            super.closeConn(conn,st);
            return flag;
        }
    }

    public user_wanna_product get(upPrimaryKey up) throws SQLException{
        user_wanna_product umpt = new user_wanna_product();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn= super.getConn();
            st = conn.createStatement();
            String sql = "select * from user_wanna_product where userid="
                    +up.getUserid()+" and pid="
                    +up.getProductid();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                umpt.setKey(up);
                umpt.setProNum(rs.getInt("proNum"));
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
    public List<user_wanna_product> search(String uid, String pid, int pnum) throws SQLException{
        if(uid==null&&pid==null&&pnum<0){
            return null;
        }
        List<user_wanna_product> list = new ArrayList<user_wanna_product>();
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn= super.getConn();
            st = conn.createStatement();
            String sql = "select * from user_wanna_product where ";
            String and = " and ";
            if(uid!=null){
                sql = sql + "userid="+uid+and;
            }
            if(pid!=null){
                sql = sql + "pid="+pid+and;
            }
            if(pnum>=0){
                sql = sql + "proNum="+pnum+and;
            }
            sql = sql.substring(0,sql.length()-and.length());
            System.out.println(sql);
            rs = st.executeQuery(sql);
            while(rs.next()) {
                user_wanna_product umpt = new user_wanna_product();
                upPrimaryKey up = new upPrimaryKey();
                up.setUserid(rs.getString("userid"));
                up.setProductid(rs.getString("pid"));
                umpt.setKey(up);
                umpt.setProNum(rs.getInt("proNum"));
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
