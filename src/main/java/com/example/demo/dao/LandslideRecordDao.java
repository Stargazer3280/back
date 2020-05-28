package com.example.demo.dao;

import com.example.demo.entity.LandslideRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LandslideRecordDao {
    @Select("select * from landslide_record")
    List<LandslideRecord> getAll();

    @Insert("insert into landslide_record(id,location,date,type,status,note,picture,reporting_unit) values(#{id},#{location},#{date},#{type},#{status},#{note},#{picture},#{reportingUnit})")
    void insert(LandslideRecord landslideRecord);

    @Delete("delete from landslide_record where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update landslide_record set id=#{id},location=#{location},date=#{date},type=#{type},status=#{status},note=#{note},picture=#{picture},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(LandslideRecord landslideRecord);

    @Select("select * from landslide_record where no=#{no}")
    LandslideRecord getByNo(@Param("no") Integer no);
}
