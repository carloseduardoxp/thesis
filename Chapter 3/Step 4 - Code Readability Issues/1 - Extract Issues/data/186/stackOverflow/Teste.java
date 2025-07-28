
public class Teste {

    public void main() {

        switch (option) {
            case 3:
                case3();
                case1();
                break;
            case 2:
                case2();
                case1();
                break;
            case 1:
                case1();   // You didn't specify what to do for case 1, so I assume you want case1()
                break;
            default:
            // Always a good idea to have a default, just in case demons are summoned
        }
    }

    void case1() {
        // Whatever case 1 does
    }

    void case2() {
        // Whatever case 2 does
    }

    void case3() {
        // Whatever case 3 does
    }
}
