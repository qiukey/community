## 学习社区

## 资料
[Spring文档](https://spring.io/guides)

[Spring Web文档](https://spring.io/guides/gs/serving-web-content/)

[git授权地址](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)

[Thymeleaf](https://www.thymeleaf.org/doc/tutorials/3.0/usingthymeleaf.html#setting-attribute-values)
## 工具
[git下载地址](https://git-scm.com/download)

[Visual Paradigm](https://www.visual-paradigm.com)

[OkHttp](https://square.github.io/okhttp/)

[Flyway](https://flywaydb.org/getstarted/firststeps/maven)

[Lombok](https://www.projectlombok.org)

## 脚本
```sql
CREATE TABLE USER(
    ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL ,
    ACCOUNT_ID VARCHAR(100),
    NAME VARCHAR(50),
    TOKEN CHAR(36),
    GMT_CREATE BIGINT,
    GMT_MODIFIED BIGINT
);

```
```bash
mvn flyway:migrate
```