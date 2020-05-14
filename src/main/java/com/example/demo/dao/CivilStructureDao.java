package com.example.demo.dao;

import com.example.demo.entity.CivilStructure;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CivilStructureDao {
    @Select("select * from civil_structure")
    List<CivilStructure> getAll();

    @Insert("insert into civil_structure(id,date,location,basically_intact_square,damaged_square,destroyed_square,note,reporting_unit) values(#{id},#{date},#{location},#{basicallyIntactSquare},#{damagedSquare},#{destroyedSquare},#{note},#{reportingUnit})")
    void insert(CivilStructure civilStructure);
}
