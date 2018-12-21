package po;

import java.math.BigInteger;

public class TypeTree {

    private TypeTree next = null;
    private TypeTree[] fa = new TypeTree[50];
    private int fanum = 0;
    private int rangepre = 0;
    private int rangenex = 0;
    private int typeIndex;

    public Boolean hasNext(){
        if(next == null)
            return false;
        return true;
    }

    public TypeTree next(){
        return next;
    }

    public TypeTree getNext() {
        return next;
    }

    public void setNext(TypeTree next) {
        this.next = next;
    }

    public int getRangepre() {
        return rangepre;
    }

    public void setRangepre(int rangepre) {
        this.rangepre = rangepre;
    }

    public int getRangenex() {
        return rangenex;
    }

    public void setRangenex(int rangenex) {
        this.rangenex = rangenex;
    }

    public TypeTree[] getFa() {
        return fa;
    }

    public void setFa(TypeTree[] fa) {
        this.fa = fa;
    }

    public int getFanum() {
        return fanum;
    }

    public void setFanum(int fanum) {
        this.fanum = fanum;
    }

    public int getTypeIndex() {
        return typeIndex;
    }

    public void setTypeIndex(int typeIndex) {
        this.typeIndex = typeIndex;
    }

    public TypeTree createTree(int per, int total, String sta){
//        int total = 4;
//        int per = 2;

        int layer = total / per;
        int pre = 1;
        int nex = 1;
        String b_next = "";
        for(int j =1 ; j < layer; ++j){
            b_next += repeatCreate("0", per);
        }

        String fa_s = repeatCreate("1", per);

        for(int i = 0; i < Integer.parseInt(new BigInteger(fa_s, 2).toString()); ++i){

            if(layer == 1)
                return null;

            String b_pre = Integer.toBinaryString(pre);

            String s = sta + b_pre + b_next;
            fa[fanum] = new TypeTree();
            fa[fanum].setTypeIndex(Integer.parseInt(new BigInteger(s, 2).toString()));
            fa[fanum].setRangepre(fa[fanum].getTypeIndex() + 1);
            b_pre = Integer.toBinaryString(pre+1);
            s = sta + b_pre + b_next;
            fa[fanum].setRangenex(Integer.parseInt(new BigInteger(s,2).toString()) - 1);

            fa[fanum].setNext(new TypeTree().createTree(per, total - per, Integer.toBinaryString(pre)));

            ++pre;
            ++fanum;
        }

        fa[fanum] = null;

        return this;
    }

    public String repeatCreate(String r, int n){
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < n; ++i){
            str.append(r);
        }
        return str.toString();
    }

    public TypeTree getRange(int id){
        for(int i = 0; i < fanum; ++i){
            if(fa[i].getTypeIndex() == id)
                return fa[i];
            if(id > fa[i].getRangepre() && id < fa[i].getRangenex()) {
                TypeTree temp = fa[i].getRange(id);
                if(temp != null)
                    return temp;
            }
        }
        return null;
    }

}
