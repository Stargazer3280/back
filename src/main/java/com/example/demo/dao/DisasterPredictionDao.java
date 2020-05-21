package com.example.demo.dao;

import com.example.demo.entity.DisasterPrediction;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DisasterPredictionDao {
    @Select("select * from disaster_prediction")
    List<DisasterPrediction> getAll();

    @Insert("insert into disaster_prediction(id,date,location,longitude,latitude,depth,magnitude,intensity,type,picture,note,reporting_unit) values(#{id},#{date},#{location},#{longitude},#{latitude},#{depth},#{magnitude},#{intensity},#{type},#{picture},#{note},#{reportingUnit})")
    void insert(DisasterPrediction disasterPrediction);

    @Delete("delete from disaster_prediction where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update disaster_prediction set id=#{id},date=#{date},location=#{location},longitude=#{longitude},latitude=#{latitude},depth=#{depth},magnitude=#{magnitude},intensity=#{intensity},type=#{type},picture=#{picture},note=#{note},reporting_unit=#{reportingUnit}")
    void update(DisasterPrediction disasterPrediction);

    @Select("select * from disaster_prediction where no=#{no}")
    DisasterPrediction getByNo(@Param("no") Integer no);
}
