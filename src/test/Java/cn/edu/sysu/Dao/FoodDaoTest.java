package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Food;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:spring/spring-dao.xml"})
public class FoodDaoTest {

    @Resource
    private FoodDao foodDao;

    @Test
    public void addFood() {
        Food food = new Food();
        food.setFname("测试食物");
        food.setPrice(10.00);
        food.setStock(50);
        foodDao.addFood(food);
    }

    @Test
    public void deleteFood() {
        foodDao.deleteFood("测试食物");
    }

    @Test
    public void increaseStock() {
        assert (foodDao.increaseStock("测试食物", 5) == 1);
    }

    @Test
    public void reduceStock() {
        assert (foodDao.reduceStock("测试食物", 10) == 1);
    }

    @Test
    public void changePrice() {
        assert (foodDao.changePrice("测试食物", 45) == 1);
    }

    @Test
    public void queryAllFood() {
        List<Food> foods = foodDao.queryAllFood();
        foods.forEach(System.out::println);
    }

    @Test
    public void queryFoodById() {
        Food food = foodDao.queryFoodById(100);
        System.out.println(food.toString());
    }

    @Test
    public void queryFoodByFName() {
        Food food = foodDao.queryFoodByFName("测试食物");
        System.out.println(food.toString());
    }
}