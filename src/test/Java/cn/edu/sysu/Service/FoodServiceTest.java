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
    public void test() {
        addFood();
        increaseStock();
        reduceStock();
        changePrice();
        queryAllFood();
        queryFoodById();
        queryFoodByFName();
        deleteFood();
    }

    private void addFood() {
        Food food = new Food();
        food.setFname("炸鸡");
        food.setPrice(10.00);
        food.setStock(50);
        assert (foodService.addFood(food)
                .getMessage().equals("新增食物成功！"));
    }

    private void deleteFood() {
        assert (foodService.deleteFood("炸鸡")
                .getMessage().equals("删除食物成功！"));
    }

    private void increaseStock() {
        assert (foodService.increaseStock("炸鸡", 5)
                .getMessage().equals("增加食物库存成功！"));
    }

    private void reduceStock() {
        assert (foodService.reduceStock("炸鸡", 10)
                .getMessage().equals("减少食物库存成功！"));
    }

    private void changePrice() {
        assert (foodService.changePrice("炸鸡", 12)
                .getMessage().equals("修改食物价格成功！"));
    }

    private void queryAllFood() {
        List<Food> foods = foodService.queryAllFood();
        foods.forEach(System.out::println);
    }

    private void queryFoodById() {
        Food food = foodService.queryFoodById(100);
        System.out.println(food.toString());
    }

    private void queryFoodByFName() {
        Food food = foodService.queryFoodByFName("炸鸡");
        System.out.println(food.toString());
    }
}
