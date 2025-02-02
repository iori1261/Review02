package servlet;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.JankenData;

@WebServlet("/JankenServlet")
public class JankenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public JankenServlet() {
        super();
        
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//HTMLから選択されたデータを入手し文字列型から整数型に変換
		String janken = request.getParameter("janken");
		Integer jn = Integer.valueOf(janken);
	    int jnum = jn;
	    int result = 0;
		int winnum = 0;
		int lossesNum = 0;
		//ランダムな手を出すじゃんけん相手の生成
		Random random = new Random();
		int rnum = random.nextInt(3);
		//前回までのデータを取得
		HttpSession session = request.getSession();
		JankenData janken1 = (JankenData)session.getAttribute("janken");
		//JankenDataが取得できなかったら新規作成
		if(janken1 == null) {
			janken1 = new JankenData();
			janken1.setWinsNum(0);
			janken1.setLossesNum(0);
		}
		//今回のじゃんけんの結果を記録
		janken1.setResult(result);
		janken1.setPlayerChoice(jnum);
		janken1.setEnemyChoice(rnum);
		if(result == JankenData.JADGE_WIN) {
			janken1.setWinsNum(janken1.getWinsNum()+1);
		}else if(result == JankenData.JADGE_LOSE) {
			janken1.setLossesNum(janken1.getLossesNum()+1);
		}
		
		session.setAttribute("janken", session);
		//勝敗の選別
		//パー
		
		
		if(jnum == 2){
			if(rnum == 2){
				result = 2; //あいこ
				winnum = 1;
				lossesNum = 0;
			}else if(rnum == 1){
				result = 0; //負け
				winnum = 1;
				lossesNum = 0;
			}else if(rnum == 0){
				result = 1; //勝ち
				winnum = 1;
				lossesNum = 0;
			}
		//チョキ
		}else if(jnum == 1){
			if(rnum == 2){
				result = 0; //負け
				winnum = 0;
				lossesNum = 2;
			}else if(rnum == 1){
				result = 2; //あいこ
				winnum = 0;
				lossesNum = 2;
			}else if(rnum == 0){
				result = 1; //勝ち
				winnum = 0;
				lossesNum = 2;
			}
		//グー
		}else if(jnum == 0){
			if(rnum == 2){
				result = 1; //勝ち
				winnum = 2;
				lossesNum = 1;
			}else if(rnum == 1){
				result = 0; //負け
				winnum = 2;
				lossesNum = 1;
			}else if(rnum == 0){
				result = 2; //あいこ
				winnum = 2;
				lossesNum = 1;
			}
			
		}
		//modelのインスタンス生成
		JankenData Jankendata = new JankenData();
		Jankendata.setEnemyChoice(rnum);
		Jankendata.setPlayerChoice(jnum);
		Jankendata.setResult(result);
		Jankendata.setWinsNum(winnum);
		Jankendata.setLossesNum(lossesNum);
		
		//モデルオブジェクトをリクエストスコープにセットしてJSPに転送
	    request.setAttribute("enemyChoice", rnum);
	    request.setAttribute("playerChoice", jnum);
	    request.setAttribute("result", result);
	    request.setAttribute("winsNum", winnum);
	    request.setAttribute("lossesNum", lossesNum);

	    //disp.jspに転送
	    RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/jankenResult.jsp");
	    dispatcher.forward(request, response);
	}

}
