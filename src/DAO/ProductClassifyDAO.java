package DAO;

import po.ProductClassify;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ProductClassifyDAO extends DAOBase implements DAOBaseOperate <ProductClassify>{

    @Override
    public Boolean insert(ProductClassify o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        int flag = 0;

        try {
            String sql = "insert into producttype_classify (productTypeid,pid,path) values(?,?,?)";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, o.getProductTypeid());
            pst.setString(2, o.getPid());
            pst.setString(3, o.getPath());

            flag = pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

        super.closeConn(conn,pst);

        if(flag == 0)
            return false;
        else
            return true;
    }

    @Override
    public Boolean delete(ProductClassify o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        int flag = 0;;

        try {
            String sql;

            sql = "delete from producttype_classify where productTypeid = ? AND pid = ?";
            pst = conn.prepareStatement(sql);
            pst.setInt(1, o.getProductTypeid());
            pst.setString(2, o.getPid());

            flag = pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

        super.closeConn(conn,pst);

        if(flag == 0)
            return false;
        else
            return true;
    }

    @Override
    public Boolean update(ProductClassify o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        int flag = 0;

        try {
            String sql = "update producttype_classify set path = ?";

            if(o.getPath() != null)

            pst = conn.prepareStatement(sql);

            pst.setString(1, o.getPath());

            flag = pst.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }

        super.closeConn(conn,pst);

        if(flag == 0)
            return false;
        else
            return true;
    }

    @Override
    public ProductClassify get(ProductClassify o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        ProductClassify pc = null;
        ResultSet rset = null;
        String sql = null;

        try {
            if(o.getPid() != null && o.getProductTypeid() != 0)
                sql = "select * from producttype_classify where productTypeid = '"+o.getProductTypeid()+"' AND pid = '"+o.getPid()+"'";
            else if (o.getPid() != null)
                sql = "select * from producttype_classify where productTypeid = '"+o.getProductTypeid()+"'";
            else if (o.getProductTypeid() != 0)
                sql = "select * from producttype_classify where pid = '"+o.getPid()+"'";

            pst = conn.prepareStatement(sql);
            rset = pst.executeQuery();

            if(rset.next())
                pc = new ProductClassify(rset.getInt(1),rset.getString(2),rset.getString(3));
        }catch (Exception e){
            e.printStackTrace();
        }

        super.closeConn(conn, pst, rset);
        return pc;
    }

    public List<ProductClassify> findProductByType(int type) throws SQLException{
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        ProductClassify pc = null;
        ResultSet rset = null;
        List<ProductClassify> list = new ArrayList<ProductClassify>();

        try {
            String sql = "select * from producttype_classify where productTypeid = ?";

            pst = conn.prepareStatement(sql);
            pst.setInt(1, type);
            rset = pst.executeQuery();

            while(rset.next()) {
                list.add(new ProductClassify(rset.getInt(1),rset.getString(2),rset.getString(3)));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        super.closeConn(conn, pst, rset);
        return list;
    }

}
