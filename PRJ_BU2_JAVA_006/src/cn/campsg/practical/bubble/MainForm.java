package cn.campsg.practical.bubble;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import cn.campsg.practical.bubble.entity.Star;
import cn.campsg.practical.bubble.entity.StarList;
import cn.campsg.practical.bubble.service.StarService;
import cn.campsg.practical.bubble.service.StarServiceImpl;
import cn.campsg.practical.bubble.service.StarServiceTester;

/**
 * �����Ǵ����࣬������ʾ���������С����������ǵ���¼��붯��
 * 
 * 
 * @author Frank.Chen
 * @version 1.5
 */
public class MainForm extends Application {
	
	/** �ӷ���˻�ȡ������10*10�������б�  **/
	private StarList mCurretStars = null;
	
	/** ��������ʾ�����ǵ����� **/
	private AnchorPane mStarForm = null;

	public static void show(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		try {
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass()
					.getResource("/res/layout/main_layout.fxml"));

			// �������ּ��뵽��ͼ������
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);

			// ҳ�����ʱ�����¿�ʼ�µ����������ʱ���ʼ��������
			initGameStars(root);

			primaryStage.setTitle("����������-Popstar3");
			primaryStage.setResizable(false);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * ҳ�����ʱ�����¿�ʼ�µ����������ʱ���ʼ��������
	 * 
	 * @param root
	 *            �����ܲ���
	 * 
	 */
	private void initGameStars(AnchorPane root) {

		// ���ش�������ʾ�����ǵ�����
		/** ������: �ṩ **/
		mStarForm = (AnchorPane) root.lookup("#game_pane");

		/******************** PRJ-BU2-JAVA-006 ********************/
		 	
		//StarService service = new StarServiceTester();
		//StarService service = new StarServiceImpl();
		StarService service = this.getStarService();

		mCurretStars = service.createStars();
		for (int i = 0;i<mCurretStars.size();i++){		
			Star star = new Star();
			//�Ӽ����л�ȡstar���󣬲����丳������������star����
			star = mCurretStars.get(i);
			//������������ʾ�ؼ�
			Label starFrame = new Label();
			starFrame.setPrefWidth(48);
			starFrame.setPrefHeight(48);
			//����Label�����IDֵ
			int row = star.getPosition().getRow();
			int col = star.getPosition().getColumn();
			starFrame.setId("s"+col+row);
			starFrame.setUserData(col+";"+row);
			starFrame.setLayoutX(col*48);
			starFrame.setLayoutY(row*48);
			switch(star.getType().value()) {
			case 0:
				starFrame.getStyleClass().add("blue_star");
				break;
			case 1:
				starFrame.getStyleClass().add("green_star");
				break;
			case 2:
				starFrame.getStyleClass().add("yellow_star");
				break;
			case 3:
				starFrame.getStyleClass().add("red_star");
				break;	
			case 4:
				starFrame.getStyleClass().add("purple_star");
				break;	
			}
			mStarForm.getChildren().add(starFrame);			
		}
	

		
	

			


		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/******************************************************/

	}

	/**
	 * ���ڽӿڶ�̬���������Ƿ����࣬��������������bean.conf�����ļ���
	 * 
	 * @return �����Ƿ�����
	 */
	private StarService getStarService() {
		//����JVM�������
		ClassLoader loader = this.getClass().getClassLoader();

		//�������ļ�bean.conf�ж�ȡ�����Ƿ�����[��ȫ��]
		String className = getClassName();

		try {
			//���������Ƿ�����
			Class<?> clazz = loader.loadClass(className);
			//��̬���������������Ƿ������ʵ��
			return (StarService) clazz.newInstance();
		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * �������ļ�bean.conf�ж�ȡ�����Ƿ�����[��ȫ��]
	 * 
	 * @return �����Ƿ�����[��ȫ��]
	 */
	private String getClassName() {
		// ��ȡbean.conf�����ļ�
		BufferedReader br = new BufferedReader(new InputStreamReader(getClass()
				.getClassLoader().getResourceAsStream("bean.conf")));
		
		try {
			//��ȡ��һ������
			String line = br.readLine();
			//���صȺ��Ҳ�������Ƿ�����[��ȫ��]�ַ���
			return line.split("=")[1];
		} catch (IOException e) {
			return "";
		}
	}
}
