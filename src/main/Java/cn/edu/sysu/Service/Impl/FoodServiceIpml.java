package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.FoodDao;
import cn.edu.sysu.Entity.Food;
import cn.edu.sysu.Service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service.Impl
 * Created by lijinzhu on 2018/4/17
 * Description: 实现有关FoodService的业务层接口
 */
@Service
public class FoodServiceIpml implements FoodService {

    @Autowired
    private FoodDao foodDao;

    @Override
    public String addFood(Food food) {
        foodDao.addFood(food);
        return "添加成功";
    }

    @Override
    public String deleteFood(String fname) {
        foodDao.deleteFood(fname);
        return "删除成功";
    }

    @Override
    public String increaseStock(String fname, int number) {
        foodDao.increaseStock(fname,number);
        return "增加库存成功";
    }

    @Override
    public String reduceStock(String fname, int number) {
        foodDao.reduceStock(fname,number);
        return "减少库存成功";
    }

    @Override
    public String changePrice(String fname, int newPrice) {
        foodDao.changePrice(fname,newPrice);
        return "更改价格成功";
    }

    @Override
    public List<Food> queryAllFood() {
        return foodDao.queryAllFood();
    }

    @Override
    public Food queryFoodByFName(String fname) {
        return foodDao.queryFoodByFName(fname);
    }
}
