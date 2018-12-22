package test.DAO; 

import DAO.ProductDAO;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import po.Product;


/** 
* ProductDAO Tester. 
* 
* @author <Authors name> 
* @since <pre>ʮ���� 21, 2018</pre> 
* @version 1.0 
*/ 
public class ProductDAOTest { 

    Boolean excepted = true;
    Product inputProduct = null;


    @Before
    public void before() throws Exception {
        System.out.println("productDAO Junit测试开始：");
    }

    @After
    public void after() throws Exception {
        System.out.println("productDAO Junit测试结束：");
    }

    /**
    *
    * Method: insert(Product o)
    *
    */
    @Test
    public void testInsert() throws Exception {
    //TODO: Test goes here...
        Product pro = new Product(22, "2018女装毛衣", "详情介绍", "e:/", null, "1");
        assert (new ProductDAO().insert(pro));
    }

    /**
    *
    * Method: delete(Product o)
    *
    */
    @Test
    public void testDelete() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: update(Product o)
    *
    */
    @Test
    public void testUpdate() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: get(Product o)
    *
    */
    @Test
    public void testGetO() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: get(String pid)
    *
    */
    @Test
    public void testGetPid() throws Exception {
    //TODO: Test goes here...
    }

    /**
    *
    * Method: findProductByType(String Type)
    *
    */
    @Test
    public void testFindProductByType() throws Exception {
    //TODO: Test goes here...
    }


    /**
    *
    * Method: deleteProduct(String pid)
    *
    */
    @Test
    public void testDeleteProduct() throws Exception {
    //TODO: Test goes here...
    /*
    try {
       Method method = ProductDAO.getClass().getMethod("deleteProduct", String.class);
       method.setAccessible(true);
       method.invoke(<Object>, <Parameters>);
    } catch(NoSuchMethodException e) {
    } catch(IllegalAccessException e) {
    } catch(InvocationTargetException e) {
    }
    */
    }

} 
