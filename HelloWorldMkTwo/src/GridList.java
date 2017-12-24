import java.awt.List;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

//Thomas Varano
//[Program Descripion]
//May 24, 2017

public class GridList<E> extends AbstractCollection<E>
{
   private static final long serialVersionUID = 7371829973935199600L;
   private int size, length;
   private ArrayList<ArrayList<E>> map;
   
   public GridList(int rows, int columns){
      this.size = rows*columns;
      this.length = rows;
   }
   public GridList(){
      this(1,0);
   }
   
   public boolean add(E e) {
      add(length, get(length).size(), e);
      return true;
   }
   
   public void add(int row, E e){
      map.get(row).add(e);
      size++;
   }
   
   public void add (int row, int column, E e){
      map.get(row).add(column, e);
      size++;
   }
   //TODO if empty list, add to size?
   // also streamline this its disgusting
   public void addRow(int index){
      map.add(index, new ArrayList<E>());
      length++;
      size++;
   }
   public void addRow(){
      map.add(new ArrayList<E>());
      length++;
      size++;
   }
   public void addRow(int index, ArrayList<E> list){
      map.add(index, list);
      length++;
      size++;
   }
   public void addRow(ArrayList<E> list){
      map.add(list);
      length++;
      size++;
   }
   public void addColumn(int index){
      for (int r = 0; r < map.size(); r++) {
         if (index > map.get(r).size())
            map.get(r).add(null);
      }
      size += length;
   }
   public void addColumn(){
      for (int r = 0; r < map.size(); r++) {
         map.get(r).add(null);
      }
      size += length;
   }
   public void remove(int row, int column){
      map.get(row).remove(column);
      size--;
   }
   public void setNull(int row, int column){ 
      map.get(row).set(column, null);
   }
   public void removeColumn(int column){
      for (int r = 0; r < map.size(); r++)
         if (column <= map.get(r).size()){
            map.get(r).remove(column);
            size--;
         }
   }
   public void removeRow(int index){
      size -= map.get(index).size();
      map.remove(index);
   }

   public E get(int row, int column) {
      return map.get(row).get(column);
   }
   public ArrayList<E> get(int index) {
      return map.get(index);
   }

   public int size() {
      return size;
   }
   public int length(){
      return length;
   }
   public int indexOf(Object o){
      if (o == null) {
         for (int i = 0; i < size; i++)
            if (map.get(i)==null)
                return i;
    } else {
        for (int i = 0; i < size; i++)
            if (o.equals(map.get(i)))
                return i;
    }
    return -1;
   }
   public int lastIndexOf(Object o) {
      if (o == null) {
          for (int i = size-1; i >= 0; i--)
              if (map.get(i)==null)
                  return i;
      } else {
          for (int i = size-1; i >= 0; i--)
              if (o.equals(map.get(i)))
                  return i;
      }
      return -1;
   }
   public void removeAll(){
      map.removeAll(map);
      size = 0; 
      length = 1;
   }
   public void clear(){
      for (int r = 0; r < map.size(); r++)
         for (int c = 0; c < map.get(r).size(); c++)
            map.get(r).set(c, null);
   }
   public Object[] toArray(int row) {
      return map.get(row).toArray();
   }
   public Object[][] toArray(){
      Object[][] retval = new Object[map.size()][];
      for (int i = 0; i < map.size(); i++){
         retval[i] = map.get(i).toArray();
      }
      return retval;
   }
   public boolean isEmpty(){
      return size == 0;
   }
   public boolean contains(Object o){
      return (indexOf(o)!=-1);
   }
   @Override
   public Iterator<E> iterator() {
      return null;
   }
}