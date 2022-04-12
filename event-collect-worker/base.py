from package.playhouse.mysql_ext import MariaDBConnectorDatabase
from package.peewee import Model
from conf import DATABASE

db_url = DATABASE['URL']
user_id = DATABASE['USER_ID']
user_password = DATABASE['USER_PASSWORD']

test_db_url = DATABASE['TEST_URL']
test_user_id = DATABASE['TEST_USER_ID']
test_user_password = DATABASE['TEST_USER_PASSWORD']

db = MariaDBConnectorDatabase('test', user=test_user_id, host=test_db_url, password=test_user_password, port=3306)
db.connect()

class BaseModel(Model) :
    class Meta :
        database = db

