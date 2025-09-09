package cn.campsg.practical.bubble.util;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;

/**
 * ������/���ƶ�������ʵ���๤���࣬�ṩ���¹��ܣ�<br>
 * <ul>
 * <li>1. ����ָ���б��е�������-����������������ͬ������������ð�������㷨����</li>
 * <li>2. ��ָ���б��е������ǰ��з��顣</li>
 * <li>3. ��¡һ�������Ƕ���</li>
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
	 * ��¡һ���µ������ǡ�
	 * 
	 * @param star
	 *            ����¡��������
	 * @return �µ������ǣ������ڴ��ַ�������ǣ���
	 */
	/******************** PRJ-BU2-JAVA-004 Task1 ********************/

	public static Star clone(Star star){
		Star ret = new Star();
		ret.setPosition(new Position(star.getPosition().getRow(),star.getPosition().getColumn()));
		ret.setType(star.getType());
		return ret;
	}
	
	public static void main(String[] args){
		Star s1 = new Star(new Position(5,5),StarType.RED);
		Star s2 = StarsUtil.clone(s1);
		System.out.println("ԭ�����Ƕ���Ϊ��"+s1);
		System.out.println("��¡�����Ƕ���Ϊ��"+s2);
		System.out.println("�������Ƿ�һ�£�"+s1.equals(s2) );
		System.out.println("���������������Ƿ�һ�£�"+s1.getPosition().equals(s2.getPosition()));
		
	}


	
	
	
	
	
	
	
	
	/**************************************************************/
}
