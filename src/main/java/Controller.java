class Controller {
    private final Model model;
    private final View  view;

    Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
    }

    void execute(final int count) {
        for (int i = 0; i < count; i++) {
            view.display(model.getPoints());
            model.advance();
        }
    }

    public static void main(final String[] args) {
        final int size = 50;
        final Model model = new Model(size, size);
        final View view = new View(size, size);
        final Controller controller = new Controller(model, view);

        controller.execute(Integer.MAX_VALUE);
    }
}