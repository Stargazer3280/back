package com.example.demo.dao;

import com.example.demo.entity.CivilStructure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CivilStructureDao {
    @Select("select * from civil_structure")
    List<CivilStructure> getAll();

    @Insert("insert into civil_structure(id,date,location,basically_intact_square,damaged_square,destroyed_square,note,reporting_unit) values(#{id},#{date},#{location},#{basicallyIntactSquare},#{damagedSquare},#{destroyedSquare},#{note},#{reportingUnit})")
    void insert(CivilStructure civilStructure);

    @Delete("delete from civil_structure where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update civil_structure set id=#{id},date=#{date},location=#{location},basically_intact_square=#{basicallyIntactSquare},damaged_square=#{damagedSquare},destroyed_square=#{destroyedSquare},note=#{note},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(CivilStructure civilStructure);

    @Select("select * from civil_structure where no=#{no}")
    CivilStructure getByNo(@Param("no") Integer no);
}
