package com.lgy.spring_test_item_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.lgy.spring_test_item_jdbc.dto.ItemDto;
import com.lgy.spring_test_item_jdbc.util.Constant;

/**
 *
 */
public class ItemDao {
//	DataSource dataSource;
	JdbcTemplate template=null;

	public ItemDao() {
		template = Constant.template;
	}
	
	public ArrayList<ItemDto> list(){
		return (ArrayList<ItemDto>)template.query("select name, price, description from item"
                , new BeanPropertyRowMapper(ItemDto.class));
		
	}
	public void write(final String name,final String price,final String description) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql ="insert into item(name, price, description) "
						+ "values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, name);
				pstmt.setInt(2, Integer.parseInt(price));
				pstmt.setString(3, description);
				return pstmt;
			}
		});
	}
}
