package team.onlapus.ua.ors;

import team.onlapus.ua.actions.Actions;

class CWait {
    private final int time;
    private final String message;

    CWait(int time, String message) {
        this.time = time;
        this.message = message;
    }

    public int getTime() {
        return this.time;
    }

    public String getMessage() {
        return this.message;
    }

    public String toString() {
        return this.message + " (" + Actions.displayTime(this.time) + ")";
    }
}
