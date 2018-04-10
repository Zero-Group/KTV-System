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
        food.setFname("炸鸡");
        food.setPrice(10.00);
        food.setStock(50);
        foodDao.addFood(food);
    }

    @Test
    public void deleteFood() {
        foodDao.deleteFood("炸鸡");
    }

    @Test
    public void increaseStock() {
        assert (foodDao.increaseStock("炸鸡",5) == 1);
    }

    @Test
    public void reduceStock() {
        assert (foodDao.reduceStock("炸鸡", 5) == 1);
    }

    @Test
    public void queryAllFood() {
        List<Food> foods = foodDao.queryAllFood();
        foods.forEach(System.out::println);
    }

    @Test
    public void queryFoodByFName() {
        Food food = foodDao.queryFoodByFName("炸鸡");
        System.out.println(food.toString());
    }
}