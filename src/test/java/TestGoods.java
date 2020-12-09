
import com.sk.mall2.Mall2Application;
import com.sk.mall2.entity.Goods;


import com.sk.mall2.service.GoodsService;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Mall2Application.class)
public class TestGoods {

    @Autowired
    private GoodsService goodsService;


    @Test
    public void printhotGoods(){
        List<Goods> goods = goodsService.getHotGoods();
        for(Goods good: goods){
            System.out.println(good.getGoodsName());
        }
    }

}
