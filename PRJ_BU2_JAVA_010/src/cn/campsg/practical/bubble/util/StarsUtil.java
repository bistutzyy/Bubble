package cn.campsg.practical.bubble.util;

import cn.campsg.practical.bubble.entity.MovedStar;
import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;

/**
 * 泡泡糖/待移动泡泡糖实体类工具类，提供以下功能：<br>
 * <ul>
 * <li>1. 排序指定列表中的泡泡糖-按列升序排序，列相同按行升序排序（冒泡排序算法）。</li>
 * <li>2. 对指定列表中的泡泡糖按行分组。</li>
 * <li>3. 克隆一个泡泡糖对象</li>
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
	 * 排序指定列表中的泡泡糖<br>
	 * 排序规则：按列升序排序，如果列相同按行升序排序<br>
	 * 排序算法：冒泡排序
	 * 
	 * @param starList
	 *            待排序的泡泡糖列表
	 */
	/************ PRJ-BU2-JAVA-010 Task2 【2/3 start】***************/

	public static void sort(StarList starList) {
	    for (int i = 0; i < starList.size() - 1; i++) {
	        for (int j = 0; j < starList.size() - i - 1; j++) {
	            Star preStar = starList.get(j);
	            Star nextStar = starList.get(j + 1);
	            if (preStar.getPosition().getRow() > nextStar.getPosition().getRow()) {
	                swap(preStar, nextStar);
	            }
	        }
	    }
	}
	
	
	
	
	
	
	/************ PRJ-BU2-JAVA-010 Task2 【2/3 end】*****************/
	
	/**
	 * 交换两个泡泡糖在列表中的位置
	 * 
	 * @param preStar
	 *            第N个泡泡糖
	 * @param nextStar
	 *            第N+1个泡泡糖
	 */
	/************ PRJ-BU2-JAVA-010 Task1 【1/3 start】***************/
	private static void swap(Star preStar, Star nextStar){
	    /*Star tempStar = preStar;
	    preStar = nextStar;
	    nextStar = tempStar;*/

	    Star starTemp = new Star();
	    starTemp.setPosition(new Position(preStar.getPosition().getRow(), preStar.getPosition().getColumn()));
	    starTemp.setType(preStar.getType());
	    preStar.setPosition(new Position(nextStar.getPosition().getRow(), nextStar.getPosition().getColumn()));
	    preStar.setType(nextStar.getType());
	    nextStar.setPosition(new Position(starTemp.getPosition().getRow(), starTemp.getPosition().getColumn()));
	    nextStar.setType(starTemp.getType());
	}


	
	
	
	
	
	
	
	/************ PRJ-BU2-JAVA-010 Task1 【1/3 end】*****************/

	/**
	 * 克隆一个新的泡泡糖。
	 * 
	 * @param star
	 *            待克隆的泡泡糖
	 * @return 新的泡泡糖（独立内存地址的泡泡糖）。
	 */
	public static Star copy(Star star) {

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
		
		public static void main(String[] a) {
		   Star preStar = new Star(new Position(0, 0), StarType.BLUE);
		    Star nextStar = new Star(new Position(1, 1), StarType.GREEN);
		    System.out.println(preStar);
		    System.out.println(nextStar);
		    StarsUtil.swap(preStar, nextStar);
		    System.out.println(preStar);
		    System.out.println(nextStar);

		    /*StarList starList = new StarList();
		    starList.add(new Star(new Position(2, 0), StarType.BLUE));
		    starList.add(new Star(new Position(5, 0), StarType.GREEN));
		    starList.add(new Star(new Position(9, 0), StarType.PURPLE));
		    starList.add(new Star(new Position(3, 0), StarType.RED));
		    starList.add(new Star(new Position(8, 0), StarType.YELLOW));
		    System.out.println(starList);
		    StarsUtil.sort(starList);
		    System.out.println(starList);*/
		
	}
}
