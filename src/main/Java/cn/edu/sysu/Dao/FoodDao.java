package cn.edu.sysu.Dao;

import cn.edu.sysu.Entity.Food;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Project name: KTV-System
 * Package name: cn.edu.sysu.Dao
 * Created by lihan on 2018/4/6
 * Description: Food的数据访问层接口，
 * 提供向数据库中添加、删除Food、修改
 * 库存量、价格以及查询的方法。
 */
public interface FoodDao {

    /**
     * 向数据库中添加食物
     *
     * @param food 将要被添加的食物
     */
    void addFood(Food food);

    /**
     * 删除数据库中的食物
     *
     * @param fname 将要删除的食物名称
     */
    void deleteFood(String fname);

    /**
     * 增加数据库中的食物的库存数量
     *
     * @param fname  食物名称
     * @param number 食物数量
     * @return 修改数据库的行数
     */
    int increaseStock(@Param("fname") String fname, @Param("number") int number);

    /**
     * 减少数据库中的食物的库存数量
     *
     * @param fname  食物名称
     * @param number 食物数量
     * @return 修改数据库的行数
     */
    int reduceStock(@Param("fname") String fname, @Param("number") int number);

    /**
     * 根据给定的食物名称修改食物的价格
     *
     * @param fname    食物名称
     * @param newPrice 新的价格
     * @return 修改数据库的行数
     */
    int changePrice(@Param("fname") String fname, @Param("price") double newPrice);

    /**
     * 查询所有食物的价格、库存量等信息
     *
     * @return 数据库中所有食物的列表
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
