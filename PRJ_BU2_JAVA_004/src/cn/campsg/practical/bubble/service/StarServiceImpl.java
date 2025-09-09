package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.util.StarsUtil;

/**
 * 
 * 泡泡糖业务计算服务类，用于为界面提供以下服务<br>
 * 1. 创建屏幕画布随机泡泡糖<br>
 * 2. 切关判定<br>
 * 3. 根据消除的泡泡计算得分<br>
 * 4. 计算剩余泡泡糖的得分奖励<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	/**
	 * 创建屏幕画布随机泡泡糖（10 * 10）
	 * 
	 * @return 泡泡糖列表-供画面显示
	 */
	@Override
	public StarList createStars() {

		StarList stars = new StarList();
		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {
			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {
				Star star = new Star();
				// 设置泡泡糖在画面上的位置
				star.setPosition(new Position(row, col));
				// 产生随机的泡泡糖
				if(row>=3&&row<=6 && col>=3&&col<=6){
					star.setType(StarType.RED);
				}else{
					star.setType(StarType.YELLOW);
				}
				// 加入列表
				stars.add(star);
			}
		}
		return stars;
	}
	
	/**
	 * 以给定泡泡糖（用户点击的）为基础，向左右、上下路径依次寻找相同类型的泡泡糖
	 * 
	 * @param base
	 *            基础泡泡糖（用户点击的）
	 * @param sList
	 *            原始泡泡糖列表（界面上排列的泡泡糖）
	 * @param clearStars
	 *            待清除的泡泡糖列表
	 */
	private void lookupByPath(Star base, StarList sList, StarList clearStars) {
		int row = base.getPosition().getRow();
        int column = base.getPosition().getColumn();
        StarType type = base.getType();

		/******************** PRJ-BU2-JAVA-004 Task2 ********************/
        //左侧
        
        while(column>0){
       	 column = column -1;
       	 Star leftstar = sList.lookup( row, column);
       	 if(leftstar != null && clearStars.existed(leftstar) == false && leftstar.getType() == base.getType()){   	
       		clearStars.add(leftstar);
       		lookupByPath(leftstar,sList,clearStars);
           }
       }

	     


		
		
		
		
		
		
		
		
		/**************************************************************/

		/******************** PRJ-BU2-JAVA-004 Task3 ********************/
        //右侧
        
        while (column<StarService.MAX_COLUMN_SIZE){
     	   column = column + 1;
     	   Star rightstar = sList.lookup(row, column);
     	   if(rightstar != null && clearStars.existed(rightstar) == false && rightstar.getType()==base.getType()){
     		   clearStars.add(rightstar);
     	       lookupByPath(rightstar,sList,clearStars);
     	   }   	   
        }
        column = base.getPosition().getColumn();

     
		
		
		
		
		
		
		
		/**************************************************************/

		/******************** PRJ-BU2-JAVA-004 Task4 ********************/

        //顶部
        while(row >0){
        	row = row-1;
        	Star upstar = sList.lookup(row, column);
        	if(upstar !=null && clearStars.existed(upstar)==false && upstar.getType()==base.getType()){
        		clearStars.add(upstar);
        		lookupByPath(upstar,sList,clearStars);
        	}
        }

		
		
		
		
		
		
		
		/**************************************************************/

		/******************** PRJ-BU2-JAVA-004 Task5 ********************/

        //底部
        while(row <10){
        	row = row +1;
        	Star downstar = sList.lookup(row, column);
        	if (downstar != null && clearStars.existed(downstar)==false && downstar.getType()==base.getType()){
        		clearStars.add(downstar);
        		lookupByPath(downstar,sList,clearStars);
        	}
        } 

		
		
		
		
		
		
		
		
		/**************************************************************/

		// 以上四个判断都不进，则表示四周都没用泡泡糖了，那么跳出递归方法。
	}

	/**
	 * 用户点击泡泡糖，获取满足消除条件的泡泡糖列表
	 * 
	 * @param base
	 *            被用户点击的泡泡糖
	 * @param sList
	 *            当前画面上泡泡的列表
	 * @return 需要清除的泡泡糖
	 */
	@Override
	public StarList tobeClearedStars(Star base, StarList mCurrent) {
		/******************** PRJ-BU2-JAVA-004 Task2 ********************/
		StarList clears = new StarList();
	    clears.add(base);
	    this.lookupByPath(base, mCurrent, clears);
	    if (clears.size() == 1)
	        clears.clear();

	    return clears;

		
		
		
		
		
		
		/**************************************************************/
	}

	public StarList getVMovedStars(StarList clearStars,
			StarList currentStarList) {
		return null;
	}

	/**
	 * 消除泡泡糖后，获取待移动泡泡糖列表(仅限水平列表的泡泡糖)<br>
	 * 该功能固定在垂直列表的泡泡糖之后运行
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * 
	 * @return 待移动泡泡糖列表
	 */
	public StarList getHMovedStars(StarList currentStarList) {
		return null;
	}

	/**
	 * 判断是否还存在未消除的泡泡糖
	 * 
	 * @param currentStarList
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return true:任然有未消除的泡泡糖,false:没有未消除的泡泡糖
	 * 
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		return false;
	}

	/**
	 * 获取无法消除泡泡糖列表
	 * 
	 * @param curretStars
	 *            当前完整的界面泡泡糖列表（已经被消除的泡泡糖用null表示）
	 * @return 无法消除泡泡糖列表
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		return null;
	}
}
