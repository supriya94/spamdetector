package antispam;

import java.io.BufferedReader;
import java.util.ArrayList;

/**
 * An interface to identify spam
 */
public interface SpamClassifier {
    /**
     *Identify action and perform necessary changes to users involved
     */
    public void decodeCommand(String cmd);

    /**
     * Analyze a sequence of activities and classify users
     */
    public void classifySpam(String source);
}
