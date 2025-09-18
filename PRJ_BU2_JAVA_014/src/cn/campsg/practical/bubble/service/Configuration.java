package cn.campsg.practical.bubble.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.campsg.practical.bubble.entity.Score;

public class Configuration {
    private Score score = null;
    private final String CONF_PATH = "score.conf";

    public Configuration() {
        score = new Score();
        BufferedReader bf = null;
        try {
            bf = new BufferedReader(new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream(CONF_PATH)));
            score.setLevelScore(Integer.parseInt(bf.readLine()));
            score.setStep(Integer.parseInt(bf.readLine()));
            score.setIncrement(Integer.parseInt(bf.readLine()));
            score.setLength(Integer.parseInt(bf.readLine()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            score = null;
        } finally {
            if (bf != null)
                try {
                    bf.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
        }

public Score getScore() {
    return score;
}
}