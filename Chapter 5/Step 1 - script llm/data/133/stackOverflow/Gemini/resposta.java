import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyRobot {

    private static final String CLOSE_BUTTON = "CLOSE";

    private Robot myRobot;
    private Color[][] screen;
    private int screenX;
    private int screenY;
    private int windowX;
    private int windowY;
    private int typeDelay = 0;
    private int mouseDelay = 0;
    private int skill = 0;
    private int x;
    private int y;
    private int lastX;
    private int lastY;
    private int savedX;
    private int savedY;
    private int red;
    private int green;
    private int blue;
    private Color pixCloseActiveOffMouse;
    private Color pixCloseActiveOnMouse;
    private Map<Character, Integer> keymap;
    private Map<Character, Integer> specialCharKeyMap;
    private Map<Character, Integer> specialCharShiftedKeyMap;
    private ArrayList<Integer> randKeys;
    private final Random random = new Random();
    private GraphicsEnvironment grEnv;
    private GraphicsDevice grDevice;
    private JPanel drawPanel;
    private BufferedImage bufImg;
    private Rectangle rect;

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
            myRobot = new Robot();
        } catch (Exception e) {
            JOptionPane.showOptionDialog(null, "Can't build the robot!", "Error", -1, 1, null, null, this);
            System.exit(1);
        }
        x = screenX / 2;
        y = screenY / 2;
        pixCloseActiveOffMouse = new Color(184, 67, 44);
        pixCloseActiveOnMouse = new Color(210, 35, 2);
    }

    void updateScreenInfo() {
        screenX = grDevice.getDisplayMode().getWidth();
        screenY = grDevice.getDisplayMode().getHeight();
        windowX = grEnv.getMaximumWindowBounds().width;
        windowY = grEnv.getMaximumWindowBounds().height;
    }

    void setKeyMap() {
        keymap = new HashMap<>();
        keymap.put('q', 81);
        keymap.put('w', 87);
        keymap.put('e', 69);
        keymap.put('r', 82);
        keymap.put('t', 84);
        keymap.put('y', 89);
        keymap.put('u', 85);
        keymap.put('i', 73);
        keymap.put('o', 79);
        keymap.put('p', 80);
        keymap.put('a', 65);
        keymap.put('s', 83);
        keymap.put('d', 68);
        keymap.put('f', 70);
        keymap.put('g', 71);
        keymap.put('h', 72);
        keymap.put('j', 74);
        keymap.put('k', 75);
        keymap.put('l', 76);
        keymap.put('z', 90);
        keymap.put('x', 88);
        keymap.put('c', 67);
        keymap.put('v', 86);
        keymap.put('b', 66);
        keymap.put('n', 78);
        keymap.put('m', 77);
        keymap.put('1', 49);
        keymap.put('2', 50);
        keymap.put('3', 51);
        keymap.put('4', 52);
        keymap.put('5', 53);
        keymap.put('6', 54);
        keymap.put('7', 55);
        keymap.put('8', 56);
        keymap.put('9', 57);
        keymap.put('0', 48);
        keymap.put(' ', 32);

        specialCharKeyMap = new HashMap<>();
        specialCharKeyMap.put(';', 59);
        specialCharKeyMap.put('=', 61);
        specialCharKeyMap.put(',', 44);
        specialCharKeyMap.put('-', 45);
        specialCharKeyMap.put('.', 46);
        specialCharKeyMap.put('/', 47);
        specialCharKeyMap.put('`', 192);
        specialCharKeyMap.put('[', 91);
        specialCharKeyMap.put('\\', 92);
        specialCharKeyMap.put(']', 93);
        specialCharKeyMap.put('\'', 222);

        specialCharShiftedKeyMap = new HashMap<>();
        specialCharShiftedKeyMap.put('!', 49);
        specialCharShiftedKeyMap.put('@', 50);
        specialCharShiftedKeyMap.put('#', 51);
        specialCharShiftedKeyMap.put('$', 52);
        specialCharShiftedKeyMap.put('%', 53);
        specialCharShiftedKeyMap.put('^', 54);
        specialCharShiftedKeyMap.put('&', 55);
        specialCharShiftedKeyMap.put('*', 56);
        specialCharShiftedKeyMap.put('(', 57);
        specialCharShiftedKeyMap.put(')', 48);
        specialCharShiftedKeyMap.put('_', 45);
        specialCharShiftedKeyMap.put('+', 61);
        specialCharShiftedKeyMap.put(':', 59);
        specialCharShiftedKeyMap.put('<', 44);
        specialCharShiftedKeyMap.put('>', 46);
        specialCharShiftedKeyMap.put('?', 47);
        specialCharShiftedKeyMap.put('~', 192);
        specialCharShiftedKeyMap.put('{', 91);
        specialCharShiftedKeyMap.put('|', 92);
        specialCharShiftedKeyMap.put('}', 93);
        specialCharShiftedKeyMap.put('"', 222);

        randKeys = new ArrayList<>();
        for (int j = 44; j < 94; j++) {
            randKeys.add(j);
        }
        randKeys.remove(Integer.valueOf(58));
        randKeys.remove(Integer.valueOf(60));
        randKeys.remove(Integer.valueOf(62));
        randKeys.remove(Integer.valueOf(63));
        randKeys.remove(Integer.valueOf(64));
    }

    private void doType(String letters, boolean humanLike) {
        myRobot.setAutoDelay(typeDelay);
        for (char c : letters.toCharArray()) {
            System.out.print(c);
            if (humanLike && skill > 0 && random.nextInt(skill) == random.nextInt(skill) / 2) {
                int limit = random.nextInt(3) + 1;
                for (int j = 0; j < limit; j++) {
                    int k = random.nextInt(randKeys.size());
                    manuPress(randKeys.get(k));
                }
                sleep(200);
                for (int j = 0; j < limit; j++) {
                    backspace();
                }
            }
            typeCharacter(c);
        }
        System.out.println("");
    }

    private void typeCharacter(char c) {
        try {
            if (keymap.containsKey(c)) { // Handles lowercase and digits
                myRobot.keyPress(keymap.get(c));
                myRobot.keyRelease(keymap.get(c));
            } else if (Character.isUpperCase(c)) {
                char lower = Character.toLowerCase(c);
                myRobot.keyPress(16);
                myRobot.keyPress(keymap.get(lower));
                myRobot.keyRelease(keymap.get(lower));
                myRobot.keyRelease(16);
            } else {
                // This will cause a NullPointerException if the char is not in the keymap,
                // which is the original logic to jump to the catch block for symbols.
                myRobot.keyPress(keymap.get(c));
                myRobot.keyRelease(keymap.get(c));
            }
        } catch (Exception e) {
            if (specialCharKeyMap.containsKey(c)) {
                manuPress(specialCharKeyMap.get(c));
            } else if (specialCharShiftedKeyMap.containsKey(c)) {
                manuPressSHIFTED(specialCharShiftedKeyMap.get(c));
            }
        }
    }

    void typeHuman(String letters) {
        doType(letters, true);
    }

    void type(String letters) {
        doType(letters, false);
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
        myRobot.keyPress(524);
        myRobot.keyPress(82);
        myRobot.keyRelease(82);
        myRobot.keyRelease(524);
        sleep(500);
    }

    void combinePress(int keyOne, int keyTwo) {
        myRobot.keyPress(keyOne);
        myRobot.keyPress(keyTwo);
        myRobot.keyRelease(keyTwo);
        myRobot.keyRelease(keyOne);
    }

    void combinePress(int keyOne, int keyTwo, int keyThree) {
        myRobot.keyPress(keyOne);
        myRobot.keyPress(keyTwo);
        myRobot.keyPress(keyThree);
        myRobot.keyRelease(keyThree);
        myRobot.keyRelease(keyTwo);
        myRobot.keyRelease(keyOne);
    }

    void altTab() {
        myRobot.keyPress(18);
        myRobot.keyPress(9);
        myRobot.keyRelease(9);
        myRobot.keyRelease(18);
    }

    void winD() {
        myRobot.keyPress(524);
        myRobot.keyPress(68);
        myRobot.keyRelease(68);
        myRobot.keyRelease(524);
    }

    void altF4() {
        myRobot.keyPress(18);
        myRobot.keyPress(115);
        myRobot.keyRelease(115);
        myRobot.keyRelease(18);
    }

    void enter() {
        myRobot.keyPress(10);
        myRobot.keyRelease(10);
    }

    void backspace() {
        myRobot.keyPress(8);
        myRobot.keyRelease(8);
    }

    void sleep(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    void click() {
        myRobot.mousePress(16);
        myRobot.mouseRelease(16);
    }

    void doubleClick() {
        click();
        click();
    }

    void clickNhold(boolean tof) {
        if (tof) {
            myRobot.mousePress(16);
        } else {
            myRobot.mouseRelease(16);
        }
    }

    void rightClick() {
        myRobot.mousePress(4);
        myRobot.mouseRelease(4);
    }

    void rightclickHold(boolean tof) {
        if (tof) {
            myRobot.mousePress(4);
        } else {
            myRobot.mouseRelease(4);
        }
    }

    void middleClick() {
        myRobot.mousePress(8);
        myRobot.mouseRelease(8);
    }

    void manuPress(int code) {
        myRobot.keyRelease(16);
        myRobot.keyPress(code);
        myRobot.keyRelease(code);
    }

    void manuPressSHIFTED(int code) {
        myRobot.keyPress(16);
        myRobot.keyPress(code);
        myRobot.keyRelease(code);
        myRobot.keyRelease(16);
    }

    void gotoxy(int goX, int goY) {
        lastX = x;
        lastY = y;
        myRobot.setAutoDelay(mouseDelay);
        int initX = x;
        int initY = y;

        int dx = goX - initX;
        int dy = goY - initY;

        if (dx == 0) { // Vertical move
            int step = (dy > 0) ? 1 : -1;
            for (int i = y; i != goY; i += step) {
                y = i;
                myRobot.mouseMove(x, y);
            }
        } else { // Horizontal or diagonal move
            int step = (dx > 0) ? 1 : -1;
            // The loop variable 'i' here represents the x-offset from the start
            for (int i = 0; Math.abs(i) <= Math.abs(dx); i += step) {
                x = initX + i;
                y = initY + (i * dy) / dx; // Simple DDA
                myRobot.mouseMove(x, y);
            }
        }
        // Ensure final position is exact
        x = goX;
        y = goY;
        myRobot.mouseMove(x, y);
    }


    void getRGB(Color pixel) {
        red = pixel.getRed();
        green = pixel.getGreen();
        blue = pixel.getBlue();
        System.out.println(red + "," + green + "," + blue);
    }

    void savePoint() {
        savedX = x;
        savedY = y;
    }

    void captureScreen() {
        System.out.println("Capturing...");
        screen = new Color[screenX][screenY];
        for (int i = 0; i < screenX; i++) {
            for (int j = 0; j < screenY / 2; j++) {
                screen[i][j] = myRobot.getPixelColor(i, j);
            }
        }
        System.out.println("Capturing done");
    }

    void gotoPixel(Color pixel) {
        if (myRobot.getPixelColor(x, y).getRGB() != pixel.getRGB()) {
            boolean found = false;
            for (int i = screenX - 4; i >= 0 && !found; i--) {
                for (int j = 3; j < screenY / 2; j++) {
                    if ((myRobot.getPixelColor(i, j).getRGB() == pixel.getRGB())) {
                        gotoxy(i, j);
                        found = true;
                        break;
                    }
                }
            }
        }
        if (myRobot.getPixelColor(x, y).getRGB() == pixel.getRGB()) {
            while (myRobot.getPixelColor(x, y).getRGB() == pixel.getRGB()) {
                gotoxy((x - 1), y);
            }
        }
    }

    void emergeFromPixel(Color pixel) {
        if (myRobot.getPixelColor(x, y).getRGB() != pixel.getRGB()) {
            boolean found = false;
            for (int i = screenX - 4; i >= 0 && !found; i--) {
                for (int j = 3; j < screenY / 2; j++) {
                    if ((myRobot.getPixelColor(i, j).getRGB() == pixel.getRGB())) {
                        myRobot.mouseMove(i, j);
                        x = i;
                        y = j;
                        found = true;
                        break;
                    }
                }
            }
        }
    }

    void shift(char dir) {
        Color initPixel;
        dir = Character.toUpperCase(dir);
        if (dir == 'L') {
            gotoxy((x - 8), y);
            initPixel = myRobot.getPixelColor(x, y);
            while (myRobot.getPixelColor(x, y).getRGB() == initPixel.getRGB()) {
                gotoxy((x - 1), y);
            }
            int startX = x;
            for (int i = startX; i > startX - 20; i--) {
                if (myRobot.getPixelColor(i, y).getRGB() == initPixel.getRGB()) {
                    gotoxy(i, y);
                    while (myRobot.getPixelColor(x, y).getRGB() == initPixel.getRGB()) {
                        gotoxy((x - 1), y);
                    }
                    break;
                }
            }
        } else if (dir == 'R') {
            initPixel = myRobot.getPixelColor(x, y);
            while (myRobot.getPixelColor(x, y).getRGB() == initPixel.getRGB()) {
                gotoxy((x + 1), y);
            }
            int startX = x;
            for (int i = startX; i < startX + 20; i++) {
                if (myRobot.getPixelColor(i, y).getRGB() == initPixel.getRGB()) {
                    gotoxy(i, y);
                    while (myRobot.getPixelColor(x, y).getRGB() == initPixel.getRGB()) {
                        gotoxy((x + 1), y);
                    }
                    break;
                }
            }
            gotoxy((x + 8), y);
        }
    }

    void emergeFromButton(String butName) {
        int tempDelay = typeDelay;
        typeDelay = 0;
        myRobot.setAutoDelay(typeDelay);
        butName = butName.toUpperCase();
        if (butName.equals(CLOSE_BUTTON)) {
            emergeFromPixel(pixCloseActiveOffMouse);
        } else if (butName.equals("MAXIMIZE")) {
            emergeFromPixel(pixCloseActiveOffMouse);
            shift('L');
        } else if (butName.equals("MINIMIZE")) {
            emergeFromPixel(pixCloseActiveOffMouse);
            shift('L');
            shift('L');
        } else if (butName.equals("START")) {
            myRobot.mouseMove(20, screenY - 10);
        }
        typeDelay = tempDelay;
        myRobot.setAutoDelay(typeDelay);
    }

    void gotoButton(String butName) {
        butName = butName.toUpperCase();
        if (butName.equals(CLOSE_BUTTON)) {
            if (myRobot.getPixelColor(x, y).getRGB() != pixCloseActiveOnMouse.getRGB()) {
                gotoPixel(pixCloseActiveOffMouse);
            }
        } else if (butName.equals("MAXIMIZE")) {
            gotoPixel(pixCloseActiveOffMouse);
            shift('L');
        } else if (butName.equals("MINIMIZE")) {
            gotoPixel(pixCloseActiveOffMouse);
            shift('L');
            shift('L');
        } else if (butName.equals("START")) {
            gotoxy(20, screenY - 10);
        }
    }

    void catchTitleBar() {
        gotoButton(CLOSE_BUTTON);
        gotoxy(x - 150, y);
    }

    void pressKey(String keyName) {
        keyName = keyName.toUpperCase();
        if ("ESC".equals(keyName)) {
            manuPress(27);
        }
    }

    void closeAllWindows() {
        while ((myRobot.getPixelColor(65, screenY - 35).getRed() > 213) && (myRobot.getPixelColor(65, screenY - 35).getGreen() > 220) && (myRobot.getPixelColor(65, screenY - 35).getBlue() > 228)) {
            altTab();
            gotoButton(CLOSE_BUTTON);
            sleep(100);
            click();
            sleep(50);
        }
    }

    void quickCloseAllWindows() {
        while ((myRobot.getPixelColor(65, screenY - 35).getRed() > 213) && (myRobot.getPixelColor(65, screenY - 35).getGreen() > 220) && (myRobot.getPixelColor(65, screenY - 35).getBlue() > 228)) {
            winD();
            sleep(100);
            altTab();
            altF4();
            type("n");
        }
    }

    void getNotepad() {
        int saveDelay = typeDelay;
        typeDelay = 0;
        myRobot.setAutoDelay(0);
        myRobot.keyPress(524);
        myRobot.keyPress(82);
        myRobot.keyRelease(82);
        myRobot.keyRelease(524);
        sleep(200);
        typeln("notepad");
        sleep(500);
        typeDelay = saveDelay;
        myRobot.setAutoDelay(typeDelay);
    }

    void closeActiveWindow() {
        gotoButton(CLOSE_BUTTON);
        click();
        type("n");
    }

    void openMyComputer() {
        gotoxy(50, 50);
        doubleClick();
    }

    void lockMouse() {
        Thread lockMouse = new Thread(() -> {
            while (true) {
                myRobot.mouseMove(x, y);
                sleep(100);
            }
        });
        lockMouse.start();
    }
}
