package com.prac.cote.dbfs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SpringBootApplication
public class Back1325 {
    static int max;

    static int[] computer;

    static boolean[] vistied;

    static List<Integer>[] list;


    public static void main(String[] args) throws IOException {
        SpringApplication.run(Back1325.class, args);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        computer = new int[N+1];
        vistied = new boolean[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st= new StringTokenizer(br.readLine());

            int com1 = Integer.parseInt(st.nextToken());
            int com2 = Integer.parseInt(st.nextToken());

            list[com1].add(com2);
        }

        for(int i = 1; i <= N; i++) {
            vistied = new boolean[N+1];
            bfs(i);
        }

        for (int i : computer) {
            max = Math.max(max, i);
        }

        for(int i = 1; i <=N; i++) {
            if(computer[i] == max) {
                System.out.print(i + " ");
            }
        }

    }

    public static void dfs(int com,  List<Integer>[] list) {
        vistied[com] = true;

        for (Integer i : list[com]) {
            if(!vistied[i]) {
                computer[i]++;
                dfs(i, list);
            }
        }
    }

    public static void bfs(int com) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(com);

        vistied[com] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            for(int i : list[now]) {
                if(vistied[i]) continue;
                computer[i]++;
                vistied[i]= true;
                queue.add(i);
            }

        }
    }
}