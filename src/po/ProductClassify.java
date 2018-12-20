package po;

import DAO.DAOBase;
import DAO.DAOBaseOperate;

public class ProductClassify {

    private String productTypeid;
    private String pid;
    private String path;

    public ProductClassify(){}

    public ProductClassify(String productTypeid, String pid, String path) {
        this.productTypeid = productTypeid;
        this.pid = pid;
        this.path = path;
    }

    public String getProductTypeid() {
        return productTypeid;
    }

    public void setProductTypeid(String productTypeid) {
        this.productTypeid = productTypeid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
