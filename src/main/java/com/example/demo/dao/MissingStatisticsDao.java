package com.example.demo.dao;

import com.example.demo.entity.MissingStatistics;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MissingStatisticsDao {
    @Select("select * from missing_statistics")
    List<MissingStatistics> getAll();

    @Insert("insert into missing_statistics(id,location,date,number,reporting_unit) values(#{id},#{location},#{date},#{number},#{reportingUnit})")
    void insert(MissingStatistics missingStatistics);

    @Delete("delete from missing_statistics where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update missing_statistics set id=#{id},location=#{location},date=#{date},number=#{number},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(MissingStatistics missingStatistics);

    @Select("select * from missing_statistics where no=#{no}")
    MissingStatistics getByNo(@Param("no") Integer no);
}
