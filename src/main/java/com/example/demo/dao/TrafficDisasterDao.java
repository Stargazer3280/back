package com.example.demo.dao;

import com.example.demo.entity.MissingStatistics;
import com.example.demo.entity.TrafficDisaster;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface TrafficDisasterDao {
    @Select("select * from traffic_disaster")
    List<TrafficDisaster> getAll();

    @Insert("insert into traffic_disaster(id,date,location,type,grade,picture,note,reporting_unit) values(#{id},#{date},#{location},#{type},#{grade},#{picture},#{note},#{reportingUnit})")
    void insert(TrafficDisaster trafficDisaster);

    @Delete("delete from traffic_disaster where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update traffic_disaster set id=#{id},date=#{date},location=#{location},type=#{type},grade=#{grade},picture=#{picture},note=#{note},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(TrafficDisaster trafficDisaster);

    @Select("select * from traffic_disaster where no=#{no}")
    TrafficDisaster getByNo(@Param("no") Integer no);
}
