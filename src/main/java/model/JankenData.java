package model;

public class JankenData {
	private int result;
	private int playerChoice;
	private int enemyChoice;
	private int winsNum;
	private int lossesNum;
	
	public final static int JADGE_LOSE = 0;
	public final static int JADGE_WIN = 1;
	public final static int JADGE_DRAW = 2;
	public final static int CHOICE_Rock = 0;
	public final static int CHOICE_SCISSORS = 1;
	public final static int CHOICE_paper = 2;
	
	public void setResult(int result) {
		this.result = result;
	}
	public int getResult() {
		return this.result;
	}
	
	public void setPlayerChoice(int playerChoice){
		this.playerChoice = playerChoice;
	}
	public int getPlayerChoice() {
		return this.playerChoice;
	}
	
	public void setEnemyChoice(int enemyChoice) {
		this.enemyChoice = enemyChoice;
	}
	public int getEnemyChoice() {
		return this.enemyChoice;
	}
	
	public void setWinsNum(int winsNum) {
		this.winsNum = winsNum;
	}
	public int getWinsNum() {
		return this.winsNum;
	}
	
	public void setLossesNum(int lossesNum) {
		this.lossesNum = lossesNum;
	}
	public int getLossesNum() {
		return this.lossesNum;
	}
}
