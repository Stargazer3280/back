package com.example.demo.dao;

import com.example.demo.entity.DeathStatistics;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeathStatisticsDao {
    @Select("select * from death_statistics")
    List<DeathStatistics> getAll();

    @Insert("insert into death_statistics(id,location,date,number,reporting_unit) values(#{id},#{location},#{date},#{number},#{reportingUnit})")
    void insert(DeathStatistics deathStatistics);
}
