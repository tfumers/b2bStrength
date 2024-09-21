package com.toGames.b2bStrength.utils;

public class Constant {

    public static  final Long ACTIVITY_TYPE_REPS = 1L;

    public static final Long USER_TYPE_CLIENT = 1L;
    public static final Long USER_TYPE_TRAINER = 2L;
    public static final Long USER_TYPE_ADMIN = 3L;

    public static final Long CLIENT_STATUS_NOT_REQUIRED = 0L;
    public static final Long CLIENT_STATUS_NO_SURVEY = 1L;
    public static final Long CLIENT_STATUS_NO_ROUTINE = 2L;
    public static final Long CLIENT_STATUS_WAITING = 3L;
    public static final Long CLIENT_STATUS_HAS_ROUTINE = 4L;
    public static final Long CLIENT_STATUS_BANNED = 5L;
    public static final String SESSION_ATTR_USER_ID = "UserId";
    public static final String USER_ROLE_ADMIN = "ROLE_ADMIN";
    public static final String USER_ROLE_TRAINER = "ROLE_TRAINER";
    public static final String USER_ROLE_CLIENT = "ROLE_CLIENT";

    public static final long TCR_STATUS_PENDING = 1;
    public static final long TCR_STATUS_ACCEPTED = 2;
    public static final long TCR_STATUS_CANCELLED = 3;
}
