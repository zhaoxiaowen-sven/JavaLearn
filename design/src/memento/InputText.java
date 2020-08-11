package memento;


public class InputText {
    private StringBuilder text = new StringBuilder();

    public void append(String input) {
        text.append(input);
    }

    public SnapShot createSnapshot() {
        return new SnapShot(text.toString());
    }

    public void restoreSnapshot(SnapShot snapshot) {
        this.text.replace(0, this.text.length(), snapshot.getText());
    }

    @Override
    public String toString() {
        return "InputText{" +
                "text=" + text +
                '}';
    }
}

