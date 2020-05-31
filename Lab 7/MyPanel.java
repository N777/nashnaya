import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Polygon;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class MyPanel extends JPanel {
	int arr[][] = null;
	int n = 0,m = 0;
	int px = 20;
	int py = 0;
	int x = 40, y =20;
	int p = 1;
   
    private int figureType = 2;
   
    public void setFigureType(int fType) {
        figureType = fType;
        repaint();
    }
    public void paint(Graphics g) {
        super.paint(g);
        drawFigure(g);
        drawHero(g);
       
    }
   
    public void load(){
    	arr = null;
    	try {
			Scanner sc = new Scanner(new FileReader(new File("C:\\Temp\\input"+ p +".txt")));
			n = sc.nextInt();
			m = sc.nextInt();
			
			arr = new int[n][m];
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			p = 1;
			load();
		}
		
		if((n == 0)||(m == 0)||(arr==null)) {
			System.out.println("Не получилось прочитать из файла");
			return;
		}
    }
    int sx = 1, sy = 1;
    public void moveDown(){
    	if (arr[sy+1][sx] != 0) {
    	y += 20;
    	sy += 1;
    	win();
    	repaint();
    	}
    }
    public void moveUp(){
    	if (arr[sy-1][sx] != 0) {
        	y -= 20;
        	sy -= 1;
        	win();
        	repaint();
        	}
    }
    public void moveLeft(){
    	
    	if (arr[sy][sx-1] != 0) {
        	x -= 20;
        	sx -= 1;
        	win();
        	repaint();
        	};
    }
    public void moveRight(){
    	if (arr[sy][sx+1] != 0) {
        	x += 20;
        	sx += 1;
        	win();
        	repaint();
        	}
    }
    public void win() {
    	if (arr[sx][sy] == 2) {
    		x = 40; y =20;
    		sx = 1; sy = 1;
    		p++;
    		load();
    	}
    }
    
    
    private void drawHero(Graphics g) {
    	Image image = null;
    	try {
			image = ImageIO.read(new File("C:\\Temp\\hero.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, x, y, null);
    }
    
	private void drawFigure(Graphics g) {
		Image image = null;
		px = 20;
		py = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j]  == 0) {
					
					try {
						image = ImageIO.read(new File("C:\\Temp\\wall.jpg"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if(arr[i][j]  == 1) {
					try {
						image = ImageIO.read(new File("C:\\Temp\\floor.jpg"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if(arr[i][j]  == 2) {
					try {
						image = ImageIO.read(new File("C:\\Temp\\Portal.png"));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
 
				} else if(arr[i][j]  == 3) {
					g.setColor(Color.GREEN);
				}
				
				g.fillRect(px, py, 20, 20);
				g.drawImage(image, px, py, null);
				px += 20;
			}
			py += 20;
			px = 20;
		}
		
		
	
	}


}
 
 