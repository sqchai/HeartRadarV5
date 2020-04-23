package io.github.eagle38394516.heartradar;

import android.annotation.SuppressLint;

import java.util.Random;

class DebugWebContentGen {
    private static Random rndGen = new Random();
    private static long lastRead = 0;

    @SuppressLint("DefaultLocale")
    static String debugWebGen() {
        try {
            Thread.sleep(rndGen.nextInt(5));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();

        int records = rndGen.nextInt(20) + 100;
        for (int i = 0; i < records; i++) {
            result.append(String.format("%04d %04d %04d %04d %04d\n",
                    rndGen.nextInt(4096),
                    rndGen.nextInt(4096),
                    rndGen.nextInt(4096),
                    rndGen.nextInt(4096),
                    rndGen.nextInt(4096)));
        }

        result.append("missing ");
        if (System.currentTimeMillis() - lastRead > 5000) {
            result.append(rndGen.nextInt(1000));
        } else {
            result.append("0");
        }
        lastRead = System.currentTimeMillis();
        return result.toString();
    }
}