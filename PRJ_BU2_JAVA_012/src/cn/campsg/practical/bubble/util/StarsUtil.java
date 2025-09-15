package cn.campsg.practical.bubble.util;

import java.util.HashMap;
import java.util.Map;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * 锟斤拷锟斤拷锟斤拷/锟斤拷锟狡讹拷锟斤拷锟斤拷锟斤拷实锟斤拷锟洁工锟斤拷锟洁，锟结供锟斤拷锟铰癸拷锟杰ｏ拷<br>
 * <ul>
 * <li>1. 锟斤拷锟斤拷指锟斤拷锟叫憋拷锟叫碉拷锟斤拷锟斤拷锟斤拷-锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷同锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷冒锟斤拷锟斤拷锟斤拷锟姐法锟斤拷锟斤拷</li>
 * <li>2. 锟斤拷指锟斤拷锟叫憋拷锟叫碉拷锟斤拷锟斤拷锟角帮拷锟叫凤拷锟介。</li>
 * <li>3. 锟斤拷隆一锟斤拷锟斤拷锟斤拷锟角讹拷锟斤拷</li>
 * </ul>
 * 
 * @see cn.campsg.practical.bubble.entity.Star
 * @see cn.campsg.practical.bubble.entity.MovedStar
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 *
 */
public class StarsUtil {

	/**
	 * 锟斤拷锟斤拷指锟斤拷锟叫憋拷锟叫碉拷锟斤拷锟斤拷锟斤拷<br>
	 * 锟斤拷锟斤拷锟斤拷颍喊锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷同锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷<br>
	 * 锟斤拷锟斤拷锟姐法锟斤拷冒锟斤拷锟斤拷锟斤拷
	 * 
	 * @param starList
	 *            锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷斜锟�
	 */
	public static void sort(StarList starList) {
		/*****PRJ-BU2-JAVA-012 Task1 锟斤拷1/3 Start锟斤拷*******/
		 for (int i = 0; i < starList.size(); i++) {
		        for (int j = 0; j < starList.size() - i - 1; j++) {
		            Star preStar = starList.get(j);
		            Star nextStar = starList.get(j + 1);
		            if (preStar.getPosition().getColumn() > nextStar.getPosition().getColumn()) {
		                swap(preStar, nextStar);
		            } else if (preStar.getPosition().getColumn() == nextStar.getPosition().getColumn()) {
		                if (preStar.getPosition().getRow() > nextStar.getPosition().getRow()) {
		                    swap(preStar, nextStar);
		                }
		            }
		        }
		    }



		
		/*****PRJ-BU2-JAVA-012 Task1 锟斤拷1/3 End锟斤拷********/
	}


	/**
	 * 锟斤拷锟斤拷锟斤拷锟斤拷蚪换锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷斜锟斤拷械锟街�
	 * 
	 * @param preStar
	 *            锟斤拷N锟斤拷锟斤拷锟斤拷锟斤拷
	 * @param nextStar
	 *            锟斤拷N+1锟斤拷锟斤拷锟斤拷锟斤拷
	 */
	private static void swap(Star preStar, Star nextStar) {
		// 锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟角讹拷锟斤拷
		Star tempStar = new Star();

		// 锟斤拷锟斤拷N锟斤拷锟斤拷锟斤拷锟角碉拷锟斤拷锟捷憋拷锟斤拷锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟角讹拷锟斤拷
		tempStar.getPosition().setRow(preStar.getPosition().getRow());
		tempStar.getPosition().setColumn(preStar.getPosition().getColumn());
		tempStar.setType(preStar.getType());

		// 锟斤拷锟斤拷N+1锟斤拷锟斤拷锟斤拷锟角碉拷锟斤拷锟捷憋拷锟斤拷锟斤拷锟絅锟斤拷锟斤拷锟斤拷锟斤拷
		preStar.getPosition().setRow(nextStar.getPosition().getRow());
		preStar.getPosition().setColumn(nextStar.getPosition().getColumn());
		preStar.setType(nextStar.getType());

		// 锟斤拷锟斤拷时锟斤拷锟斤拷锟斤拷锟斤拷锟角讹拷锟斤拷锟斤拷锟斤拷荼锟斤拷锟斤拷锟斤拷N+1锟斤拷锟斤拷锟斤拷锟斤拷
		nextStar.getPosition().setRow(tempStar.getPosition().getRow());
		nextStar.getPosition().setColumn(tempStar.getPosition().getColumn());
		nextStar.setType(tempStar.getType());
	}

	/**
	 * 锟斤拷锟叫号讹拷锟斤拷锟斤拷锟角硷拷锟斤拷锟斤拷锟斤拷锟斤拷锟角斤拷锟叫凤拷锟介（锟斤拷同锟叫号碉拷锟斤拷锟斤拷锟角凤拷锟斤拷一锟斤拷锟斤拷锟斤拷校锟�<br>
	 * 锟斤拷锟斤拷前应锟斤拷锟饺讹拷锟斤拷锟斤拷锟角硷拷锟较斤拷锟斤拷锟斤拷锟斤拷
	 * 
	 * @see sort
	 * 
	 * @param mStarList
	 *            锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷锟斤拷斜锟�
	 * @return 
	 *         锟斤拷锟斤拷锟斤拷锟斤拷Map锟叫碉拷key锟斤拷锟叫号ｏ拷value锟斤拷锟斤拷同锟叫碉拷锟斤拷锟斤拷锟角硷拷锟较ｏ拷锟斤拷锟界：1-{(1,2);(1,3);(1,4)}锟斤拷2-{(2,2)
	 *         ;(2,3);(2,4)}
	 */
	/*****PRJ-BU2-JAVA-012 Task2 锟斤拷2/3 Start锟斤拷*******/

	public static Map<Integer, StarList> group(StarList starList) {
	    Map<Integer, StarList> ret = new HashMap<Integer, StarList>();
	    sort(starList);
	    for (int i = 0; i < starList.size(); i++) {
	        Star star = starList.get(i);
	        if (!ret.containsKey(star.getPosition().getColumn())) {
	            StarList list = new StarList();
	            list.add(star);
	            ret.put(star.getPosition().getColumn(), list);
	        } else {
	            ret.get(star.getPosition().getColumn()).add(star);
	        }
	    }
	    return ret;
	}
	
	
	
	
	
	
	/*****PRJ-BU2-JAVA-012 Task2 锟斤拷2/3 End锟斤拷*********/

	/**
	 * 锟斤拷隆一锟斤拷锟铰碉拷锟斤拷锟斤拷锟角★拷
	 * 
	 * @param star
	 *            锟斤拷锟斤拷隆锟斤拷锟斤拷锟斤拷锟斤拷
	 * @return 锟铰碉拷锟斤拷锟斤拷锟角ｏ拷锟斤拷锟斤拷锟节达拷锟街凤拷锟斤拷锟斤拷锟斤拷牵锟斤拷锟�
	 */
	public static Star clone(Star star) {

		Star ret = new Star();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}

	public static MovedStar toMovedStar(Star star) {

		MovedStar ret = new MovedStar();

		ret.setPosition(new Position(star.getPosition().getRow(), star
				.getPosition().getColumn()));
		ret.setType(star.getType());

		return ret;
	}
}
