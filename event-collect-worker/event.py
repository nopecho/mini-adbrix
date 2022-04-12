from base import BaseModel
from package.peewee import IntegerField, CharField, DateTimeField, ForeignKeyField


class Parameters(BaseModel) :

    class Meta:
        db_table = 'parameters'
    
    id = IntegerField(primary_key= True)
    connect_date_time = DateTimeField()
    login_id = CharField()
    user_name = CharField()
    user_age = IntegerField()
    login_date_time = DateTimeField()
    post_id = IntegerField()
    post_title = CharField()
    category = CharField()
    

class Event(BaseModel):

    class Meta:
        db_table = 'event'

    id = IntegerField(primary_key=True)
    event_id = CharField()
    user_id = CharField()
    event = CharField()
    parameters_id = ForeignKeyField(Parameters, backref='parameters')
    create_time = DateTimeField()
