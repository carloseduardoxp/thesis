
import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyRobot {

    Robot MYROBOT;
    Color SCREEN[][];
    int SCREEN_X;
    int SCREEN_Y;
    int WINDOW_X;
    int WINDOW_Y;
    int TYPE_DELAY = 0;
    int MOUSE_DELAY = 0;
    int SKILL = 0;
    int X, Y;
    int lastX, lastY;
    int savedX, savedY;
    int RED, GREEN, BLUE;
    Color PIX_CLOSE_ACTIVE_OFF_MOUSE;
    Color PIX_CLOSE_ACTIVE_ON_MOUSE;
    HashMap<Character, Integer> KEYMAP;
    ArrayList<Integer> randKeys;
    GraphicsEnvironment grEnv;
    GraphicsDevice grDevice;
    JPanel drawPanel;
    BufferedImage bufImg;
    Rectangle rect;

    public static void main(String[] args) {
        new MyRobot().go();
    }

    void go() {
        initialize();
        gotoxy(100, 100);
    }

    void initialize() {
        grEnv = GraphicsEnvironment.getLocalGraphicsEnvironment();
        grDevice = grEnv.getDefaultScreenDevice();
        updateScreenInfo();
        setKeyMap();
        try {
            MYROBOT = new Robot();
        } catch (Exception e) {
            JOptionPane.showOptionDialog(null, "Can't build the robot!", "Error", -1, 1, null, null, this);
            System.exit(1);
        }
        X = SCREEN_X / 2;
        Y = SCREEN_Y / 2;
        //MYROBOT.mouseMove(X, Y);
        PIX_CLOSE_ACTIVE_OFF_MOUSE = new Color(184, 67, 44);
        PIX_CLOSE_ACTIVE_ON_MOUSE = new Color(210, 35, 2);
    }

    void updateScreenInfo() {
        SCREEN_X = grDevice.getDisplayMode().getWidth();
        SCREEN_Y = grDevice.getDisplayMode().getHeight();
        WINDOW_X = grEnv.getMaximumWindowBounds().width;
        WINDOW_Y = grEnv.getMaximumWindowBounds().height;
    }

    void setKeyMap() {
        KEYMAP = new HashMap<Character, Integer>();
        KEYMAP.put('q', 81);
        KEYMAP.put('w', 87);
        KEYMAP.put('e', 69);
        KEYMAP.put('r', 82);
        KEYMAP.put('t', 84);
        KEYMAP.put('y', 89);
        KEYMAP.put('u', 85);
        KEYMAP.put('i', 73);
        KEYMAP.put('o', 79);
        KEYMAP.put('p', 80);
        KEYMAP.put('a', 65);
        KEYMAP.put('s', 83);
        KEYMAP.put('d', 68);
        KEYMAP.put('f', 70);
        KEYMAP.put('g', 71);
        KEYMAP.put('h', 72);
        KEYMAP.put('j', 74);
        KEYMAP.put('k', 75);
        KEYMAP.put('l', 76);
        KEYMAP.put('z', 90);
        KEYMAP.put('x', 88);
        KEYMAP.put('c', 67);
        KEYMAP.put('v', 86);
        KEYMAP.put('b', 66);
        KEYMAP.put('n', 78);
        KEYMAP.put('m', 77);
        KEYMAP.put('1', 49);
        KEYMAP.put('2', 50);
        KEYMAP.put('3', 51);
        KEYMAP.put('4', 52);
        KEYMAP.put('5', 53);
        KEYMAP.put('6', 54);
        KEYMAP.put('7', 55);
        KEYMAP.put('8', 56);
        KEYMAP.put('9', 57);
        KEYMAP.put('0', 48);
        KEYMAP.put(' ', 32);

        randKeys = new ArrayList<Integer>();
        for (int j = 44; j < 94; j++) {
            randKeys.add(j);
        }
        randKeys.remove(randKeys.indexOf(58));
        randKeys.remove(randKeys.indexOf(60));
        randKeys.remove(randKeys.indexOf(62));
        randKeys.remove(randKeys.indexOf(63));
        randKeys.remove(randKeys.indexOf(64));
    }

    void typeHuman(String letters) {
        MYROBOT.setAutoDelay(TYPE_DELAY);
        char[] letter = letters.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            System.out.print(letter[i]);
            try {
                if ((int) (Math.random() * SKILL) == (int) (Math.random() * SKILL) / 2) {
                    int limit = (int) ((Math.random() * 3) + 1);
                    for (int j = 0; j < limit; j++) {
                        int k = (int) (Math.random() * (randKeys.size() - 1));
                        manuPress(randKeys.get(k));
                    }
                    sleep(200);
                    for (int j = 0; j < limit; j++) {
                        backspace();
                    }
                }
                if ((Character.isLowerCase(letter[i])) || (Character.isDigit(letter[i]))) {
                    MYROBOT.keyPress(KEYMAP.get(letter[i]));
                    MYROBOT.keyRelease(KEYMAP.get(letter[i]));
                } else {
                    letter[i] = Character.toLowerCase(letter[i]);
                    MYROBOT.keyPress(16);
                    MYROBOT.keyPress(KEYMAP.get(letter[i]));
                    MYROBOT.keyRelease(KEYMAP.get(letter[i]));
                    MYROBOT.keyRelease(16);
                }
            } catch (Exception e) {
                switch (letter[i]) {
                    case '!': {
                        manuPressSHIFTED(49);
                        break;
                    }
                    case '@': {
                        manuPressSHIFTED(50);
                        break;
                    }
                    case '#': {
                        manuPressSHIFTED(51);
                        break;
                    }
                    case '$': {
                        manuPressSHIFTED(52);
                        break;
                    }
                    case '%': {
                        manuPressSHIFTED(53);
                        break;
                    }
                    case '^': {
                        manuPressSHIFTED(54);
                        break;
                    }
                    case '&': {
                        manuPressSHIFTED(55);
                        break;
                    }
                    case '*': {
                        manuPressSHIFTED(56);
                        break;
                    }
                    case '(': {
                        manuPressSHIFTED(57);
                        break;
                    }
                    case ')': {
                        manuPressSHIFTED(48);
                        break;
                    }
                    case '?': {
                        manuPressSHIFTED(47);
                        break;
                    }
                    case '/': {
                        manuPress(47);
                        break;
                    }
                    case ':': {
                        manuPressSHIFTED(59);
                        break;
                    }
                    case ';': {
                        manuPress(59);
                        break;
                    }
                    case '.': {
                        manuPress(46);
                        break;
                    }
                    case ',': {
                        manuPress(44);
                        break;
                    }
                    case '"': {
                        manuPressSHIFTED(222);
                        break;
                    }
                    case '\'': {
                        manuPress(222);
                        break;
                    }
                    case '[': {
                        manuPress(91);
                        break;
                    }
                    case ']': {
                        manuPress(93);
                        break;
                    }
                    case '{': {
                        manuPressSHIFTED(91);
                        break;
                    }
                    case '}': {
                        manuPressSHIFTED(93);
                        break;
                    }
                    case '\\': {
                        manuPress(92);
                        break;
                    }
                    case '|': {
                        manuPressSHIFTED(92);
                        break;
                    }
                    case '=': {
                        manuPressSHIFTED(61);
                        break;
                    }
                    case '+': {
                        manuPressSHIFTED(61);
                        break;
                    }
                    case '-': {
                        manuPress(45);
                        break;
                    }
                    case '_': {
                        manuPressSHIFTED(45);
                        break;
                    }
                    case '`': {
                        manuPress(192);
                        break;
                    }
                    case '~': {
                        manuPressSHIFTED(192);
                        break;
                    }
                    case '<': {
                        manuPressSHIFTED(44);
                        break;
                    }
                    case '>': {
                        manuPressSHIFTED(46);
                        break;
                    }

                }
            }

        }
        System.out.println("");
    }

    void type(String letters) {
        MYROBOT.setAutoDelay(TYPE_DELAY);
        char[] letter = letters.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            System.out.print(letter[i]);
            try {
                if ((Character.isLowerCase(letter[i])) || (Character.isDigit(letter[i]))) {
                    MYROBOT.keyPress(KEYMAP.get(letter[i]));
                    MYROBOT.keyRelease(KEYMAP.get(letter[i]));
                } else {
                    letter[i] = Character.toLowerCase(letter[i]);
                    MYROBOT.keyPress(16);
                    MYROBOT.keyPress(KEYMAP.get(letter[i]));
                    MYROBOT.keyRelease(KEYMAP.get(letter[i]));
                    MYROBOT.keyRelease(16);
                }
            } catch (Exception e) {
                switch (letter[i]) {
                    case '!': {
                        manuPressSHIFTED(49);
                        break;
                    }
                    case '@': {
                        manuPressSHIFTED(50);
                        break;
                    }
                    case '#': {
                        manuPressSHIFTED(51);
                        break;
                    }
                    case '$': {
                        manuPressSHIFTED(52);
                        break;
                    }
                    case '%': {
                        manuPressSHIFTED(53);
                        break;
                    }
                    case '^': {
                        manuPressSHIFTED(54);
                        break;
                    }
                    case '&': {
                        manuPressSHIFTED(55);
                        break;
                    }
                    case '*': {
                        manuPressSHIFTED(56);
                        break;
                    }
                    case '(': {
                        manuPressSHIFTED(57);
                        break;
                    }
                    case ')': {
                        manuPressSHIFTED(48);
                        break;
                    }
                    case '?': {
                        manuPressSHIFTED(47);
                        break;
                    }
                    case '/': {
                        manuPress(47);
                        break;
                    }
                    case ':': {
                        manuPressSHIFTED(59);
                        break;
                    }
                    case ';': {
                        manuPress(59);
                        break;
                    }
                    case '.': {
                        manuPress(46);
                        break;
                    }
                    case ',': {
                        manuPress(44);
                        break;
                    }
                    case '"': {
                        manuPressSHIFTED(222);
                        break;
                    }
                    case '\'': {
                        manuPress(222);
                        break;
                    }
                    case '[': {
                        manuPress(91);
                        break;
                    }
                    case ']': {
                        manuPress(93);
                        break;
                    }
                    case '{': {
                        manuPressSHIFTED(91);
                        break;
                    }
                    case '}': {
                        manuPressSHIFTED(93);
                        break;
                    }
                    case '\\': {
                        manuPress(92);
                        break;
                    }
                    case '|': {
                        manuPressSHIFTED(92);
                        break;
                    }
                    case '=': {
                        manuPressSHIFTED(61);
                        break;
                    }
                    case '+': {
                        manuPressSHIFTED(61);
                        break;
                    }
                    case '-': {
                        manuPress(45);
                        break;
                    }
                    case '_': {
                        manuPressSHIFTED(45);
                        break;
                    }
                    case '`': {
                        manuPress(192);
                        break;
                    }
                    case '~': {
                        manuPressSHIFTED(192);
                        break;
                    }
                    case '<': {
                        manuPressSHIFTED(44);
                        break;
                    }
                    case '>': {
                        manuPressSHIFTED(46);
                        break;
                    }

                }
            }

        }
        System.out.println("");
    }

    void typeln(String letters) {
        type(letters);
        enter();
    }

    void typelnHuman(String letters) {
        typeHuman(letters);
        enter();
    }

    void getRun() {
        MYROBOT.keyPress(524);
        MYROBOT.keyPress(82);
        MYROBOT.keyRelease(82);
        MYROBOT.keyRelease(524);
        sleep(500);
    }

    void combinePress(int keyOne, int keyTwo) {
        MYROBOT.keyPress(keyOne);
        MYROBOT.keyPress(keyTwo);
        MYROBOT.keyRelease(keyTwo);
        MYROBOT.keyRelease(keyOne);
    }

    void combinePress(int keyOne, int keyTwo, int keyThree) {
        MYROBOT.keyPress(keyOne);
        MYROBOT.keyPress(keyTwo);
        MYROBOT.keyPress(keyThree);
        MYROBOT.keyRelease(keyThree);
        MYROBOT.keyRelease(keyTwo);
        MYROBOT.keyRelease(keyOne);
    }

    void altTab() {
        MYROBOT.keyPress(18);
        MYROBOT.keyPress(9);
        MYROBOT.keyRelease(9);
        MYROBOT.keyRelease(18);
    }

    void winD() {
        MYROBOT.keyPress(524);
        MYROBOT.keyPress(68);
        MYROBOT.keyRelease(68);
        MYROBOT.keyRelease(524);
    }

    void altF4() {
        MYROBOT.keyPress(18);
        MYROBOT.keyPress(115);
        MYROBOT.keyRelease(115);
        MYROBOT.keyRelease(18);
    }

    void enter() {
        MYROBOT.keyPress(10);
        MYROBOT.keyRelease(10);
    }

    void backspace() {
        MYROBOT.keyPress(8);
        MYROBOT.keyRelease(8);
    }

    void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
        }
    }

    void click() {
        MYROBOT.mousePress(16);
        MYROBOT.mouseRelease(16);
    }

    void doubleClick() {
        click();
        click();
    }

    void clickNhold(boolean tof) {
        if (tof) {
            MYROBOT.mousePress(16);
        } else {
            MYROBOT.mouseRelease(16);
        }
    }

    void rightClick() {
        MYROBOT.mousePress(4);
        MYROBOT.mouseRelease(4);
    }

    void rightclickHold(boolean tof) {
        if (tof) {
            MYROBOT.mousePress(4);
        } else {
            MYROBOT.mouseRelease(4);
        }
    }

    void middleClick() {
        MYROBOT.mousePress(8);
        MYROBOT.mouseRelease(8);
    }

    void manuPress(int code) {
        MYROBOT.keyRelease(16);
        MYROBOT.keyPress(code);
        MYROBOT.keyRelease(code);
    }

    void manuPressSHIFTED(int code) {
        MYROBOT.keyPress(16);
        MYROBOT.keyPress(code);
        MYROBOT.keyRelease(code);
        MYROBOT.keyRelease(16);
    }

    void gotoxy(int goX, int goY) {
        lastX = X;
        lastY = Y;
        MYROBOT.setAutoDelay(MOUSE_DELAY);
        int initX = X;
        int initY = Y;
        if (goX == X) {
            if (goY > Y) {
                for (int i = Y; i <= goY; i++) {
                    Y = i;
                    MYROBOT.mouseMove(X, Y);
                }
            } else {
                for (int i = Y; i >= goY; i--) {
                    Y = i;
                    MYROBOT.mouseMove(X, Y);
                }
            }
        } else if (goX > X) {
            for (int i = 0; i <= (goX - initX); i++) {
                X = initX + i;
                Y = initY + ((i * (goY - initY)) / (goX - initX));
                MYROBOT.mouseMove(X, Y);
            }

        } else {
            for (int i = 0; i >= (goX - initX); i--) {
                X = initX + i;
                Y = initY + ((i * (goY - initY)) / (goX - initX));
                MYROBOT.mouseMove(X, Y);
            }
        }
    }

    void getRGB(Color pixel) {
        RED = pixel.getRed();
        GREEN = pixel.getGreen();
        BLUE = pixel.getBlue();
        System.out.println(RED + "," + GREEN + "," + BLUE);
    }

    void savePoint() {
        savedX = X;
        savedY = Y;
    }

    void captureScreen() {
        System.out.println("Capturing...");
        SCREEN = new Color[SCREEN_X][SCREEN_Y];
        for (int i = 0; i < SCREEN_X; i++) {
            for (int j = 0; j < SCREEN_Y / 2; j++) {
                SCREEN[i][j] = MYROBOT.getPixelColor(i, j);
            }
        }
        System.out.println("Capturing done");
    }

    void gotoPixel(Color pixel) {
        if (MYROBOT.getPixelColor(X, Y).getRGB() != pixel.getRGB()) {
            for (int i = SCREEN_X - 4; i >= 0; i--) {
                for (int j = 3; j < SCREEN_Y / 2; j++) {
                    if ((MYROBOT.getPixelColor(i, j).getRGB() == pixel.getRGB())) {
                        gotoxy(i, j);
                        i = -1;
                        break;
                    }
                }
            }
        }
        if (MYROBOT.getPixelColor(X, Y).getRGB() == pixel.getRGB()) {
            while (MYROBOT.getPixelColor(X, Y).getRGB() == pixel.getRGB()) {
                gotoxy((X - 1), Y);
            }
        }
    }

    void emergeFromPixel(Color pixel) {
        if (MYROBOT.getPixelColor(X, Y).getRGB() != pixel.getRGB()) {
            for (int i = SCREEN_X - 4; i >= 0; i--) {
                for (int j = 3; j < SCREEN_Y / 2; j++) {
                    if ((MYROBOT.getPixelColor(i, j).getRGB() == pixel.getRGB())) {
                        MYROBOT.mouseMove(i, j);
                        X = i;
                        Y = j;
                        i = -1;
                        break;
                    }
                }
            }
        }
    }

    void shift(char dir) {
        int initX = X;
        Color initPixel;
        dir = Character.toUpperCase(dir);
        switch (dir) {
            case 'L': {
                gotoxy((X - 8), Y);
                initPixel = MYROBOT.getPixelColor(X, Y);
                while (MYROBOT.getPixelColor(X, Y).getRGB() == initPixel.getRGB()) {
                    gotoxy((X - 1), Y);
                }
                initX = X;
                for (int i = initX; i > initX - 20; i--) {
                    if (MYROBOT.getPixelColor(i, Y).getRGB() == initPixel.getRGB()) {
                        gotoxy(i, Y);
                        while (MYROBOT.getPixelColor(X, Y).getRGB() == initPixel.getRGB()) {
                            gotoxy((X - 1), Y);
                        }
                        break;
                    }
                }
                break;
            }
            case 'R': {
                initPixel = MYROBOT.getPixelColor(X, Y);
                while (MYROBOT.getPixelColor(X, Y).getRGB() == initPixel.getRGB()) {
                    gotoxy((X + 1), Y);
                }
                initX = X;
                for (int i = initX; i < initX + 20; i++) {
                    if (MYROBOT.getPixelColor(i, Y).getRGB() == initPixel.getRGB()) {
                        gotoxy(i, Y);
                        while (MYROBOT.getPixelColor(X, Y).getRGB() == initPixel.getRGB()) {
                            gotoxy((X + 1), Y);
                        }
                        break;
                    }
                }
                gotoxy((X + 8), Y);
                break;
            }
        }
    }

    void emergeFromButton(String butName) {
        int tempDelay = TYPE_DELAY;
        TYPE_DELAY = 0;
        MYROBOT.setAutoDelay(TYPE_DELAY);
        butName = butName.toUpperCase();
        if (butName.equals("CLOSE")) {
            emergeFromPixel(PIX_CLOSE_ACTIVE_OFF_MOUSE);
        } else if (butName.equals("MAXIMIZE")) {
            emergeFromPixel(PIX_CLOSE_ACTIVE_OFF_MOUSE);
            shift('L');
        } else if (butName.equals("MINIMIZE")) {
            emergeFromPixel(PIX_CLOSE_ACTIVE_OFF_MOUSE);
            shift('L');
            shift('L');
        } else if (butName.equals("START")) {
            MYROBOT.mouseMove(20, SCREEN_Y - 10);
        }
        TYPE_DELAY = tempDelay;
        MYROBOT.setAutoDelay(TYPE_DELAY);
    }

    void gotoButton(String butName) {
        butName = butName.toUpperCase();
        if (butName.equals("CLOSE")) {
            if (MYROBOT.getPixelColor(X, Y).getRGB() != PIX_CLOSE_ACTIVE_ON_MOUSE.getRGB()) {
                gotoPixel(PIX_CLOSE_ACTIVE_OFF_MOUSE);
            }
        } else if (butName.equals("MAXIMIZE")) {
            gotoPixel(PIX_CLOSE_ACTIVE_OFF_MOUSE);
            shift('L');
        } else if (butName.equals("MINIMIZE")) {
            gotoPixel(PIX_CLOSE_ACTIVE_OFF_MOUSE);
            shift('L');
            shift('L');
        } else if (butName.equals("START")) {
            gotoxy(20, SCREEN_Y - 10);
        }
    }

    void catchTitleBar() {
        gotoButton("CLOSE");
        gotoxy(X - 150, Y);
    }

    void pressKey(String keyName) {
        keyName = keyName.toUpperCase();
        if (keyName.equals("ESC")) {
            manuPress(27);
        }
    }

    void closeAllWindows() {
        while ((MYROBOT.getPixelColor(65, SCREEN_Y - 35).getRed() > 213) && (MYROBOT.getPixelColor(65, SCREEN_Y - 35).getGreen() > 220) && (MYROBOT.getPixelColor(65, SCREEN_Y - 35).getBlue() > 228)) {
            altTab();
            gotoButton("CLOSE");
            sleep(100);
            click();
            sleep(50);
        }
    }

    void quickCloseAllWindows() {
        while ((MYROBOT.getPixelColor(65, SCREEN_Y - 35).getRed() > 213) && (MYROBOT.getPixelColor(65, SCREEN_Y - 35).getGreen() > 220) && (MYROBOT.getPixelColor(65, SCREEN_Y - 35).getBlue() > 228)) {
            winD();
            sleep(100);
            altTab();
            altF4();
            type("n");
        }
    }

    void getNotepad() {
        int saveDelay = TYPE_DELAY;
        TYPE_DELAY = 0;
        MYROBOT.setAutoDelay(0);
        MYROBOT.keyPress(524);
        MYROBOT.keyPress(82);
        MYROBOT.keyRelease(82);
        MYROBOT.keyRelease(524);
        sleep(200);
        typeln("notepad");
        sleep(500);
        TYPE_DELAY = saveDelay;
        MYROBOT.setAutoDelay(TYPE_DELAY);
    }

    void closeActiveWindow() {
        gotoButton("CLOSE");
        click();
        type("n");
    }

    void openMyComputer() {
        gotoxy(50, 50);
        doubleClick();
    }

    void lockMouse() {
        Thread lockMouse = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    MYROBOT.mouseMove(X, Y);
                    sleep(100);
                }
            }
        });
        lockMouse.start();
    }

}
