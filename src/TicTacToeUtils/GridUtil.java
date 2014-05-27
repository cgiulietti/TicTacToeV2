package TicTacToeUtils;

public class GridUtil {

	/* being a utility class, instantiation is not allowed */
	private GridUtil() {
		super();
	}

	
	public static boolean isInBound(int row, int col, int gridSize) {
		return !( row >= gridSize|| row < 0 || col < 0 || col >= gridSize );
	}

	
	public static Coordinates nextMove( int row, int column, Direction direction ){

		switch ( direction ) {
		case UP_LEFT:
			row--;
			column--;
			break;

		case UP_CENTER:
			row--;
			break;

		case UP_RIGHT:
			row--;
			column++;
			break;

		case LEFT:
			column--;
			break;

		case RIGHT:
			column++;
			break;

		case DOWN_LEFT:
			row++;
			column--;
			break;

		case DOWN_CENTER:
			row++;
			break;

		case DOWN_RIGHT:
			row++;
			column++;
			break;

		default:
			break;
		}

		return new Coordinates(row, column);
	}

}
