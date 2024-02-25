import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Note {
    private final String DEFAULT_FILE_NAME = "note.txt";
    private final TextFile textFile;
    private BirthdayChecker birthdayChecker; // add this line

    public Note(TextFile textFile) {
        this.textFile = textFile;
        this.create(); // always create file name
    }

    public Note(TextFile textFile, BirthdayChecker birthdayChecker) {
        this.textFile = textFile;
        this.birthdayChecker = birthdayChecker;
        this.create();
    }

    private void create() {
        textFile.create(DEFAULT_FILE_NAME);
    }

    public void write(String content) {
        if (birthdayChecker.isBirthday()) {
            content += " 🎂";
        }
        textFile.write(DEFAULT_FILE_NAME, content);
    }

    // Completable - True or False
    // Async task
    public Completable writeAsync(String content, Scheduler scheduler) {
        return Completable.fromAction(() -> write(content)).subscribeOn(scheduler);
    }

    public String read() {
        return textFile.read(DEFAULT_FILE_NAME);
    }

}