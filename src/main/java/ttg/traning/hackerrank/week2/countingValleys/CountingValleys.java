package ttg.traning.hackerrank.week2.countingValleys;

/**
 *
 * @author ttg
 */
public class CountingValleys {

    public static int process(String path) {
        char uphill = 'U';
        char downhill = 'D';

        int currentLevel = 0;
        boolean downhillFlag = false;

        int countValleys = 0;

        for (int i = 0; i < path.length(); i++) {

            char current = path.charAt(i);

            int previousLevel = currentLevel;
            int nextLevel = current == uphill ? currentLevel + 1 : currentLevel - 1;

            boolean isInDownHill = !downhillFlag && current == downhill && previousLevel <= 0;
            if (isInDownHill) {
                downhillFlag = true;
            }

            boolean isReachSeaLevelAgainFromDownHill = nextLevel == 0 && downhillFlag;
            if (isReachSeaLevelAgainFromDownHill) {
                countValleys++;
                downhillFlag = false;
            }

            currentLevel = nextLevel;
        }
        return countValleys;
    }

    public static int process1(String path) {
        int level, valley;
        level = valley = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == 'U') {
                level++;
                if (level == 0) {
                    valley++;
                }
                continue;
            }
            if (path.charAt(i) == 'D') {
                level--;
            }
        }

        return valley;
    }
}
