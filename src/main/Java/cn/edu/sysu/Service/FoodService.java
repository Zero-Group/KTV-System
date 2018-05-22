package cn.edu.sysu.Service;

import cn.edu.sysu.Dto.OperationStatus;
import cn.edu.sysu.Entity.Food;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Service
 * Created by lihan on 2018/4/14
 * Description: Food的业务层接口，提供
 * 对Food的增加、删除、修改以及查询等方法。
 */
public interface FoodService {

    /**
     * 向系统中添加食物
     *
     * @param food 将要被添加的食物
     * @return 返回添加食物的结果
     */
    OperationStatus addFood(Food food);

    /**
     * 删除系统中的食物
     *
     * @param fname 将要删除的食物名称
     * @return 返回删除食物的结果
     */
    OperationStatus deleteFood(String fname);

    /**
     * 商家增加系统中的食物的库存数量
     *
     * @param fname  食物名称
     * @param number 食物数量
     * @return 返回添加库存数量的结果
     */
    OperationStatus increaseStock(String fname, int number);

    /**
     * 消费时减少系统中的食物的库存数量
     *
     * @param fname  食物名称
     * @param number 食物数量
     * @return 返回减少库存数量的结果
     */
    OperationStatus reduceStock(String fname, int number);

    /**
     * 商家修改食物的价格
     *
     * @param fname    食物名称
     * @param newPrice 新的价格
     * @return 返回修改价格的结果
     */
    OperationStatus changePrice(String fname, int newPrice);

    /**
     * 查询所有食物的价格、库存量等信息
     *
     * @return 系统中所有食物的列表
     */
    List<Food> queryAllFood();

    /**
     * 根据给定的食物编号查询食物信息
     *
     * @param id 食物编号
     * @return 返回该食物
     */
    Food queryFoodById(int id);

    /**
     * 根据给定的食物名称查询食物信息
     *
     * @param fname 食物名称
     * @return 返回该食物
     */
    Food queryFoodByFName(String fname);

}
