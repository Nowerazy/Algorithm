package InternetCode;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShowInetPhoto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImageFrame frame = new ImageFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ImageFrame extends JFrame {
	public static final int WIDTH = 1024;
	public static final int HEIGHT = 676;

	public ImageFrame() {
		setTitle("从网络中下载图片");
		setSize(WIDTH, HEIGHT);
		ImagePanel panel = new ImagePanel();
		Container container = getContentPane();
		container.add(panel);
	}
}

class ImagePanel extends JPanel {
	private Image image;
	URL url;

	public ImagePanel() {
		try {
			url = new URL(
					"http://pica.nipic.com/2008-03-19/2008319183523380_2.jpg");
			image = Toolkit.getDefaultToolkit().getImage(url);
			MediaTracker mediaTracker = new MediaTracker(new Container());
			mediaTracker.addImage(image, 0);
			mediaTracker.waitForID(0);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

//	@Override
//    public void paint(Graphics g)
//    {
//        super.paint(g);
//        g.drawImage(image, 0, 0, this);
//        g.drawString("正在下载....", 1030, 700);
//        g.dispose();
//    }
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, 0, 0, null);
		g.drawString("正在下载....", 1030, 700);
	}

}
