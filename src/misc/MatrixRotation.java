package misc;

import java.util.*;

public class MatrixRotation {
	
	
	
	public static List<List<Integer>> matrixRotation(List<List<Integer>> matrix, int r) {
		
		
		for (int p = 0; p< r; p++) {
			
			int minX = 0;
			int maxX = matrix.size() -1;
			int minY = 0;
			int maxY = matrix.get(0).size() -1;
			
			int count = 0, x =0, y = 0;
			
			int currentValue = 0, preValue = -1;
			while ( count < (matrix.size() * matrix.get(0).size())) {
				
				//System.out.print(matrix.get(x).get(y) + " ");
				
				
	//			currentValue = matrix.get(x).get(y);
				if (preValue != -1) {
					currentValue = matrix.get(x).get(y);
					matrix.get(x).set(y, preValue);
					preValue = currentValue;
				} else {
					preValue = matrix.get(x).get(y);
				}
				
				
				
				if (y == minY) {
					if (x < maxX) {
						x = x + 1;
					} else {
						y = y + 1;
					}
				} else if (y == maxY) {
					if (x > minX) {
						x = x - 1;
					} else {
						y = y - 1;
					}
				} else {
					if (x == minX) {
						y = y - 1;
					} else {
						y = y + 1;
					}
				}
				
				if (x == minX && y == minY) {
					matrix.get(x).set(y, currentValue);
					
					minX++;
					minY++;
					maxX--;
					maxY--;
					x = minX;
					y = minY;
				}
				
				
				
				count++;
				
			}
			
			
		
		}
		
		
		return matrix;
		
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		
		List<Integer> list1 = Arrays.asList(1,  2,   3,  4, 41);
		List<Integer> list2 = Arrays.asList(5,  6,   7,  8, 81);
		List<Integer> list3 = Arrays.asList(9,  10, 11, 12, 121);
		List<Integer> list4 = Arrays.asList(13, 14, 15, 16, 161);
		List<Integer> list5 = Arrays.asList(17, 18, 19, 20, 201);
		
		List<List<Integer>> matrix = new ArrayList<List<Integer>>();
		matrix.add(list1);
		matrix.add(list2);
		matrix.add(list3);
		matrix.add(list4);
		matrix.add(list5);
		
		System.out.println("---- Before Rotation----");
		for (int i=0; i<matrix.size(); i++) {
			List<Integer> lst = matrix.get(i);
			for (int j =0; j<lst.size(); j++) {
				System.out.print(lst.get(j) + "\t");
			}
			System.out.println("");
		}
		
		matrix = MatrixRotation.matrixRotation(matrix, 2);
		
		System.out.println("\n---- After Rotation----");
		for (int i=0; i<matrix.size(); i++) {
			List<Integer> lst = matrix.get(i);
			for (int j =0; j<lst.size(); j++) {
				System.out.print(lst.get(j) + "\t");
			}
			System.out.println("");
		}

		
	}
	
	
	

}
