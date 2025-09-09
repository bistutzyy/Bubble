package cn.campsg.practical.bubble.entity;


public class MovedStar extends Star {
	//要移动的坐标
			private Position movedPosition;
			public Position getMovedPosition() {
				return movedPosition;
			}
			public void setMovedPosition(Position movedPosition) {
				this.movedPosition = movedPosition;
			}	
		    public MovedStar(Position position,StarType type,Position movedPosition){ 
				super(new Position(position.getRow(),position.getColumn()),type);
				this.movedPosition = movedPosition;
			}
		    public MovedStar(){  	
		    }
		    
		    public String toString() {
				// TODO Auto-generated method stub
				return super.toString()+"\nnew "+getMovedPosition();
			}





		    public static void main(String[] args){
		    	Position position = new Position(0,0);
		    	Position movedPosition = new Position(1,1);
		    	StarType type = StarType.RED; 	
		    	MovedStar movedstar = new MovedStar(position,type,movedPosition);
		    	System.out.println(movedstar.toString());	
		    }

	}

