package po;

public class ProductType {

    private int produtTypeId;
    private String typeName;

    public ProductType(){}

    public ProductType(int produtTypeId, String typeName) {
        this.produtTypeId = produtTypeId;
        this.typeName = typeName;
    }

    public int getProdutTypeId() {
        return produtTypeId;
    }

    public void setProdutTypeId(int produtTypeId) {
        this.produtTypeId = produtTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
