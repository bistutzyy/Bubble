package cn.campsg.practical.bubble.entity;


public class MovedStar extends Star {
	private Position movedPosition;

	public MovedStar(Position position,StarType type,Position movedPosition) {
		super(new Position(position.getRow(),position.getColumn()),type);
		this.movedPosition = movedPosition;
	}

	public MovedStar() {
		super();
	}

	public Position getMovedPosition() {
		return movedPosition;
	}

	public void setMovedPosition(Position movedPosition) {
		this.movedPosition = movedPosition;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString()+"\nnew"+ movedPosition.toString();
	}
	
	public static void main(String[] a) {
		MovedStar movedStar = new MovedStar();
		movedStar.setPosition(new Position(0,0));
		movedStar.setMovedPosition(new Position(1,1));
		movedStar.setType(StarType.BLUE);
		System.out.println(movedStar.toString());
	}
	

	
	
	

	}

