
public class Chat {

    public static void main(String[] args) {

// Exemplo básico em Java:
// Inflar o layout da popup
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup_layout, null);

// Criar a PopupWindow (tamanho width e height)
        final PopupWindow popupWindow = new PopupWindow(popupView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                true); // true para permitir foco na popup

// Mostrar a popup em relação a uma View âncora (exemplo: um botão)
        popupWindow.showAsDropDown(anchorView);

    }

}
