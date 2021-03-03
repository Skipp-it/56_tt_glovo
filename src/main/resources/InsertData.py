import psycopg2
import random
import requests

conn = psycopg2.connect("dbname=glovodb user=postgres password=root")
cur = conn.cursor()


def get_category(string):
    return string.split("=")[1]


def insert_data():
    url = 'https://www.themealdb.com/api/json/v1/1/filter.php?c=Goat'
    result = requests.get(url)
    get_json = result.json()
    elements = get_json['meals']
    for i in elements:
        cur.execute("INSERT INTO public.meal (id, price,category) VALUES (%s,%s,%s)",
                    (i["idMeal"], random.randint(0, 100), get_category(url)))


insert_data()

conn.commit()
cur.close()
conn.close()
