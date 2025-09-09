package cn.campsg.practical.bubble.service;

import cn.campsg.practical.bubble.entity.Position;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.Star.StarType;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.util.StarsUtil;

/**
 * 
 * ������ҵ���������࣬����Ϊ�����ṩ���·���<br>
 * 1. ������Ļ�������������<br>
 * 2. �й��ж�<br>
 * 3. �������������ݼ���÷�<br>
 * 4. ����ʣ�������ǵĵ÷ֽ���<br>
 * 
 * @author Frank.Chen
 * @version 2.5
 *
 */
public class StarServiceImpl implements StarService {

	/**
	 * ������Ļ������������ǣ�10 * 10��
	 * 
	 * @return �������б�-��������ʾ
	 */
	@Override
	public StarList createStars() {

		StarList stars = new StarList();
		for (int row = 0; row < StarService.MAX_ROW_SIZE; row++) {
			for (int col = 0; col < StarService.MAX_COLUMN_SIZE; col++) {
				Star star = new Star();
				// �����������ڻ����ϵ�λ��
				star.setPosition(new Position(row, col));
				// ���������������
				if(row>=3&&row<=6 && col>=3&&col<=6){
					star.setType(StarType.RED);
				}else{
					star.setType(StarType.YELLOW);
				}
				// �����б�
				stars.add(star);
			}
		}
		return stars;
	}
	
	/**
	 * �Ը��������ǣ��û�����ģ�Ϊ�����������ҡ�����·������Ѱ����ͬ���͵�������
	 * 
	 * @param base
	 *            ���������ǣ��û�����ģ�
	 * @param sList
	 *            ԭʼ�������б����������е������ǣ�
	 * @param clearStars
	 *            ��������������б�
	 */
	private void lookupByPath(Star base, StarList sList, StarList clearStars) {
		int row = base.getPosition().getRow();
        int column = base.getPosition().getColumn();
        StarType type = base.getType();

		/******************** PRJ-BU2-JAVA-004 Task2 ********************/
        //���
        
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
        //�Ҳ�
        
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

        //����
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

        //�ײ�
        while(row <10){
        	row = row +1;
        	Star downstar = sList.lookup(row, column);
        	if (downstar != null && clearStars.existed(downstar)==false && downstar.getType()==base.getType()){
        		clearStars.add(downstar);
        		lookupByPath(downstar,sList,clearStars);
        	}
        } 

		
		
		
		
		
		
		
		
		/**************************************************************/

		// �����ĸ��ж϶����������ʾ���ܶ�û���������ˣ���ô�����ݹ鷽����
	}

	/**
	 * �û���������ǣ���ȡ���������������������б�
	 * 
	 * @param base
	 *            ���û������������
	 * @param sList
	 *            ��ǰ���������ݵ��б�
	 * @return ��Ҫ�����������
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
	 * ���������Ǻ󣬻�ȡ���ƶ��������б�(����ˮƽ�б��������)<br>
	 * �ù��̶ܹ��ڴ�ֱ�б��������֮������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * 
	 * @return ���ƶ��������б�
	 */
	public StarList getHMovedStars(StarList currentStarList) {
		return null;
	}

	/**
	 * �ж��Ƿ񻹴���δ������������
	 * 
	 * @param currentStarList
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return true:��Ȼ��δ������������,false:û��δ������������
	 * 
	 */
	@Override
	public boolean tobeEliminated(StarList currentStarList) {
		return false;
	}

	/**
	 * ��ȡ�޷������������б�
	 * 
	 * @param curretStars
	 *            ��ǰ�����Ľ����������б��Ѿ�����������������null��ʾ��
	 * @return �޷������������б�
	 * */
	public StarList getAwardStarList(StarList curretStars) {
		return null;
	}
}
