package DAO;

import po.ProductType;
import po.TypeTree;

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
            String sql = "insert into producttype (productTypeid,typeName) values(?,?)";
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

    public Boolean insertChildrenType(int parentProductTypeId,ProductType o) throws SQLException {

        TypeTree tt = new TypeTree();
        Connection conn = super.getConn();
        PreparedStatement pst = null;
        ResultSet rset = null;
        Boolean flag = true;

        //获取类别树
        tt.createTree(tt, 2,4,"");
        //判断该类别是否有子类别
        if(tt.getRange(parentProductTypeId).getRangenex() == 0)
            return false;

        //获得该父类别的区域范围
        tt = tt.getRange(parentProductTypeId);

        try {
            //获取当前类别浮标
            String sql = "select * from producttype where productTypeid >= ? AND productTypeid <= ? order by productTypeid desc limit 0,1 ";
            pst = conn.prepareStatement(sql);

            pst.setInt(1, tt.getRangepre());
            pst.setInt(2, tt.getRangenex());

            rset = pst.executeQuery();

            int i = 0;

            //判断当前类别区域是否还有空位
            if(rset.next())
                i = rset.getInt(1);
            if(i == tt.getRangenex())
                flag = false;
            else{
                //插入新的子类别
                insert(new ProductType(i+1, o.getTypeName()));
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        super.closeConn(conn,pst);


        return flag;
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
                sql = "select * from producttype where productTypeid = ?";
                pst = conn.prepareStatement(sql);
                pst.setInt(1, o.getProdutTypeId());
            }
            else if(o.getTypeName() != null){
                sql = "select * from producttype where typeName = ?";
                pst = conn.prepareStatement(sql);
                pst.setString(1, o.getTypeName());
            }

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
