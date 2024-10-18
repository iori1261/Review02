<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.JankenData" %>
<%
JankenData janken = (JankenData)session.getAttribute("Janken");
	int playerChoice;
	int enemyChoice;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>じゃんけん結果</title>
</head>
<body>
	<table>
		<tr><td colspan="3" align="center">
		<%
			if(janken.getResult() == janken.JADGE_WIN){
				%><h1>あなたの勝ち！</h1><%
			}else if(janken.getResult() == janken.JADGE_LOSE){
				%><h1>あなたの負け！</h1><%
			}else{
				%><h1>引き分け！</h1><%
			}
		%>
		</td>
		<tr align="center">
			<td>あなたの手</td>
			<td>あいての手</td>
		</tr>
		<tr  align="center"><td>
		<%
			playerChoice = janken.getPlayerChoice();
			enemyChoice = janken.getEnemyChoice();
		
			if(playerChoice == janken.CHOICE_Rock){
				%><img src="img/グー.png" height="250" width="250"><%
			}else if(playerChoice == janken.CHOICE_SCISSORS){
				%><img src="img/チョキ.png" height="250" width="250"><%
			}else{
				%><img src="img/パー.png" height="250" width="250"><%
			}
		%>
		</td>
		<td>
		<%
			if(enemyChoice == janken.CHOICE_Rock){
				%><img src="img/グー.png" height="250" width="250"><%
			}else if(enemyChoice == janken.CHOICE_SCISSORS){
				%><img src="img/チョキ.png" height="250" width="250"><%
			}else{
				%><img src="img/パー.png" height="250" width="250"><%
			}
		%>
		</td></tr>
		<tr>
			<td colspan="3" align="center">
				<h1><%= janken.getWinsNum() %>勝<%= janken.getLossesNum() %>敗</h1>
			</td>
		</tr>
	</table>
	
	<p>
		<a href="janken.html">もうひと勝負！！</a>
	</p>
</body>
</html>