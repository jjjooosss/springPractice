package com.lgy.spring_mvc_board_jdbc.dao;


import com.lgy.spring_mvc_board_jdbc.dto.BDto;
import com.lgy.spring_mvc_board_jdbc.util.Constant;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import static java.lang.Integer.parseInt;


//DB SQL 처리
public class BDao {
    //    DataSource dataSource;
    JdbcTemplate template= null;
    public BDao() {
        //dbcp 방식으로 oracle 연결

//        try {
//            Context context = new InitialContext();
//            //context.xml에 설정 (server.xml과 달리 한번 설정으로 모든 프로젝트에서 사용가능)
//            //dataSource : CRUD쿼리에 모두 사용가능
//            dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Constant.template : 컨트롤러에서 설정됨
        template = Constant.template;
    }

    //게시판 목록조회
    public ArrayList<BDto> list(){
//        1. 4줄 방법
        //35줄 -> 4줄
//        ArrayList<BDto> dtos = null;
//        String sql = "select bid, bname, btitle, bcontent, bdate, bhit from mvc_board";
//        dtos = (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
//        return dtos;

//        2. 2줄 방법
//        String sql = "select bid, bname, btitle, bcontent, bdate, bhit from mvc_board";
//        return (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));

//        3. 1줄 방법
        return (ArrayList<BDto>) template.query("select bid, bname, btitle, bcontent, bdate, bhit from mvc_board"
                , new BeanPropertyRowMapper(BDto.class));

////        dtos : 게시글 담는 객체
//        ArrayList<BDto> dtos = new ArrayList<>();
//
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet res = null;
//
//        try {
//            String sql =  "select bid,bname,btitle,bcontent,bdate,bhit from mvc_board";
//            conn = dataSource.getConnection();
//            pstmt = conn.prepareStatement(sql);
//            res = pstmt.executeQuery();
//
//            while (res.next()){
//                int bid = res.getInt(1);
//                String bname = res.getString(2);
//                String btitle = res.getString(3);
//                String bcontent = res.getString(4);
//                Timestamp bdate = res.getTimestamp(5);
//                int bhit = res.getInt(6);
//                System.out.println("@#@#@"+bid);
//
//                //하나의 게시글
//                BDto bDto = new BDto(bid,bname,btitle,bcontent,bdate,bhit);
//                //게시글 추가(dtos : 여러 게시글이 될수 있음)
//                dtos.add(bDto);
//
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            try {
//                res.close();
//                pstmt.close();
//                conn.close();
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
//
    }

    //    final : 이벤트성으로 한번만 사용, 값을 고정시키기 위해
//    jdbcTemplate 쓸때 매개변수를 final로 사용하면 된다

    public void write(final String bname, final String btitle, final String bcontent) {
//        update: jdbc template으로 insert (PreparedStatementCreator 객체 사용)
        template.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                String sql ="insert into mvc_board(bid, bname, btitle, bcontent, bhit) "
                        + "values(MVC_BOARD_SEQ.NEXTVAL,?,?,?,0)";

//                con : 메소드 매개변수와 이름 일치
                PreparedStatement pstmt = con.prepareStatement(sql);
//                bname 파라미터 등은 final로 구성
                pstmt.setString(1, bname);
                pstmt.setString(2, btitle);
                pstmt.setString(3, bcontent);
                return pstmt; //반환타입 PreparedStatement, 반환값도 pstmt로
            }
        });

//        Connection conn=null;
//        PreparedStatement pstmt =null;
//
//        try {
//            conn =dataSource.getConnection();
//            String sql ="insert into mvc_board(bid, bname, btitle, bcontent, bhit) "
//                    + "values(MVC_BOARD_SEQ.NEXTVAL,?,?,?,0)";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, bname);
//            pstmt.setString(2, btitle);
//            pstmt.setString(3, bcontent);
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }

    }

    //    게시글 하나를 리턴하기 위해서 BDto 사용(strID:글번호)
    public BDto contentView(String strID){
        //게시글 조회수 올리기
        upHit(strID);

        String sql =  "select bid, bname, btitle, bcontent, bdate, bhit" +
                " from mvc_board where bid="+strID; //조건에 ? 쿼리 파라미터가 필요함
//        dtos = (ArrayList<BDto>) template.query(sql, new BeanPropertyRowMapper(BDto.class));
//        queryForObject : jdbc template 조회 처리
        return template.queryForObject(sql, new BeanPropertyRowMapper<BDto>(BDto.class));

//        BDto dto = null;
//        Connection conn = null;
//        PreparedStatement pstmt = null;
//        ResultSet res = null;
//
//        try {
//            conn = dataSource.getConnection();
//            String sql =  "select bid, bname, btitle, bcontent, bdate, bhit" +
//                    " from mvc_board where bid=?";
//
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, parseInt(strID));
//            res = pstmt.executeQuery();
//
//            //값이 하나라서 if사용
//            if (res.next()){
//                int bid = res.getInt(1);
//                String bname = res.getString(2);
//                String btitle = res.getString(3);
//                String bcontent = res.getString(4);
//                Timestamp bdate = res.getTimestamp(5);
//                int bhit = res.getInt(6);
//
//                //하나의 게시글
//                dto = new BDto(bid,bname,btitle,bcontent,bdate,bhit);
//
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        } finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
//        return dto;
    }
    //    게시글 조회수 올리기
    private void upHit(final String bid){
        String sql ="update mvc_board set bhit = bhit+1 where bid=?";
        template.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, parseInt(bid));
            }
        });

//        Connection conn=null;
//        PreparedStatement pstmt =null;
//
//        try {
//            conn =dataSource.getConnection();
//            String sql ="update mvc_board set bhit = bhit+1 where bid=?";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, parseInt(bid));
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
    }

    public void modify(final String bid, final String bname, final String btitle, final String bcontent){
        String sql ="update mvc_board set bname = ?, btitle = ?, bcontent = ? where bid=?";
        template.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
            ps.setInt(4, parseInt(bid));ps.setString(1,bname);
            ps.setString(2,btitle);
            ps.setString(3,bcontent);
            ps.setInt(4, parseInt(bid));
            }
        });

//        Connection conn=null;
//        PreparedStatement pstmt =null;
//
//        try {
//            conn =dataSource.getConnection();
//            String sql ="update mvc_board set bname = ?, btitle = ?, bcontent = ? where bid=?";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1,bname);
//            pstmt.setString(2,btitle);
//            pstmt.setString(3,bcontent);
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
    }

    //    **게시글삭제**
    public void delete(final String strID){
        String sql ="delete mvc_board where bid=?";
//        update : jdbc template 삭제 처리
        template.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setInt(1, parseInt(strID));
            }
        });
//        Connection conn=null;
//        PreparedStatement pstmt =null;
//
//        try {
//            conn =dataSource.getConnection();
//            String sql ="delete mvc_board where bid=?";
//            pstmt = conn.prepareStatement(sql);
//            pstmt.setInt(1, parseInt(strID));
//            pstmt.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                if (pstmt != null) pstmt.close();
//                if (conn != null) conn.close();
//            } catch (Exception e2) {
//                e2.printStackTrace();
//            }
//        }
    }
}