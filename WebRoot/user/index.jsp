<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
  <head>
    <title>用户信息添加页面</title>
	<style type="text/css">
	<!--
	body {
		margin-left: 0px;
		margin-top: 0px;
		margin-right: 0px;
		margin-bottom: 0px;
		background-color: #EEF2FB;
	}
	#addSubjectForm table  td{
		font-size:12px;
	}
	-->
	</style>
	<link href="images/skin.css" rel="stylesheet" type="text/css">
  </head>
<body> 
 <table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td width="17" valign="top" background="images/mail_leftbg.gif"><img src="images/left-top-right.gif" width="17" height="29" /></td>
    <td valign="top" background="images/content-bg.gif"><table width="100%" height="31" border="0" cellpadding="0" cellspacing="0" class="left_topbg" id="table2">
      <tr>
        <td height="31"><div class="titlebt">录入用户信息</div></td>
      </tr>
    </table></td>
    <td width="16" valign="top" background="images/mail_rightbg.gif"><img src="images/nav-right-bg.gif" width="16" height="29" /></td>
  </tr>
  <tr>
    <td valign="middle" background="images/mail_leftbg.gif">&nbsp;</td>
    <td valign="top" bgcolor="#F7F8F9"><table width="98%" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="53%" valign="top">&nbsp;</td>
        </tr>
      <tr>
        <td valign="middle"><span class="left_txt">
			<div id="addCvForm" align="center"><!--录入试题表单-->
				<form action="cvAdd.action" method="post">
				<table border="0" cellspacing="10" cellpadding="0">
				  <tr>
					<td colspan="2"><FONT color="red"><s:actionerror/></FONT></td>
				  </tr>
				  <tr>
					<td>用户名:</td>
					<td><input type="text" name="name" size="20" ></td>
				  </tr>
				  <tr>
					<td>性别:</td>
					<td><input type="text" name="sex" size="20" ></td>
				  </tr>
				   <tr>
					<td>电话号:</td>
					<td><input type="text" name="phone_number" size="20" ></td>
				  </tr>
				   <tr>
					<td>民族:</td>
					<td><input type="text" name="nation" size="20" ></td>
				  </tr>
				   <tr>
					<td>学历:</td>
					<td><input type="text" name="eduback" size="20" ></td>
				  </tr>
				   <tr>
					<td>英语能力:</td>
					<td><input type="text" name="ehpower" size="20" ></td>
				  </tr>
				   <tr>
					<td>毕业时间:</td>
					<td><input type="text" name="ftime" size="20" ></td>
				  </tr>
				   <tr>
					<td>工作经历:</td>
					<td><input type="text" name="jexperience" size="20" ></td>
				  </tr>
				   <tr>
					<td>自我评价:</td>
					<td><input type="text" name="evaluation" size="20" ></td>
				  </tr>
				  <tr>
				  	<td colspan="2"><div align="center">
				  	  <input type="submit" value="录入">				  	  
				  	  <input type="reset" value="重置">
			  	  </div>
				</td>
				  </tr>
			</table>
			</form>	
			</div>
		</td>
        </tr>
      
    </table></td>
    <td background="images/mail_rightbg.gif">&nbsp;</td>
  </tr>
  <tr>
    <td valign="bottom" background="images/mail_leftbg.gif"><img src="images/buttom_left2.gif" width="17" height="17" /></td>
    <td background="images/buttom_bgs.gif"><img src="images/buttom_bgs.gif" width="17" height="17"></td>
    <td valign="bottom" background="images/mail_rightbg.gif"><img src="images/buttom_right2.gif" width="16" height="17" /></td>
  </tr>
</table>
</body>
</html>
