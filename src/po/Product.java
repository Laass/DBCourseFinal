package po;

public class Product {

    private String pid;//产品id
    private float price;//产品价格
    private String productType;//产品种类
    private String title;//产品名
    private String type;//产品规格（例如：水壶的500ml、250ml）

    public Product(){}

    public Product(String pid, float price, String productType, String title, String type, String imagePath) {
        this.pid = pid;
        this.price = price;
        this.productType = productType;
        this.title = title;
        this.type = type;
        this.imagePath = imagePath;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    private String imagePath;

}
