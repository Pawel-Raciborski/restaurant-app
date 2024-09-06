create table permission_role(
    id SERIAL NOT NULL PRIMARY KEY,
    role_id INT NOT NULL,
    permission_id INT not null,
    CONSTRAINT fk_permission_role_role FOREIGN KEY (role_id)
                            references role(id),
    CONSTRAINT fk_permission_role_permission FOREIGN KEY (permission_id)
                            references permission(id)
)