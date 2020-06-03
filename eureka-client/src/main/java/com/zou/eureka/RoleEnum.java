package com.zou.eureka;

public enum RoleEnum implements RoleOperation {
    ROLE_ENUM_A {
        @Override
        public String op() {
            return "aa";
        }
    },
    ROLE_ENUM_B {
        @Override
        public String op() {
            return "bb";
        }
    },
    ROLE_ENUM_C {
        @Override
        public String op() {
            return "cc";
        }
    };
}
