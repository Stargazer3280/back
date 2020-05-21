package com.example.demo.dao;

import com.example.demo.entity.CommDisaster;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CommDisasterDao {
    @Select("select * from comm_disaster")
    List<CommDisaster> getAll();

    @Insert("insert into comm_disaster(id,date,location,type,grade,picture,note,reporting_unit) values(#{id},#{date},#{location},#{type},#{grade},#{picture},#{note},#{reportingUnit})")
    void insert(CommDisaster commDisaster);

    @Delete("delete from comm_disaster where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update comm_disaster set id=#{id},date=#{date},location=#{location},type=#{type},grade=#{grade},picture=#{picture},note=#{note},reporting_unit=#{reportingUnit}")
    void update(CommDisaster commDisaster);

    @Select("select * from comm_disaster where no=#{no}")
    CommDisaster getByNo(@Param("no") Integer no);
}
