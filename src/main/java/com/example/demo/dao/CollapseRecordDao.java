package com.example.demo.dao;

import com.example.demo.entity.CollapseRecord;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CollapseRecordDao {
    @Select("select * from collapse_record")
    List<CollapseRecord> getAll();

    @Insert("insert into collapse_record(id,location,date,type,status,note,picture,reporting_unit) values(#{id},#{location},#{date},#{type},#{status},#{note},#{picture},#{reportingUnit})")
    void insert(CollapseRecord collapseRecord);

    @Delete("delete from collapse_record where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update collapse_record set id=#{id},location=#{location},date=#{date},type=#{type},status=#{status},note=#{note},picture=#{picture},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(CollapseRecord collapseRecord);

    @Select("select * from collapse_record where no=#{no}")
    CollapseRecord getByNo(@Param("no") Integer no);
}
