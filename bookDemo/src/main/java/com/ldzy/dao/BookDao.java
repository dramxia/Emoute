package com.ldzy.dao;

import com.github.pagehelper.Page;
import com.ldzy.domain.Book;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface BookDao {
    @Select("<script>" +
            "select * from book " +
            "<where>" +
            "<if test=\"id != null\"> AND id=#{id} </if>" +
            "<if test=\"name != null\"> AND  name  like  CONCAT('%',#{name},'%')</if>" +
            "<if test=\"press != null\"> AND press like  CONCAT('%', #{press},'%') </if>" +
            "<if test=\"author != null\"> AND author like  CONCAT('%', #{author},'%')</if>" +
            "</where>" +
            " order by uploadtime desc"+
            "</script>")
    public Page<Book> findByBookWithUpLoadTimeDesc(Book book);//如果book为空，查询所有，如果book.name="abc",查询书名含有abc的书

    @Update("<script>" +
            "update book " +
            "<set>" +
            "<if test=\"name != null\" >" +
            "                name = #{name}," +
            "            </if>" +
            "            <if test=\"isbn != null\" >" +
            "                isbn = #{isbn}," +
            "            </if>" +
            "            <if test=\"press != null\" >" +
            "                press = #{press}," +
            "            </if>" +
            "            <if test=\"author != null\" >" +
            "                author = #{author}," +
            "            </if>" +
            "            <if test=\"pagination != null\" >" +
            "                pagination = #{pagination}," +
            "            </if>" +
            "            <if test=\"price != null\" >" +
            "                price = #{price}," +
            "            </if>" +
            "            <if test=\"uploadTime != null\" >" +
            "                uploadtime = #{uploadTime}," +
            "            </if>" +
            "            <if test=\"status != null\" >" +
            "                status = #{status}," +
            "            </if>" +
            "            <if test=\"borrower!= null\" >" +
            "                borrower= #{borrower }," +
            "            </if>" +
            "            <if test=\"borrowTime != null\" >" +
            "                borrowtime = #{borrowTime}," +
            "            </if>" +
            "            <if test=\"returnTime != null\" >" +
            "                returntime = #{returnTime}" +
            "            </if>"+
            "</set>" +
            "where id=#{id}" +
            "</script>")
    public int edit(Book book);
}
