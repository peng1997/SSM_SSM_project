import com.itheima.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class test1 {

    @Test
    public void abc() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //System.out.println(applicationContext);
        IProductDao iProductDao = applicationContext.getBean("IProductDao", IProductDao.class);
        System.out.println(iProductDao);
        List<Product> all = iProductDao.findAll();
        System.out.println(all);
    }

}
