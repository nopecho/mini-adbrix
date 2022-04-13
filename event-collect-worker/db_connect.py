import json
from package import pymysql
from package.pymysql import *
import conf

def insert_event(event, parameters_id):
    event_dict = json.loads(event)

    conn = pymysql.connect(host=conf.DATABASE["URL"], user=conf.DATABASE["USER_ID"], password=conf.DATABASE["USER_PASSWORD"], db="adbrix" ,charset='utf8')
    cur = conn.cursor()

    sql = "INSERT INTO event(event_id, user_id, event, parimeters_id) VALUES(%d, %s, %s," + parameters_id + ")" % (
        event_dict["eventId"],
        event_dict["userId"],
        event_dict["event"]
    )
    cur.execute(sql)

    conn.commit()
    conn.close()

def insert_event_params(event):
    event_dict = json.loads(event)
    event_params = event_dict["parameters"]

    conn = pymysql.connect(host=conf.DATABASE["URL"], user=conf.DATABASE["USER_ID"], password=conf.DATABASE["USER_PASSWORD"], db="adbrix" ,charset='utf8')
    cur = conn.cursor()

    insert_sql = "INSERT INTO parameters(connet_date_time,login_id,user_name,age,login_date_time,category,post_id,title) VALUES(%s, %s, %s, %d, %s, %s, %d, %s)" % (
        event_params["connetDateTime"], 
        event_params["loginId"], 
        event_params["userName"], 
        event_params["age"],
        event_params["loginDateTime"],
        event_params["category"],
        event_params["postId"],
        event_params["title"]
    )
    cur.execute(insert_sql)
    conn.commit()

    get_id_sql = "SELECT last_insert_id()"
    parameters_id = cur.execute(get_id_sql)

    conn.close()
    return parameters_id

    