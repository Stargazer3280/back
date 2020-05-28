package com.example.demo.dao;

import com.example.demo.entity.DisasterInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DisasterInfoDao {
    @Select("select * from disaster_info")
    List<DisasterInfo> getAll();

    @Insert("insert into disaster_info(id,date,location,longitude,latitude,depth,magnitude,picture,reporting_unit) values(#{id},#{date},#{location},#{longitude},#{latitude},#{depth},#{magnitude},#{picture},#{reportingUnit})")
    void insert(DisasterInfo disasterInfo);

    @Delete("delete from disaster_info where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update disaster_info set id=#{id},date=#{date},location=#{location},longitude=#{longitude},latitude=#{latitude},depth=#{depth},magnitude=#{magnitude},picture=#{picture},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(DisasterInfo disasterInfo);

    @Select("select * from disaster_info where no=#{no}")
    DisasterInfo getByNo(@Param("no") Integer no);
}
