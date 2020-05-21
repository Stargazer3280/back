package com.example.demo.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StatusDao {
    @Update("update status set civil_structure=#{newStatus} where no=1")
    void updateCivilStructure(@Param("newStatus") Integer newStatus);

    @Update("update status set collapse_record=#{newStatus} where no=1")
    void updateCollapseRecord(@Param("newStatus") Integer newStatus);

    @Update("update status set comm_disaster=#{newStatus} where no=1")
    void updateCommDisaster(@Param("newStatus") Integer newStatus);

    @Update("update status set death_statistics=#{newStatus} where no=1")
    void updateDeathStatistics(@Param("newStatus") Integer newStatus);

    @Update("update status set disaster_prediction=#{newStatus} where no=1")
    void updateDisasterPrediction(@Param("newStatus") Integer newStatus);

    @Select("select civil_structure from status where no=1")
    Integer selectCivilStructure();

    @Select("select collapse_record from status where no=1")
    Integer selectCollapseRecord();

    @Select("select comm_disaster from status where no=1")
    Integer selectCommDisaster();

    @Select("select death_statistics from status where no=1")
    Integer selectDeathStatistics();

    @Select("select disaster_prediction from status where no=1")
    Integer selectDisasterPrediction();
}
