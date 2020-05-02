package com.zql.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zql.mybatisplus.entity.ResourceLock;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author lawliet.L
 */
public interface MysqlLockMapper extends BaseMapper<ResourceLock> {

    /**
     * 阻塞的根据资源名称获取资源的锁信息
     * 在查询语句后面增加 for update,mysql就会为这个查询加一个排它锁
     * 注意：加的排它锁都是行锁
     * 但是InnoDB引擎在加锁的时候，如果查询条件中没有使用索引，就会变成表锁
     * @param resourceName 资源名
     * @return 锁信息实体
     */
    @Select("select * from t_resource_lock l where l.resource_name = #{resourceName} for update")
    ResourceLock getBlockLockInfo(@Param("resourceName") String resourceName);

    /**
     * 重入次数加1
     * @param resourceName 资源名
     * @return 更新行数
     */
    @Update("update t_resource_lock l set l.count = l.count + 1 where l.resource_name = #{resourceName}")
    int addLockCount(@Param("resourceName") String resourceName);
}
