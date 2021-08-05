package com.koreait.reply;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.koreait.db.Dbconn;
import com.koreait.db.SqlMapConfig;

public class ReplyDAO {
	List<ReplyDTO> replyList = new ArrayList();
	ArrayList<ReplyDTO> list=null;
	
	
	SqlSessionFactory ssf = SqlMapConfig.getSqlMapInstance();
	SqlSession sqlsession;
	
	
	public ReplyDAO() {
		sqlsession = ssf.openSession(true);	// openSession(true) 설정시 자동 commit
		
	}
	
	public int reply_ok(ReplyDTO reply) {
		HashMap<String, String> dataMap = new HashMap();
		dataMap.put("re_userid", reply.getUserid());
		dataMap.put("re_content", reply.getContent());
		dataMap.put("re_boardidx", String.valueOf(reply.getBoardidx()));
	
		return sqlsession.insert("Reply.reply_ok", dataMap);

	  	}
	
	public List<ReplyDTO> view_reply(String idx) {
		return sqlsession.selectList("Reply.view_reply", idx);
	}
	
	
	public int reply_del(ReplyDTO reply) {
		HashMap<String, String> dataMap = new HashMap();
		dataMap.put("re_idx", String.valueOf(reply.getReidx()));
		return sqlsession.delete("Reply.reply_del",dataMap);
	}
}
