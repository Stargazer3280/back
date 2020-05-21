package com.example.demo.dao;

import com.example.demo.entity.DeathStatistics;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeathStatisticsDao {
    @Select("select * from death_statistics")
    List<DeathStatistics> getAll();

    @Insert("insert into death_statistics(id,location,date,number,reporting_unit) values(#{id},#{location},#{date},#{number},#{reportingUnit})")
    void insert(DeathStatistics deathStatistics);

    @Delete("delete from death_statistics where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update death_statistics set id=#{id},location=#{location},date=#{date},number=#{number},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(DeathStatistics deathStatistics);

    @Select("select * from death_statistics where no=#{no}")
    DeathStatistics getByNo(@Param("no") Integer no);
}
