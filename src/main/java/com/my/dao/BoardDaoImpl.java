package com.my.dao;

import com.my.dto.BoardDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BoardDaoImpl implements BoardDao {
    @Autowired
    SqlSession session;

    String namespace = "com.fastcampus.ch3.dao.BoardMapper."; //sql의 id앞에 패키지이름이 붙어야 소환됨

    @Override
    public BoardDto select(Integer bno) throws Exception {
        return session.selectOne(namespace + "select", bno);
    }

    @Override
    public List<BoardDto> selectAll() throws Exception {
        return session.selectList(namespace + "selectAll");
    }
    @Override
    public int count() throws Exception {
        return session.selectOne(namespace + "count");
    }

    @Override
    public int delete(Integer bno, String writer) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("writer", writer);
        return session.delete(namespace + "delete", map);
    }

    @Override
    public int deleteAll() throws Exception{
        return session.delete(namespace + "deleteAll");
    }

    @Override
    public int insert(BoardDto dto) throws Exception{
        return session.insert(namespace + "insert", dto);
    }

    @Override
    public  int update(BoardDto dto) throws Exception{
        return session.update(namespace + "update", dto);
    }

    @Override
    public int updateCommentCnt(Integer bno, Integer cnt) throws Exception {
        Map map = new HashMap();
        map.put("bno", bno);
        map.put("cnt", cnt);
        return session.update(namespace + "updateCommentCnt", map);
    }

    @Override
    public int increaseViewCnt(Integer bno) throws Exception {
        return session.update(namespace + "increaseViewCnt", bno);
    }

    @Override
    public List<BoardDto> selectPage(Map map) throws Exception {
        return session.selectList(namespace+"selectPage", map);
    } // List<E> selectList(String statement, Object parameter)
}

//public class BoardDaoImpl implements BoardDao {
//    @Override
//    public List<BoardDto> selectPage(Map map) throws Exception {
//        return session.selectList(namespace+"selectPage", map);
//    } // List<E> selectList(String statement, Object parameter)
//
//    @Override
//    public int searchResultCnt(SearchCondition sc) throws Exception {
//        System.out.println("sc in searchResultCnt() = " + sc);
//        System.out.println("session = " + session);
//        return session.selectOne(namespace+"searchResultCnt", sc);
//    } // T selectOne(String statement, Object parameter)
//
//    @Override
//    public List<BoardDto> searchSelectPage(SearchCondition sc) throws Exception {
//        return session.selectList(namespace+"searchSelectPage", sc);
//    } // List<E> selectList(String statement, Object parameter)
//}
