package cn.campsg.practical.bubble.entity;

public class Star {
	public enum StarType {
		BLUE(0),GREEN(1),YELLOW(2),RED(3),PURPLE(4);
		
		private int value;
		private StarType(int value) {
			this.value = value;
		}
		public int value() {
			return value;
		}
		
		public static StarType valueOf(int value) {
			switch(value) {
			case 0:
				return BLUE;
			case 1:
				return GREEN;
			case 2:
				return YELLOW;
			case 3:
				return RED;
			case 4:
				return PURPLE;
				default:
					return null;
			}
		}

}
	private Position position;
	private StarType type;
	public Star(Position position, StarType type) {
		super();
		this.position = position;
		this.type = type;
	}
	public Star() {
		type = StarType.BLUE;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public StarType getType() {
		return type;
	}
	public void setType(StarType type) {
		this.type = type;
	}
	
	

	
	
	
	
	}

