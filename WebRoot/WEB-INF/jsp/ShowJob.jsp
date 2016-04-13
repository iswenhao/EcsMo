<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'ShowJob.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
<center>
	<form action="${pageContest.requtex.contextPath }/getAllJobs.do"
		method="post">

		<table width="80%" bordercolor="black" border="1" >
			<tr>
				<td>编号</td>
				<td>表单名</td>
				<td>对应的表名</td>
				<td>操作</td>
				<td>字段映射关系</td>
				<td>job名称</td>
				<td>组名称</td>
				<td>描述</td>
				<td>创建时间</td>
				<td>修改时间</td>
				<td>状态</td>
			</tr>

			<c:forEach items="${remedyJobList}" var="remedyJob" varStatus="status">

				<tr>
					<td>${remedyJob.getId()}</td>
					<td>${remedyJob.getFormName()}</td>
					<td>${remedyJob.getTableName()}</td>
					<td>${remedyJob.getOperation()}</td>
					<td>${remedyJob.getField()}</td>
					<td>${remedyJob.getJobName()}</td>
					<td>${remedyJob.getGroup()}</td>
					<td>${remedyJob.getDescriptions()}</td>
					<td>${remedyJob.getCreateTime() }</td>
					<td>${remedyJob.getModifyTime() }</td>
					<td>${remedyJob.getStatus() }</td>
				</tr>

			</c:forEach>

		</table>

	</form>
	</center>
	<br>
</body>
</html>
