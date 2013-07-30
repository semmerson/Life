final class Controler {
	public static void main(String[] args) {
        int size = 50;
        Model model = new Model(size, size);
        View view = new View(size, size);
        
        for (;;) {
        	view.display(model.getPoints());
        	model.advance();
        }
	}
}
