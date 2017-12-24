//Thomas Varano
//[Program Descripion]
//May 24, 2017

public class GameBoard
{
   private int rows, columns;
   private Tile[][] map;
   
   public GameBoard(int rows, int columns){
      this.rows = rows;
      this.columns = columns;
      map = new Tile[rows][columns];
   }
   
   public int length(){
      return map.length;
   }
   public void addRow(int index){
      GameBoard tempMap = new GameBoard(rows+1, columns+1);
      for (int r = 0; r < tempMap.length(); r++) {
         if (r > index)
            tempMap.set(r, map[r-1]);
         else if (r != index)
            tempMap.set(r, map[r]);
      }
   }
   public Tile[] set(int row, Tile[] t){
      Tile[] retval = map[row];
      map[row] = t;
      return retval;
   }
   public Tile set(int row, int column, Tile t){
      Tile retval = map[row][column];
      map[row][column] = t;
      return retval;
   }
   public Tile[] get(int row){
      return map[row];
   }
   public Tile getTile(int row, int column){
      return map[row][column];
   }   
   public Tile[][] getMap() {
      return map;
   }
   public void setMap(Tile[][] map) {
      this.map = map;
   }
}
