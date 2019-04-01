package com.example.sunita.mini.Model;

public class Player_info {
      String id;
      String name;
      String age;
      int matches;
      int runs;
      float batavg;
      float batsr;
      float bowavg;
      float bowsr;
      int wickets;
      int baseprice;

        public Player_info()
        {}

        public Player_info(
                String id,String name,String age,int matches,int runs,float batavg,float batsr,float bowavg, float bowsr,int wickets, int baseprice)
        {
            this.id=id;
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

         public String getId() {
          return id;
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

