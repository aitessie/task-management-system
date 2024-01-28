CREATE SCHEMA task_management_system;

CREATE TABLE task
(
    task_id       BIGINT CONSTRAINT task_id_pk PRIMARY KEY,
    title         VARCHAR(256) NOT NULL,
    description   VARCHAR(512),
    status        VARCHAR(16)  NOT NULL,
    priority      VARCHAR(16)  NOT NULL,
    author        VARCHAR(64)  NOT NULL,
    assignee      VARCHAR(64),
    create_dttm   TIMESTAMP    NOT NULL,
    update_dttm   TIMESTAMP    NOT NULL,
    complete_dttm TIMESTAMP
);

CREATE SEQUENCE IF NOT EXISTS task_id_seq START WITH 1;

COMMENT
ON TABLE task IS 'Задача';
COMMENT
ON COLUMN task.task_id IS 'Идентификатор задачи';
COMMENT
ON COLUMN task.title IS 'Название';
COMMENT
ON COLUMN task.description IS 'Описание';
COMMENT
ON COLUMN task.status IS 'Статус';
COMMENT
ON COLUMN task.priority IS 'Приоритет';
COMMENT
ON COLUMN task.author IS 'Автор';
COMMENT
ON COLUMN task.assignee IS 'Исполнитель';
COMMENT
ON COLUMN task.create_dttm IS 'Дата создания';
COMMENT
ON COLUMN task.update_dttm IS 'Дата изменения';
COMMENT
ON COLUMN task.complete_dttm IS 'Дата завершения';

CREATE TABLE comment
(
    comment_id  BIGINT CONSTRAINT comment_id_pk PRIMARY KEY,
    task_id     BIGINT CONSTRAINT task_comment_fk REFERENCES task (task_id),
    comment     VARCHAR(1024) NOT NULL,
    create_dttm TIMESTAMP     NOT NULL,
    author      VARCHAR(64)   NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS comment_id_seq START WITH 1;

COMMENT
ON TABLE comment IS 'Комментарий';
COMMENT
ON COLUMN comment.comment_id IS 'Идентификатор комментария';
COMMENT
ON COLUMN comment.task_id IS 'Идентификатор задачи';
COMMENT
ON COLUMN comment.comment IS 'Комментарий';
COMMENT
ON COLUMN comment.create_dttm IS 'Дата создания';
COMMENT
ON COLUMN comment.author IS 'Автор';

CREATE TABLE tms_user
(
    tms_user_id BIGINT CONSTRAINT tms_user_id_pk PRIMARY KEY,
    name        VARCHAR(256) NOT NULL,
    password    VARCHAR(256) NOT NULL,
    role        VARCHAR(256) NOT NULL,
);

CREATE SEQUENCE IF NOT EXISTS tms_user_id_seq START WITH 1;

COMMENT
ON TABLE tms_user IS 'Пользователь';
COMMENT
ON COLUMN tms_user.tms_user_id IS 'Идентификатор пользователя';
COMMENT
ON COLUMN tms_user.name IS 'Имя';
COMMENT
ON COLUMN tms_user.password IS 'Пароль';
