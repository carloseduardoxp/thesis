import java.awt.Color;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyRobot {
    private static final String CLOSE_BUTTON = "CLOSE";
    private static final String MAXIMIZE_BUTTON = "MAXIMIZE";
    private static final String MINIMIZE_BUTTON = "MINIMIZE";
    private static final String START_BUTTON = "START";

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
    private HashMap<Character, Integer> keyMap;
    private ArrayList<Integer> randKeys;
    private GraphicsEnvironment grEnv;
    private GraphicsDevice grDevice;
    private JPanel drawPanel;
    private BufferedImage bufImg;
    private Rectangle rect;
    private final Random random = new Random();

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
        keyMap = new HashMap<>();
        keyMap.put('q', 81);
        keyMap.put('w', 87);
        keyMap.put('e', 69);
        keyMap.put('r', 82);
        keyMap.put('t', 84);
        keyMap.put('y', 89);
        keyMap.put('u', 85);
        keyMap.put('i', 73);
        keyMap.put('o', 79);
        keyMap.put('p', 80);
        keyMap.put('a', 65);
        keyMap.put('s', 83);
        keyMap.put('d', 68);
        keyMap.put('f', 70);
        keyMap.put('g', 71);
        keyMap.put('h', 72);
        keyMap.put('j', 74);
        keyMap.put('k', 75);
        keyMap.put('l', 76);
        keyMap.put('z', 90);
        keyMap.put('x', 88);
        keyMap.put('c', 67);
        keyMap.put('v', 86);
        keyMap.put('b', 66);
        keyMap.put('n', 78);
        keyMap.put('m', 77);
        keyMap.put('1', 49);
        keyMap.put('2', 50);
        keyMap.put('3', 51);
        keyMap.put('4', 52);
        keyMap.put('5', 53);
        keyMap.put('6', 54);
        keyMap.put('7', 55);
        keyMap.put('8', 56);
        keyMap.put('9', 57);
        keyMap.put('0', 48);
        keyMap.put(' ', 32);

        randKeys = new ArrayList<>();
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
        myRobot.setAutoDelay(typeDelay);
        char[] letter = letters.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            System.out.print(letter[i]);
            try {
                if (random.nextInt(skill) == random.nextInt(skill) / 2) {
                    int limit = random.nextInt(3) + 1;
                    for (int j = 0; j < limit; j++) {
                        int k = random.nextInt(randKeys.size() - 1);
                        manuPress(randKeys.get(k));
                    }
                    sleep(200);
                    for (int j = 0; j < limit; j++) {
                        backspace();
                    }
                }
                if ((Character.isLowerCase(letter[i])) || (Character.isDigit(letter[i]))) {
                    myRobot.keyPress(keyMap.get(letter[i]));
                    myRobot.keyRelease(keyMap.get(letter[i]));
                } else {
                    letter[i] = Character.toLowerCase(letter[i]);
                    myRobot.keyPress(16);
                    myRobot.keyPress(keyMap.get(letter[i]));
                    myRobot.keyRelease(keyMap.get(letter[i]));
                    myRobot.keyRelease(16);
                }
            } catch (Exception e) {
                handleSpecialCharacter(letter[i]);
            }
        }
        System.out.println("");
    }

    private void handleSpecialCharacter(char c) {
        switch (c) {
            case '!':
                manuPressSHIFTED(49);
                break;
            case '@':
                manuPressSHIFTED(50);
                break;
            case '#':
                manuPressSHIFTED(51);
                break;
            case '$':
                manuPressSHIFTED(52);
                break;
            case '%':
                manuPressSHIFTED(53);
                break;
            case '^':
                manuPressSHIFTED(54);
                break;
            case '&':
                manuPressSHIFTED(55);
                break;
            case '*':
                manuPressSHIFTED(56);
                break;
            case '(':
                manuPressSHIFTED(57);
                break;
            case ')':
                manuPressSHIFTED(48);
                break;
            case '?':
                manuPressSHIFTED(47);
                break;
            case '/':
                manuPress(47);
                break;
            case ':':
                manuPressSHIFTED(59);
                break;
            case ';':
                manuPress(59);
                break;
            case '.':
                manuPress(46);
                break;
            case ',':
                manuPress(44);
                break;
            case '"':
                manuPressSHIFTED(222);
                break;
            case '\'':
                manuPress(222);
                break;
            case '[':
                manuPress(91);
                break;
            case ']':
                manuPress(93);
                break;
            case '{':
                manuPressSHIFTED(91);
                break;
            case '}':
                manuPressSHIFTED(93);
                break;
            case '\\':
                manuPress(92);
                break;
            case '|':
                manuPressSHIFTED(92);
                break;
            case '=':
                manuPressSHIFTED(61);
                break;
            case '+':
                manuPressSHIFTED(61);
                break;
            case '-':
                manuPress(45);
                break;
            case '_':
                manuPressSHIFTED(45);
                break;
            case '`':
                manuPress(192);
                break;
            case '~':
                manuPressSHIFTED(192);
                break;
            case '<':
                manuPressSHIFTED(44);
                break;
            case '>':
                manuPressSHIFTED(46);
                break;
            default:
                break;
        }
    }

    void type(String letters) {
        myRobot.setAutoDelay(typeDelay);
        char[] letter = letters.toCharArray();
        for (int i = 0; i < letter.length; i++) {
            System.out.print(letter[i]);
            try {
                if ((Character.isLowerCase(letter[i])) || (Character.isDigit(letter[i]))) {
                    myRobot.keyPress(keyMap.get(letter[i]));
                    myRobot.keyRelease(keyMap.get(letter[i]));
                } else {
                    letter[i] = Character.toLowerCase(letter[i]);
                    myRobot.keyPress(16);
                    myRobot.keyPress(keyMap.get(letter[i]));
                    myRobot.keyRelease(keyMap.get(letter[i]));
                    myRobot.keyRelease(16);
                }
            } catch (Exception e) {
                handleSpecialCharacter(letter[i]);
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
        } catch (Exception e) {
            // Ignore
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
        if (goX == x) {
            if (goY > y) {
                for (int i = y; i <= goY; i++) {
                    y = i;
                    myRobot.mouseMove(x, y);
                }
            } else {
                for (int i = y; i >= goY; i--) {
                    y = i;
                    myRobot.mouseMove(x, y);
                }
            }
        } else if (goX > x) {
            for (int i = 0; i <= (goX - initX); i++) {
                x = initX + i;
                y = initY + ((i * (goY - initY)) / (goX - initX));
                myRobot.mouseMove(x, y);
            }
        } else {
            for (int i = 0; i >= (goX - initX); i--) {
                x = initX + i;
                y = initY + ((i * (goY - initY)) / (goX - initX));
                myRobot.mouseMove(x, y);
            }
        }
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
            for (int i = screenX - 4; i >= 0; i--) {
                for (int j = 3; j < screenY / 2; j++) {
                    if ((myRobot.getPixelColor(i, j).getRGB() == pixel.getRGB())) {
                        gotoxy(i, j);
                        i = -1;
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
            for (int i = screenX - 4; i >= 0; i--) {
                for (int j = 3; j < screenY / 2; j++) {
                    if ((myRobot.getPixelColor(i, j).getRGB() == pixel.getRGB())) {
                        myRobot.mouseMove(i, j);
                        x = i;
                        y = j;
                        i = -1;
                        break;
                    }
                }
            }
        }
    }

    void shift(char dir) {
        int initX = x;
        Color initPixel;
        dir = Character.toUpperCase(dir);
        if (dir == 'L') {
            gotoxy((x - 8), y);
            initPixel = myRobot.getPixelColor(x, y);
            while (myRobot.getPixelColor(x, y).getRGB() == initPixel.getRGB()) {
                gotoxy((x - 1), y);
            }
            initX = x;
            for (int i = initX; i > initX - 20; i--) {
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
            initX = x;
            for (int i = initX; i < initX + 20; i++) {
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
        } else if (butName.equals(MAXIMIZE_BUTTON)) {
            emergeFromPixel(pixCloseActiveOffMouse);
            shift('L');
        } else if (butName.equals(MINIMIZE_BUTTON)) {
            emergeFromPixel(pixCloseActiveOffMouse);
            shift('L');
            shift('L');
        } else if (butName.equals(START_BUTTON)) {
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
        } else if (butName.equals(MAXIMIZE_BUTTON)) {
            gotoPixel(pixCloseActiveOffMouse);
            shift('L');
        } else if (butName.equals(MINIMIZE_BUTTON)) {
            gotoPixel(pixCloseActiveOffMouse);
            shift('L');
            shift('L');
        } else if (butName.equals(START_BUTTON)) {
            gotoxy(20, screenY - 10);
        }
    }

    void catchTitleBar() {
        gotoButton(CLOSE_BUTTON);
        gotoxy(x - 150, y);
    }

    void pressKey(String keyName) {
        keyName = keyName.toUpperCase();
        if (keyName.equals("ESC")) {
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