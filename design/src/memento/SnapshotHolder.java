package memento;


import java.util.Stack;

public class SnapshotHolder {
    private Stack<SnapShot> snapshots = new Stack<>();

    public SnapShot popSnapshot() {
        SnapShot snapShot = snapshots.pop();
        return snapShot;
    }

    public void pushSnapshot(SnapShot snapShot) {
        snapshots.push(snapShot);
    }
}
