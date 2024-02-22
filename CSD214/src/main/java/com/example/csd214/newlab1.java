package com.example.csd214;

public class newlab1 {
        private int id;
        private String username;
        private String subject;
        private int age;
        public newlab1(int id, String username, String subject, int age) {
            this.id = id;
            this.username = username;
            this.subject = subject;
            this.age = age;
        }
        public int getId() {
            return id;
        }
        public String getUsername() {
            return username;
        }
        public String getSubject() {
            return subject;
        }
        public int getAge() {
            return age;
        }
    }
