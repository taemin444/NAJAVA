package com.my.dao;

import com.my.dto.BoardDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BoardDao {
    BoardDto select(Integer bno) throws Exception;

    List<BoardDto> selectAll() throws Exception;

    int count() throws Exception;

    int delete(Integer bno, String writer) throws Exception;

    int deleteAll() throws Exception;

    int insert(BoardDto dto) throws Exception;

    int update(BoardDto dto) throws Exception;

    int updateCommentCnt(Integer bno, Integer cnt) throws Exception;

    int increaseViewCnt(Integer bno) throws Exception;

    List<BoardDto> selectPage(Map map) throws Exception;
}
