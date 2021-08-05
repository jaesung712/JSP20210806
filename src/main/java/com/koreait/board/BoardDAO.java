package com.koreait.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.db.Dbconn;
import com.koreait.db.SqlMapConfig;

public class BoardDAO {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql = "";
	List<BoardDTO> boardList = new ArrayList();

	SqlSessionFactory ssf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;

	
	public BoardDAO() {
		sqlsession = ssf.openSession(true); // openSession(true)설정 시 자동 커밋
	}

	
	public int delete(BoardDTO board) {
		HashMap<String, String> dataMap = new HashMap();
		dataMap.put("b_idx", String.valueOf(board.getIdx()));

		return sqlsession.delete("Board.delete", dataMap);
	}
	
	public int write(BoardDTO board) {
		HashMap<String, String> dataMap = new HashMap();
		dataMap.put("b_userid", board.getUserid());
		dataMap.put("b_title", board.getTitle());
		dataMap.put("b_content", board.getContent());
		dataMap.put("b_file", board.getFile());
		return sqlsession.insert("Board.write", dataMap);
	}
	
	
	public BoardDTO edit(BoardDTO board) {
		HashMap<String, String> dataMap = new HashMap();
		dataMap.put("b_idx", String.valueOf(board.getIdx()));
		dataMap = sqlsession.selectOne("Board.edit", dataMap);

		if (dataMap != null) {
			board.setTitle(dataMap.get("b_title"));
			board.setContent(dataMap.get("b_content"));
			board.setFile(dataMap.get("b_file"));
			return board;
		}
		return null;
	}
	
	
	
	public int edit_ok(BoardDTO board) {
		HashMap<String, String> dataMap = new HashMap();
		if(board.getFile() != null && !board.getFile().equals("")) {
			dataMap.put("b_idx", String.valueOf(board.getIdx()));
			dataMap.put("b_title", board.getTitle());
			dataMap.put("b_content", board.getContent());
			dataMap.put("b_file", board.getFile());
			return sqlsession.update("Board.edit_ok1", dataMap);	
			
		}else {
			dataMap.put("b_idx", String.valueOf(board.getIdx()));
			dataMap.put("b_title", board.getTitle());
			dataMap.put("b_content", board.getContent());
			return sqlsession.update("Board.edit_ok2", dataMap);
		}
		
		
	}
	
//	public BoardDTO view(BoardDTO board) {
//		HashMap<String, String> dataMap = new HashMap();
//		
//		dataMap.put("b_idx",String.valueOf(board.getIdx()));
//		sqlsession.update("Board.hit-up", dataMap);
//		
//		dataMap=sqlsession.selectOne("Board.view", dataMap);
//		if(dataMap!=null) {
//		board.setUserid(dataMap.get("b_userid"));
//		board.setFile(dataMap.get("b_file"));
//		board.setTitle(dataMap.get("b_title"));
//		board.setContent(dataMap.get("b_content"));
//		board.setRegdate(String.valueOf(dataMap.get("b_regdate")));
//		board.setLike(Integer.parseInt(String.valueOf(dataMap.get("b_like"))));
//		board.setHit(Integer.parseInt(String.valueOf(dataMap.get("b_hit"))));
//		
//		return board;
//		}else {
//			return null;
//		}
//	}
	
	public BoardDTO view(BoardDTO board) {
		
		try {
			conn = Dbconn.getConnection();
			if(conn != null) {
			sql = "update tb_board set b_hit = b_hit + 1 where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getIdx());
			pstmt.executeUpdate();
			
			sql = "select b_idx, b_userid, b_title, b_content, b_regdate, b_like, b_hit, b_file from tb_board where b_idx=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getIdx());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				board.setUserid( rs.getString("b_userid"));
				board.setTitle( rs.getString("b_title"));
				board.setRegdate(rs.getString("b_regdate"));
				board.setContent( rs.getString("b_content"));
				board.setLike( rs.getInt("b_like"));
				board.setHit( rs.getInt("b_hit"));
				board.setFile(rs.getString("b_file"));
				return board;
			}
			}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		Dbconn.close(conn, pstmt, rs);
	}
	return null;
   }
//	public int likeok(BoardDTO board) {
//		HashMap<String, Integer> dataMap = new HashMap();
//		dataMap.put("b_idx" , board.getIdx());
//		sqlsession.update("Board.update_like_ok", board.getIdx());
//		dataMap = sqlsession.selectOne("Board.select_like_ok" , dataMap);
//		if(dataMap != null) {
//			board.setLike(dataMap.get("b_like"));
//			return board.getLike();
//		}
//		return
//		
//	}
}
