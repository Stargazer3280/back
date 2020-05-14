package com.example.demo.dao;

import com.example.demo.entity.CommDisaster;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommDisasterDao {
    @Select("select * from comm_disaster")
    List<CommDisaster> getAll();

    @Insert("insert into comm_disaster(id,date,location,type,grade,picture,note,reporting_unit) values(#{id},#{date},#{location},#{type},#{grade},#{picture},#{note},#{reportingUnit})")
    void insert(CommDisaster commDisaster);
}
