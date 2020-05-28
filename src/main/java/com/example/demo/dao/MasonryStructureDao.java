package com.example.demo.dao;

import com.example.demo.entity.MasonryStructure;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MasonryStructureDao {
    @Select("select * from masonry_structure")
    List<MasonryStructure> getAll();

    @Insert("insert into masonry_structure(id,date,location,basically_intact_square,slight_damaged_square,moderate_damaged_square,serious_damaged_square,destroyed_square,note,reporting_unit) values(#{id},#{date},#{location},#{basicallyIntactSquare},#{slightDamagedSquare},#{moderateDamagedSquare},#{seriousDamagedSquare},#{destroyedSquare},#{note},#{reportingUnit})")
    void insert(MasonryStructure masonryStructure);

    @Delete("delete from masonry_structure where no=#{no}")
    void delete(@Param("no") Integer no);

    @Update("update masonry_structure set id=#{id},date=#{date},location=#{location},basically_intact_square=#{basicallyIntactSquare},slight_damaged_square=#{slightDamagedSquare},moderate_damaged_square=#{moderateDamagedSquare},serious_damaged_square=#{seriousDamagedSquare},destroyed_square=#{destroyedSquare},reporting_unit=#{reportingUnit} where no=#{no}")
    void update(MasonryStructure masonryStructure);

    @Select("select * from masonry_structure where no=#{no}")
    MasonryStructure getByNo(@Param("no") Integer no);
}
