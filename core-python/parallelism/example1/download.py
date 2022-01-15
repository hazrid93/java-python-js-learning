
from webbrowser import get
from dotenv import load_dotenv
import os
load_dotenv()
import json
import logging
import os
from pathlib import Path
from urllib.request import urlopen, Request
# from : https://www.toptal.com/python/beginners-guide-to-concurrency-and-parallelism-in-python#:~:text=What's%20the%20difference%20between%20Python,child%20processes%20bypassing%20the%20GIL.
logger = logging.getLogger(__name__)

IMGUR_CLIENT_ID = os.getenv('IMGUR_CLIENT_ID')
IMGUR_CLIENT_SECRET = os.getenv('IMGUR_CLIENT_SECRET')

types = {'image/jpeg', 'image/png'}


def get_links(clientid):
    # rest api note: https://docs.python.org/3.9/library/urllib.request.html
    headers = {'Authorization': 'Client-ID {}'.format(clientid)}
    req = Request('https://api.imgur.com/3/gallery/random/random/', headers=headers, method='GET')
    # (similar to java `try-with-resources``) with..as : https://stackoverflow.com/questions/1369526/what-is-the-python-keyword-with-used-for
    with urlopen(req) as resp:
        data = json.loads(resp.read().decode('utf-8'))
    items = []
    for item in data['data']:
        if ('type' in item and item['type'] in types):
            items.append(item['link'])
    return items


def download_link(directory, link):
    download_path = directory / os.path.basename(link)
    with urlopen(link) as image, download_path.open('wb') as f:
        f.write(image.read())
    logger.info('Downloaded %s', link)


def setup_download_dir():
    download_dir = Path('./images')
    if not download_dir.exists():
        download_dir.mkdir()
    return download_dir

getlinks = get_links(IMGUR_CLIENT_ID)
print(getlinks)
