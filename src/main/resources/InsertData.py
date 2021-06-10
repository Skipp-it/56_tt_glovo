import psycopg2
import random
import requests

conn = psycopg2.connect("dbname=glovodb user=postgres password=root")
cur = conn.cursor()


def insert_data(category):
    url = 'https://www.themealdb.com/api/json/v1/1/filter.php?c=' + category
    result = requests.get(url)
    get_json = result.json()
    elements = get_json['meals']
    for i in elements:
        cur.execute("INSERT INTO public.meal (id, price,category) VALUES (%s,%s,%s)",
                    (i["idMeal"], random.randint(1, 100), category))


insert_data("Breakfast")

conn.commit()
cur.close()
conn.close()
