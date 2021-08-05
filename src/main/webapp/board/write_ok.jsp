<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="java.sql.*"%>
<%@ page import="com.koreait.db.Dbconn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	if(session.getAttribute("userid") == null){
%>
	<script>
		alert('로그인 후 이용하세요');
		location.href='../login.jsp';
	</script>
<%
	}else{
		
%>
	<jsp:useBean id="boardDTO" class="com.koreait.board.BoardDTO"/>
	
	<jsp:useBean id="boardDAO" class="com.koreait.board.BoardDAO"/>
<%
		boardDTO.setUserid((String)session.getAttribute("userid"));
		
		String uploadPath = request.getRealPath("upload");
		System.out.println(uploadPath);
		int size = 1024*1024*10;
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8", new DefaultFileRenamePolicy());
		
		boardDTO.setTitle(multi.getParameter("b_title"));
		boardDTO.setFile(multi.getFilesystemName("b_file"));
		boardDTO.setContent(multi.getParameter("b_content"));
		
	if(boardDAO.write(boardDTO) == 1){
		
		
%>

<script>
	alert('등록되었습니다');
	location.href='list.jsp';
</script>
<%
	}else {
%>
<script>
	alert("등록실패");
	history.back();
</script>
<%
	}
		}
%>