package proxyPattern;

//Subject interface
interface Media {
	void show();
}

//RealSubject class
class Image implements Media {
	private String filename;

	public Image(String filename) {
		this.filename = filename;
		loadFromDisk();
	}

	private void loadFromDisk() {
		System.out.println("Loading image: " + filename);
	}

	@Override
	public void show() {
		System.out.println("Displaying media: " + filename);
	}
}

//Proxy class
class ProxyMedia implements Media {
	private Image realImage;
	private String filename;

	public ProxyMedia(String filename) {
		this.filename = filename;
	}

	@Override
	public void show() {
		if (realImage == null) {
			realImage = new Image(filename);
		}
		realImage.show();
	}
}

public class Main {
	public static void main(String[] args) {
		Media media1 = new ProxyMedia("image1.jpg");
		Media media2 = new ProxyMedia("image2.jpg");

		// The actual image is only loaded and displayed when "show" is called
		media1.show(); // Output: Loading image: image1.jpg / Displaying media: image1.jpg
		media1.show(); // Output: Displaying media: image1.jpg (No additional loading)

		media2.show(); // Output: Loading image: image2.jpg / Displaying media: image2.jpg
	}
}