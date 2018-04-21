package cn.edu.sysu.Service;

import cn.edu.sysu.Entity.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml","classpath*:spring/spring-service.xml"})
public class FoodServiceTest {

    @Resource
    private FoodService foodService;

    @Test
    public void addFood() {
        Food food = new Food();
        food.setFname("炸鸡");
        food.setPrice(10.00);
        food.setStock(50);
        assert (foodService.addFood(food).equals("添加成功"));
    }

    @Test
    public void deleteFood() {
        String fname = "炸鸡";
        assert (foodService.deleteFood(fname).equals("删除成功"));
    }

    @Test
    public void increaseStock() {
        String fname = "炸鸡";
        int number = 1;
        assert (foodService.increaseStock(fname,number).equals("增加库存成功"));
    }

    @Test
    public void reduceStock() {
        String fname = "炸鸡";
        int number = 1;
        assert (foodService.reduceStock(fname,number).equals("减少库存成功"));
    }

    @Test
    public void changePrice() {
        String fname = "炸鸡";
        int newPrice = 1;
        assert (foodService.changePrice(fname,newPrice).equals("更改价格成功"));
    }

    @Test
    public void queryAllFood() {
        List<Food> foods = foodService.queryAllFood();
        foods.forEach(System.out::println);
    }

    @Test
    public void queryFoodByFName() {
        Food food = foodService.queryFoodByFName("炸鸡");
        System.out.println(food.toString());
    }
}
