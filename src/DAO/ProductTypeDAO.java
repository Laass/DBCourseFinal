package DAO;

import po.ProductType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductTypeDAO extends DAOBase implements DAOBaseOperate<ProductType> {

    @Override
    public Boolean insert(ProductType o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        int flag = 0;

        try {
            String sql = "insert into producttype_classify (productTypeid,typeName) values(?,?)";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, o.getProdutTypeId());
            pst.setString(2, o.getTypeName());

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
    public Boolean delete(ProductType o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        int flag = 0;

        try {
            String sql = "delete from producttype_classify where productTypeid = ?";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, o.getProdutTypeId());

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
    public Boolean update(ProductType o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        int flag = 0;

        try {
            String sql = "update producttype_classify set typeName = ? where productTypeid = ?";
            pst = conn.prepareStatement(sql);

            pst.setString(1, o.getTypeName());
            pst.setInt(2, o.getProdutTypeId());

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
    public ProductType get(ProductType o) throws SQLException {
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        ResultSet rset = null;
        String sql = null;
        ProductType pt = null;

        try {
            if(o.getTypeName() == null) {
                sql = "select * from producttype_classify where productTypeid = ?";
                pst.setInt(1, o.getProdutTypeId());
            }
            else if(o.getTypeName() != null){
                sql = "select * from producttype_classify where typeName = ?";
                pst.setString(1, o.getTypeName());
            }
            pst = conn.prepareStatement(sql);
            rset = pst.executeQuery();

            if(rset.next())
                pt = new ProductType(rset.getInt(1), rset.getString(2));

        }catch (Exception e){
            e.printStackTrace();
        }

        super.closeConn(conn, pst, rset);

        return pt;
    }

}
