# DO NOT MODIFY DATABASE DIRECTLY
# MAKE ALL CHANGES IN Vx FILES
# MODIFY Vx FILE ONLY ONCE SO MIGRATION CHECKSUM TO COINCIDE
# IF AN EXCEPTION OCCURS DURING MIGRATION, ROLLBACK THE DATABASE
# TABLE flyway_schema_history STORE ALL MIGRATION HISTORY

use nft;

alter table batch
    modify created_at datetime not null;

alter table batch
    modify updated_at datetime not null;

alter table batch
    add status bool not null;
