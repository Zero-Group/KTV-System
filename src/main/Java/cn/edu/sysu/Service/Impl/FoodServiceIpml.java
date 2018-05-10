package cn.edu.sysu.Service.Impl;

import cn.edu.sysu.Dao.FoodDao;
import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Food;
import cn.edu.sysu.Exception.FoodException;
import cn.edu.sysu.Exception.KTVException;
import cn.edu.sysu.Service.FoodService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service.Impl
 * Created by lijinzhu on 2018/4/17
 * Description: 实现有关FoodService的业务层接口
 */
@Service
public class FoodServiceIpml implements FoodService {

    //日志对象
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private FoodDao foodDao;

    @Override
    @Transactional
    public OperationStatus addFood(Food food) throws KTVException {
        try {
            if (foodDao.queryFoodByFName(food.getFname()) != null) {
                throw new FoodException("该食物已存在！");
            }
            foodDao.addFood(food);
            return new OperationStatus("新增食物成功！");
        } catch (FoodException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus deleteFood(String fname) throws KTVException {
        try {
            if (foodDao.queryFoodByFName(fname) == null) {
                throw new FoodException("该食物不存在！");
            }
            foodDao.deleteFood(fname);
            return new OperationStatus("删除食物成功！");
        } catch (FoodException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus increaseStock(String fname, int number) throws KTVException {
        try {
            if (foodDao.queryFoodByFName(fname) == null) {
                throw new FoodException("该食物不存在！");
            }
            foodDao.increaseStock(fname,number);
            return new OperationStatus("增加食物库存成功！");
        } catch (FoodException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus reduceStock(String fname, int number) throws KTVException {
        try {
            if (foodDao.queryFoodByFName(fname) == null) {
                throw new FoodException("该食物不存在！");
            }
            if (foodDao.queryFoodByFName(fname).getStock() < number) {
                throw new FoodException("该食物库存不足！");
            }
            foodDao.reduceStock(fname,number);
            return new OperationStatus("减少食物库存成功！");
        } catch (FoodException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
    }

    @Override
    @Transactional
    public OperationStatus changePrice(String fname, int newPrice) throws KTVException {
        try {
            if (foodDao.queryFoodByFName(fname) == null) {
                throw new FoodException("该食物不存在！");
            }
            if (newPrice <= 0) {
                throw new FoodException("价格不合法！");
            }
            foodDao.changePrice(fname, newPrice);
            return new OperationStatus("修改食物价格成功！");
        } catch (FoodException e1) {
            throw e1;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new KTVException("Inner error:" + e.getMessage());
        }
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
