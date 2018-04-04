import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
	boolean[] visited ;
	String[] arr;
	int max;
	int F,S,G,U,D;
	public Main() {
		// TODO Auto-generated constructor stub
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt();
		S = sc.nextInt();
		G = sc.nextInt();
		U = sc.nextInt();
		D = sc.nextInt();
		
		arr = new String[F+1];
		visited = new boolean[F+1];
		
		Queue<Point> q = new LinkedList<Point>();
		visited[S] = true;
		Point s = new Point(S,0);
		
		q.offer(s);
		aaa: while(!q.isEmpty()){
			Point oldPoint = q.poll();
			int[] move = {U,-D};
			for(int i=0;i<2;i++){
				int nx = oldPoint.getPos()+move[i];
				if(nx>F) continue;
				if(nx<1) continue;
				if(visited[nx] == true) continue;
				else{
					if(nx==G){
						visited[nx] = true;
						max = oldPoint.getCount()+1;
						break aaa;
					}else{
						visited[nx] = true;
						Point newPoint = new Point(nx,oldPoint.getCount()+1);
						q.offer(newPoint);
					}
				}
			}
		}

		if(visited[G] == true) System.out.println(max);
		else System.out.println("use the stairs");
	}
	
	class Point{
		int pos;
		int count;
		
		public int getPos() {
			return pos;
		}
		public void setPos(int pos) {
			this.pos = pos;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public Point(int pos, int count) {
			this.pos = pos;
			this.count = count;
		}
	}
	public static void main(String[] args) {
		new Main();
	}
}
