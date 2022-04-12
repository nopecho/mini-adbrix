import json
from package import pymysql
from package.pymysql import *

def insert_event(event, params_id):
    event_dict = json.loads(event)

    conn = None
    cur = None
    sql = ""

    conn = pymysql.connect(host="localhost", user="root", password="1234", db="test" ,charset='utf8')
    cur = conn.cursor()

    sql = "CREATE TABLE IF NOT EXISTS test_user(id char(4), user_name char(10))"
    cur.execute(sql)

    conn.commit()
    conn.close()

def insert_event_params(event):
    event_dict = json.loads(event)
    event_params = event_dict["parameters"]

    conn = pymysql.connect(host="localhost", user="root", password="1234", db="test" ,charset='utf8')
    cur = conn.cursor()

    sql = "INSERT INTO parameters VALUES(%s, %s, %s, %d, %s, %s, %d, %s)" % (
        event_params["connetDateTime"], 
        event_params["loginId"], 
        event_params["userName"], 
        event_params["age"],
        event_params["loginDateTime"],
        event_params["category"],
        event_params["postId"],
        event_params["title"]
    )
    cur.execute(sql)

    conn.commit()
    conn.close()

    