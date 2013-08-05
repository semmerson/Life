import net.jcip.annotations.NotThreadSafe;

/**
 * Copyright 2013 University Corporation for Atmospheric Research. All rights
 * reserved. See file LICENSE in the top-level source-directory for licensing
 * information.
 */

/**
 * The "Game of Life" controller.
 * <p>
 * Instances are thread-compatible but not thread-safe.
 * 
 * @author Steven R. Emmerson
 */
@NotThreadSafe
class Controller {
    /**
     * The model.
     */
    private final Model model;
    /**
     * The display view.
     */
    private final View  view;

    /**
     * Constructs an instance from a model and a display view.
     * 
     * @param model
     *            The model.
     * @param view
     *            The display view of the model.
     */
    Controller(final Model model, final View view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Iterates over advancing the model and displaying the results.
     * 
     * @param count
     *            Number of iterations. 0 => no advancement and no display.
     */
    private void iterate(final int count) {
        for (int i = 0; i < count; i++) {
            model.advance();
            view.display(model.getHeartbeat());
        }
    }

    /**
     * Displays the initial state of the model, then iteratively executes the
     * model and displays the results.
     * 
     * @param count
     *            Number of iterations. 0 => no advancement and subsequent
     *            display.
     */
    void execute(final int count) {
        view.display(model.getHeartbeat());
        iterate(count);
    }

    public static void main(final String[] args) {
        final int size = 50;
        final Model model = new Model(size, size);
        final View view = new View(size, size);
        final Controller controller = new Controller(model, view);

        controller.execute(Integer.MAX_VALUE);
    }
}