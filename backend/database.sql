## Database SQL Code ##

# 스키마 생성
CREATE SCHEMA Letsmeet;
#사용 전 Set as Default Schema 설정해주기 

################################################################################################################################
## 유저 테이블 생성 ##
CREATE TABLE user
(
    `u_no`            INT             NOT NULL    AUTO_INCREMENT COMMENT '유저 번호(보이진않음)', 
    `u_email`         VARCHAR(50)     NOT NULL    COMMENT '유저 이메일', 
    `u_confirmemail`  CHAR(1)         NULL        COMMENT '유저 이메일인증확인', 
    `u_password`      VARCHAR(20)     NOT NULL    COMMENT '유저 비밀번호(확인은BE에서불필요)', 
    `u_name`          VARCHAR(50)     NOT NULL    COMMENT '유저 이름', 
    `u_birth`         DATE            NOT NULL    COMMENT '유저 생년월일', 
    `u_joindate`      TIMESTAMP       NOT NULL    COMMENT '유저 가입일(보이진않음)', 
    `u_img`           VARCHAR(300)    NULL        COMMENT '유저 이미지', 
    `u_address`       VARCHAR(300)    NULL        COMMENT '유저 주소명', 
    `u_provider`      VARCHAR(50)     NULL        COMMENT 'SNS 제공자 [SNS으로가입시에만]', 
    PRIMARY KEY (u_no, u_email)
);
ALTER TABLE user COMMENT '유저 정보 DB';

################################################################################################################################
## 장소 테이블 생성 ##
CREATE TABLE store
(
    `s_no`               INT             NOT NULL    AUTO_INCREMENT COMMENT '상가번호', 
    `s_name`             VARCHAR(45)     NOT NULL    COMMENT '상가명', 
    `s_category`         VARCHAR(45)     NOT NULL    COMMENT '상가 대분류', 
    `s_detail_category`  VARCHAR(45)     NULL        COMMENT '상가 중분류', 
    `s_dong`             VARCHAR(45)     NOT NULL    COMMENT '법정동명', 
    `s_road`             VARCHAR(100)    NOT NULL    COMMENT '도로명', 
    `s_main_bungee`      INT             NOT NULL    COMMENT '본번지', 
    `s_sub_bungee`       INT             NULL        COMMENT '부번지', 
    `s_building`         VARCHAR(45)     NULL        COMMENT '건물명', 
    `s_roadadress`       VARCHAR(100)    NOT NULL    COMMENT '도로명주소', 
    `s_lat`              INT             NOT NULL    COMMENT '위도', 
    `s_lng`              INT             NOT NULL    COMMENT '경도', 
    `s_score`            INT             NULL        COMMENT '상가 별점', 
    PRIMARY KEY (s_no)
);
ALTER TABLE store COMMENT '장소 DB (store 대신 place???) ... 향후 수정 필요';

################################################################################################################################
## 약속방 테이블 생성 ##
CREATE TABLE MeetingRoom
(
    `mr_no`               INT             NOT NULL    AUTO_INCREMENT COMMENT '약속방번호', 
    `mr_name`             VARCHAR(50)     NOT NULL    COMMENT '약속방이름', 
    `mr_category`         VARCHAR(50)     NOT NULL    COMMENT '약속 유형(대분류)', 
    `mr_detail_category`  VARCHAR(50)     NULL        COMMENT '약속 유형(중분류)-이거추후수정', 
    `mr_confirm_sno`      INT             NULL        COMMENT '최종 장소 번호', 
    `mr_confirm_date`     DATE            NULL        COMMENT '최종 날짜', 
    `mr_start_date`       DATE            NULL        COMMENT '시작 날짜', 
    `mr_end_date`         DATE            NULL        COMMENT '종료 날짜', 
    `mr_def_place`        VARCHAR(300)    NOT NULL    COMMENT '추천 장소(중간값-default-방장위치)', 
    `mr_rand_place`       VARCHAR(300)    NOT NULL    COMMENT '추천 장소(랜덤)', 
    `mr_photo`            VARCHAR(300)    NULL        COMMENT '약속방 사진', 
    PRIMARY KEY (mr_no)
);
ALTER TABLE MeetingRoom
    ADD CONSTRAINT FK_MeetingRoom_mr_confirm_sno_store_s_no FOREIGN KEY (mr_confirm_sno)
        REFERENCES store (s_no) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE MeetingRoom COMMENT '약속방 정보 DB';

################################################################################################################################
## 약속방 멤버 테이블 ##
CREATE TABLE meetingParticipate
(
    `mp_no`   INT    NOT NULL    COMMENT '약속방 번호', 
    `mp_uno`  INT    NOT NULL    COMMENT '약속방 멤버 번호', 
    `mp_lat`  INT    NULL        COMMENT '출발 위도', 
    `mp_lng`  INT    NULL        COMMENT '출발 경도', 
    PRIMARY KEY (mp_no, mp_uno)
);
ALTER TABLE meetingParticipate
    ADD CONSTRAINT FK_meetingParticipate_mp_no_MeetingRoom_mr_no FOREIGN KEY (mp_no)
        REFERENCES MeetingRoom (mr_no) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE meetingParticipate
    ADD CONSTRAINT FK_meetingParticipate_mp_uno_user_u_no FOREIGN KEY (mp_uno)
        REFERENCES user (u_no) ON DELETE RESTRICT ON UPDATE RESTRICT;
        
ALTER TABLE meetingParticipate COMMENT '약속방에 속한 멤버들 관리 DB';

################################################################################################################################
##

################################################################################################################################
##