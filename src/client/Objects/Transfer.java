package client.Objects;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;

public final  class Transfer {
    public static BufferedWriter bw;
    public static BufferedReader br;
    public static Gson gson;


    public static BufferedWriter getBw() {
        return bw;
    }

    public static void setBw(BufferedWriter bw) {
        Transfer.bw = bw;
    }

    public static BufferedReader getBr() {
        return br;
    }

    public static void setBr(BufferedReader br) {
        Transfer.br = br;
    }

    public static Gson getGson() {
        return gson;
    }

    public static void setGson(Gson gson) {
        Transfer.gson = gson;
    }
}
