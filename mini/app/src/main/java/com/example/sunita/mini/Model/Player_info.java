package com.example.sunita.mini.Model;

public class Player_info {
        private String name;
        private String age;
        private int matches;
        private int runs;
        private float batavg;
        private float batsr;
        private float bowavg;
        private float bowsr;
        private int wickets;
        private int baseprice;

        public Player_info()
        {}

        public Player_info(String name,String age,int matches,int runs,float batavg,float batsr,float bowavg, float bowsr,int wickets, int baseprice)
        {
            this.name=name;
            this.age=age;
            this.matches=matches;
            this.runs=runs;
            this.batavg=batavg;
            this.batsr=batsr;
            this.bowavg=bowavg;
            this.batsr=batsr;
            this.wickets=wickets;
            this.baseprice=baseprice;

        }

        public String getName() {
            return name;
        }

        public String getAge() {
            return age;
        }

        public int getMatches() {
            return matches;
        }

        public int getRuns() {
            return runs;
        }

        public float getBatavg() {
            return batavg;
        }

        public float getBatsr() {
            return batsr;
        }

        public float getBowavg() {
            return bowavg;
        }

        public float getBowsr() {
            return bowsr;
        }

        public int getWickets() {
            return wickets;
        }

        public int getBaseprice() {
            return baseprice;
        }
    }

