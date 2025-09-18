package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Score;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * 
 * 分数服务类用于为界面提供以下功能<br>
 * 1. 计算关卡通关分数<br>
 * 2. 切关判定<br>
 * 3. 根据消除的泡泡计算得分<br>
 * 4. 计算剩余泡泡糖的得分奖励<br>
 * 
 * @author Frank.Chen
 * @version 1.1
 *
 */
public class ScoreServiceImpl implements ScoreService {
	private Configuration mConfiguration = null;

	public ScoreServiceImpl(){
	    mConfiguration = new Configuration();
	}

	/*******PRJ-BU2-JAVA-014 Test1 【1/3 Start】************/
	/**
	 * 获得当前关的通关分数
	 * 
	 * @return 计算出的得分
	 * 
	 */
	@Override
	public int getCurrentLevelScore() {

		return mConfiguration.getScore().getLevelScore();
	}
	/*******PRJ-BU2-JAVA-014 Test1 【1/3 End】**************/
	
	/**
	 * 根据要切换的关卡等级获取目标分数
	 * 	
	 * @param 下一关关卡
	 * @return 计算出的得分
	 * 
	 */
	/*******PRJ-BU2-JAVA-014 Test2 【2/3 Start】************/
	@Override
	public int nextScoreByLevel(int nextLevel) {
		Score score = mConfiguration.getScore();
	    if(score == null){
	        return 0;
	    }
	    score.setLevelScore(score.getLevelScore() + (nextLevel - 1) / score.getLength() * score.getIncrement() + score.getStep());
	    return score.getLevelScore();
	}
	/*******PRJ-BU2-JAVA-014 Test2 【2/3 End】**************/

	/**
	 * 根据本关卡计算出本关的关卡得分
	 * 
	 * @param level
	 *            上一关关卡
	 * @return 本关的关卡得分
	 */
	
	@Override
	public boolean isChangeLevel(int score) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public int getScoreByStars(StarList stars) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScoreByStars(int stars) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getAwardScore(int awardStarNum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNoticePassLevel(int currentLevel, int score) {
		// TODO Auto-generated method stub
		return false;
	}

}
