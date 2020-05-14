package com.example.demo.dao;

import com.example.demo.entity.CollapseRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CollapseRecordDao {
    @Select("select * from collapse_record")
    List<CollapseRecord> getAll();

    @Insert("insert into collapse_record(id,location,date,type,status,note,picture,reporting_unit) values(#{id},#{location},#{date},#{type},#{status},#{note},#{picture},#{reportingUnit})")
    void insert(CollapseRecord collapseRecord);
}
