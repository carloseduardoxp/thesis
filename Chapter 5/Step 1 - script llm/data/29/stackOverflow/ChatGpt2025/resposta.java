import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Memo extends JApplet {

    //...   

    @Override
    public void init() {
        //...   
        try {
            SwingUtilities.invokeAndWait(() -> createGUI());
        } 
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        final Model model = new Model();
        final View view = new View(model);

        getContentPane().add(view, BorderLayout.CENTER);
        setBackground(backgroundColor);
        setPreferredSize(new Dimension(width, height));

        model.setLoading(loadImages(loadingPath, format, 1));
        model.setCardsImages(loadImages(cardImagePath, format, 13));
        //...
        model.setAppState(AppStates.PROCESS);

        model.startNewGame();
        view.repaint();
    }

    private Image[] loadImages(String path1, String path2, int count) {
        Image[] imgs = new Image[count];        
        for(int i = 0; i < count; ++i) {
            imgs[i] = getImage(getCodeBase(), path1 + i + path2);
        }
        return imgs;
    }
}

class Model {

    //...

    private AppStates appState;
    private Image[] cardsImages;

    public Model() {
        //...
        appState = AppStates.INIT;
    }

    public void startNewGame() {
        setAppState(AppStates.PROCESS);

        //... - init board - table with images' id

        setAppState(AppStates.WAIT_FOR_START);
    }

    public void setCardsImages(Image[] cardsImages) {
        this.cardsImages = cardsImages;
    }

    public Image getCardsImage(int v) {
        return cardsImages[v];
    }

    public AppStates getAppState() {
        return appState;
    }

    public void setAppState(AppStates appState) {
        this.appState = appState;
        //...
    }

    //...
}

class View extends JPanel {

    //...

    private Model model;

    public View(Model model) {
        this.model = model;
        //...
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if(model != null) {
            AppStates state = model.getAppState();
            if (state == AppStates.WAIT_FOR_START || state == AppStates.READY) {
                //...
                drawBoard(g2d, model.getBoard(), model.getStates());
            }
        }
        repaint();
    }

    private void drawBoard(Graphics2D g2d, int[][] board, int[][] states) {
        if(board != null && states != null && board.length > 0 && states.length > 0) {
            for(int x = 0; x < board.length; x++) {
                for(int y = 0; y < board[x].length; y++) {  
                    if(states[x][y] != Model.HIDE) {
                        Image img = null;

                        //...
                        img = model.getCardsImage(board[x][y]);

                        g2d.drawImage(
                            img,
                            model.getFirstCardX() + x * model.getCardDistance() + x * model.getCardWidth(), 
                            model.getFirstCardY() + y * model.getCardDistance() + y * model.getCardHeight(), 
                            model.getCardWidth(), 
                            model.getCardHeight(),
                            this);

                        //...
                    }
                }
            }
        }
    }
}
